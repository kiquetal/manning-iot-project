package cresterida.io.manning.vertx.discover

import io.vertx.core.Vertx
import io.vertx.core.json.JsonObject
import io.vertx.servicediscovery.ServiceDiscovery
import io.vertx.servicediscovery.ServiceDiscoveryOptions


class DiscoverManager{


  companion object {


    fun getService(vertObject: Vertx):ServiceDiscovery  {

      return ServiceDiscovery.create(vertObject, ServiceDiscoveryOptions())
      //    .put("connectionString",)))
    }
  }

}
