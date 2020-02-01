package controllers

import actors._
import akka.actor._
import akka.stream._
import javax.inject._
import play.api.libs.streams.ActorFlow
import play.api.mvc._


@Singleton
class HomeController @Inject()(implicit actorSystem: ActorSystem,
                               materializer: Materializer,
                               val controllerComponents: ControllerComponents
                              ) extends BaseController {

  def index = Action { implicit request =>
    Ok(views.html.index())
  }


  def ws: WebSocket = WebSocket.accept[String, String] { request =>
    ActorFlow.actorRef(out => WebSocketActor.props(out))
  }

}






