package cresterida.io.manning.vertx.mqtt

import io.netty.handler.codec.mqtt.MqttConnectReturnCode
import io.netty.handler.codec.mqtt.MqttQoS
import io.vertx.circuitbreaker.CircuitBreaker
import io.vertx.circuitbreaker.CircuitBreakerOptions
import io.vertx.core.Future
import io.vertx.core.Handler
import io.vertx.core.Promise
import io.vertx.core.Vertx
import io.vertx.core.buffer.Buffer
import io.vertx.core.json.JsonObject
import io.vertx.mqtt.MqttClient
import io.vertx.mqtt.MqttServer
import io.vertx.mqtt.messages.MqttConnAckMessage
import io.vertx.servicediscovery.ServiceDiscovery
import io.vertx.servicediscovery.ServiceDiscoveryOptions
import java.util.*

class MqttManager {

  lateinit var mqttClient: MqttClient
  lateinit var circuitBreaker: CircuitBreaker

  fun getBreaker(vertx: Vertx): CircuitBreaker {

    if (circuitBreaker==null)
      circuitBreaker = CircuitBreaker.create("my-circuite-breaker",vertx,
      CircuitBreakerOptions()
        .setMaxFailures(5)
        .setMaxRetries(3)
        .setTimeout(2000)
        .setFallbackOnFailure(true)
        .setResetTimeout(1000)
      ).openHandler{
        println("Circuit open!!")
      }
        .closeHandler { println("Circuit closed!") }.retryPolicy{ it * 100L}

    return circuitBreaker
  }


  fun startAndConnectMqttClient(vert: Vertx): Future<MqttConnAckMessage> {
    val mqqtPort = 1883
    val mqqtHost = "localhost"
    return getBreaker(vert).execute { v: Promise<MqttConnAckMessage> ->
      try {
        mqttClient = MqttClient.create(vert)
        mqttClient.connect(mqqtPort, mqqtHost)
          .onSuccess {
             v.complete(MqttConnAckMessage.create(MqttConnectReturnCode.CONNECTION_ACCEPTED,false))
        }.onFailure {
            println("here error")
            v.fail(it) }

      } catch (e: Exception) {
        println(e.message)
        v.fail(e.cause)
      }

    }
  }
  fun sendMessage(message:String)  {




  }

}
