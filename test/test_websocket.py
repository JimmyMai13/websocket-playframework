import pytest
import asyncio
import websockets
from yahoo_fin import stock_info as si


class TestWebsocket:

    @pytest.fixture()
    def setup(self):
        self.ws_url = 'ws://localhost:9000/ws'

    async def connect(self, stock_symbol=None):
        self.connection = await websockets.client.connect(self.ws_url)
        self.sent_and_received_messages = {}
        if self.connection.open:
            for each in stock_symbol:
                await self.sendMessage(each)

                rec_msg = await self.receiveMessage(self.connection)
                if "$" in rec_msg:
                    money_sym_index = rec_msg.find("$")
                    price = float(rec_msg[money_sym_index - len(rec_msg) + 1:])
                    self.sent_and_received_messages[each] = price
                else:
                    self.sent_and_received_messages[each] = rec_msg
        else:
            assert False, "Unable to establish connection with {}".format(self.ws_url)
        return self.connection

    async def sendMessage(self, message):
        print("Message sent to server: '{}'".format(message))
        await self.connection.send(message)

    async def receiveMessage(self, connection):
        message = None
        while not message:
            try:
                message = await connection.recv()
                print("Received message from server: '{}'".format(message))
            except websockets.exceptions.ConnectionClosed:
                print("Connection with server closed")
                break
        return message

    stock_symbol = {"aapl": {"expected": round(si.get_live_price("aapl"), 3)},
                    "dal": {"expected": round(si.get_live_price("dal"), 3)},
                    "nke": {"expected": round(si.get_live_price("nke"), 3)},
                    "zzz": {"expected": "Invalid stock symbol: {}".format("zzz")},
                    "123": {"expected": "Invalid stock symbol: {}".format("123")}}
    @pytest.mark.parametrize('symbol', stock_symbol)
    def test_send_and_receive_websocket_messages(self, setup, symbol):
        loop = asyncio.get_event_loop()
        loop.run_until_complete(self.connect([symbol]))
        print("Assert actual stock price: {} equals expected stock price: {}".format(
            self.sent_and_received_messages[symbol],
            self.stock_symbol[symbol]['expected']))
        assert self.sent_and_received_messages[symbol] == self.stock_symbol[symbol]['expected']
