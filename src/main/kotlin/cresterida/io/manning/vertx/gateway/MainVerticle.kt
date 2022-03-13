package cresterida.io.manning.vertx.gateway

import cresterida.io.manning.vertx.http.Registration.proccessServer
import io.vertx.core.AbstractVerticle
import io.vertx.core.DeploymentOptions
import io.vertx.core.Promise
import io.vertx.core.Vertx
import io.vertx.core.http.HttpMethod
import io.vertx.core.impl.logging.LoggerFactory
import io.vertx.ext.web.Router

class MainVerticle : AbstractVerticle() {

  val logger = LoggerFactory.getLogger(MainVerticle::class.java)

  companion object {
    @JvmStatic
    fun main(s:Array<String>)
    {
      val vertx = Vertx.vertx()
      val mainVerticle = MainVerticle()
      vertx.deployVerticle(mainVerticle, DeploymentOptions().setInstances(1))
    }
  }

  override fun start(startPromise: Promise<Void>) {

    val r = Router.router(vertx)

      r.route(HttpMethod.POST,"/register").proccessServer()
      r.get().handler {  it.end("hello") }
      r.post( "/*" ).failureHandler { it.response().end("error") }
    vertx.createHttpServer()
      .requestHandler(r)
      .listen(8081)
      .onSuccess {
        logger.info("WEB SERVER UP")

        startPromise.complete() }
      .onFailure(startPromise::fail)


  }
  override fun stop(stopPromise: Promise<Void>) {
    stopPromise.complete()
  }



}



