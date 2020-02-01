
execute "sbt run" from project root

go to "https://websocket.org/echo.html"

set location: "ws://localhost:9000/ws"

set message: to a stock symbol (aapl, abc, dal, nke)

It will return real prices in real time for the stock symbol

Issues to do:
  1. Need to display stock price to index html page
  2. Need to send stock symbol from textfield with submit button on index html page
 
