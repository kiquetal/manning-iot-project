package cresterida.io.manning.vertx.http

import io.vertx.core.Future
import io.vertx.core.Handler
import io.vertx.core.Promise
import io.vertx.core.Vertx
import io.vertx.core.http.HttpMethod
import io.vertx.ext.web.Route
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext
import java.util.concurrent.CompletableFuture

 object Registration {



    fun obtainFuture(): CompletableFuture<String> {

      return CompletableFuture.completedFuture("kiquetal")
    }



  fun Route.proccessServer() {
    handler { ctx: RoutingContext ->
      ctx.response().end(ctx.body)
    }
  }

  }




