package actors

import akka.actor.{Actor, ActorLogging, ActorRef, Props}
import yahoofinance.YahooFinance


object WebSocketActor {
  def props(out: ActorRef): Props = Props(new WebSocketActor(out))
}

class WebSocketActor(out: ActorRef) extends Actor with ActorLogging {

  def receive = {
    case SendLatestMessage =>
      case stock: String =>
        try{
          var stockprice = YahooFinance.get(stock).getQuote(true).getPrice.toString
          out ! "Real prices retrieved in realtime for stock symbol " + stock + ": $" + stockprice
        } catch {
          case _: Throwable =>
            out ! "Invalid stock symbol: " + stock
        }
  }

}

case object SendLatestMessage

