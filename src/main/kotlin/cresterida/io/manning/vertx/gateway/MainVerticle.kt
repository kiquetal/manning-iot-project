package cresterida.io.manning.vertx.gateway

import cresterida.io.manning.vertx.discover.DiscoverManager
import cresterida.io.manning.vertx.http.Registration.proccessServer
import cresterida.io.manning.vertx.mqtt.MqttManager
import io.vertx.core.AbstractVerticle
import io.vertx.core.DeploymentOptions
import io.vertx.core.Promise
import io.vertx.core.Vertx
import io.vertx.core.http.HttpMethod
import io.vertx.core.impl.logging.Logger
import io.vertx.core.impl.logging.LoggerFactory
import io.vertx.ext.web.Router
import io.vertx.servicediscovery.ServiceDiscovery
import io.vertx.servicediscovery.rest.ServiceDiscoveryRestEndpoint

class MainVerticle : AbstractVerticle() {
  private val logger: Logger = LoggerFactory.getLogger(MainVerticle::class.java)
  private lateinit var serviceDiscovery: ServiceDiscovery

  companion object {
    @JvmStatic
    fun main(s: Array<String>) {
      val vertx = Vertx.vertx()
      val mainVerticle = MainVerticle()
      vertx.deployVerticle(mainVerticle, DeploymentOptions().setInstances(1))
    }
  }

  override fun start(startPromise: Promise<Void>) {

    serviceDiscovery = DiscoverManager.getService(vertx)


    val r = Router.router(vertx)
    val mqttManager = MqttManager()
    r.route(HttpMethod.POST, "/register").proccessServer()
    r.get().handler { it.end("hello") }
    r.post("/*").failureHandler {
      logger.error(it.bodyAsString)
      it.response().end("error")
    }
    vertx.createHttpServer()
      .requestHandler(r)
      .listen(8081)
      .onSuccess {
        logger.info("WEB SERVER UP")

        mqttManager.startAndConnectMqttClient(vertx).onSuccess { println(it) }
        startPromise.complete()
      }
      .onFailure(startPromise::fail)


  }

  override fun stop(stopPromise: Promise<Void>) {
    serviceDiscovery.close()
    stopPromise.complete()
  }

}



