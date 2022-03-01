package cresterida.io.manning.vertx.mqtt

import io.vertx.circuitbreaker.CircuitBreaker
import io.vertx.core.Future
import io.vertx.core.Promise
import io.vertx.core.Vertx
import io.vertx.mqtt.MqttClient
import io.vertx.mqtt.messages.MqttConnAckMessage
import java.util.*

object MqttManager {

  lateinit var mqttClient: MqttClient
  lateinit var circuitBreaker: CircuitBreaker

  fun getBreaker(vertx: Vertx): CircuitBreaker {

    if (circuitBreaker==null)
      circuitBreaker = TODO()

    return circuitBreaker
  }


  fun startAndConnectMqttClient(vert: Vertx): Future<MqttConnAckMessage> {
    val mqttClient = Optional.ofNullable(System.getenv().getValue("MQTT_CLIENT_ID")).orElse("gateway")
    val mqqtPort = Integer.parseInt(Optional.ofNullable(System.getenv().getValue("MQQT_PORT")).orElse("1883"))
    val mqqtHost = Optional.ofNullable(System.getenv().getValue("MQQT_HOST")).orElse(("mqqt.home.smart"))

    return getBreaker(vert).execute{
      promise -> {

    }
    }


  }
}
