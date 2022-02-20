package cresterida.io.manning.vertx.gateway

import io.vertx.core.AbstractVerticle
import io.vertx.core.Promise

class MainVerticle : AbstractVerticle() {


  override fun start(startPromise: Promise<Void>) {

  }
  override fun stop(stopPromise: Promise<Void>) {
    stopPromise.complete()
  }
}
