
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/()(implicit request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html lang="en">
<head>
  <title>Stocks</title>
</head>
<body data-ws-url=""""),_display_(/*8.21*/routes/*8.27*/.HomeController.ws.webSocketURL()),format.raw/*8.60*/("""">
  <form id="stock-form">
    <input type="text" value="AAPL" id="stock_symbol"/>
    <button type="submit" onclick="init()">Submit Stock</button>
  </form>
  <div id="msg_holder">
      <script>
          var output;
          function init() """),format.raw/*16.27*/("""{"""),format.raw/*16.28*/("""
              """),format.raw/*17.15*/("""output = document.getElementById("stock_symbol").value;
              websocket = new WebSocket(""""),_display_(/*18.43*/routes/*18.49*/.HomeController.ws.webSocketURL()),format.raw/*18.82*/("""");
          """),format.raw/*19.11*/("""}"""),format.raw/*19.12*/("""
  """),format.raw/*20.3*/("""</script>
</body>
</html>
</html>
"""))
      }
    }
  }

  def render(request:RequestHeader): play.twirl.api.HtmlFormat.Appendable = apply()(request)

  def f:(() => (RequestHeader) => play.twirl.api.HtmlFormat.Appendable) = () => (request) => apply()(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-01-31T20:40:19.536686
                  SOURCE: /Users/jimmy/Documents/Code/scala_projects/clutch/websocket-playframework/app/views/index.scala.html
                  HASH: fd73ac60d6fa86726a905ee7d1b0ddc368ab1a84
                  MATRIX: 736->1|865->37|892->38|1010->130|1024->136|1077->169|1351->415|1380->416|1423->431|1548->529|1563->535|1617->568|1659->582|1688->583|1718->586
                  LINES: 21->1|26->2|27->3|32->8|32->8|32->8|40->16|40->16|41->17|42->18|42->18|42->18|43->19|43->19|44->20
                  -- GENERATED --
              */
          