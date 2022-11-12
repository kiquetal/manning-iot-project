package cresterida.io.manning.vertx.http


import io.vertx.ext.web.Route
import io.vertx.ext.web.RoutingContext
import io.vertx.ext.web.handler.BodyHandler
import io.vertx.kotlin.core.json.get
import io.vertx.kotlin.core.json.jsonObjectOf
import java.util.concurrent.CompletableFuture

 object Registration {



    fun obtainFuture(): CompletableFuture<String> {

      return CompletableFuture.completedFuture("kiquetal")
    }



  fun Route.proccessServer() {
    handler(BodyHandler.create())
    handler { ctx: RoutingContext ->
      val myBody = ctx.bodyAsJson
      val allqueries = ctx.request().params()
      val name:String = myBody["some"]
      println(name)
      println("params[${allqueries}]")
      val obj =  jsonObjectOf("name" to "kiquetal-soy yo")
      ctx.response().putHeader("Content-type","application/json")
      ctx.response().end(obj.encode())
    }
  }

  }

  fun Route.processRegistration() {


  }


