// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/jimmy/Documents/Code/scala_projects/clutch/websocket-playframework/conf/routes
// @DATE:Fri Jan 31 20:40:19 EST 2020


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
