package cresterida.io.manning.vertx.http

import io.vertx.core.Future
import io.vertx.core.Handler
import io.vertx.core.Promise
import io.vertx.core.Vertx
import io.vertx.core.http.HttpMethod
import io.vertx.core.json.Json
import io.vertx.ext.web.Route
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext
import io.vertx.kotlin.core.json.json
import io.vertx.kotlin.core.json.jsonObjectOf
import java.util.concurrent.CompletableFuture

 object Registration {



    fun obtainFuture(): CompletableFuture<String> {

      return CompletableFuture.completedFuture("kiquetal")
    }



  fun Route.proccessServer() {
    handler { ctx: RoutingContext ->
      println("recibido")
      val obj = json { jsonObjectOf("name" to "kiquetal-soy yo") }
      ctx.response().putHeader("Content-type","application/json")
      ctx.response().end(obj.encode())
    }
  }

  }




