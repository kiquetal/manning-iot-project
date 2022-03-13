package cresterida.io.manning.vertx.gateway

import cresterida.io.manning.vertx.http.Registration
import cresterida.io.manning.vertx.http.Registration.proccessServer
import io.vertx.core.AbstractVerticle
import io.vertx.core.Promise
import io.vertx.core.http.HttpMethod
import io.vertx.ext.web.Router

class MainVerticle : AbstractVerticle() {


  companion object {
    @JvmStatic
    fun main(s:Array<String>)
    {
     println("")
    }
  }

  override fun start(startPromise: Promise<Void>) {

    val r = Router.router(vertx)

      r.route(HttpMethod.POST,"/register").proccessServer()
      r.post( "/*" ).failureHandler { it.response().end("error") }

  }
  override fun stop(stopPromise: Promise<Void>) {
    stopPromise.complete()
  }



}



