package cresterida.io.manning.vertx.http

import io.vertx.core.Future
import io.vertx.core.Promise
import java.util.concurrent.CompletableFuture

open class Registration {


  companion object {
    @JvmStatic
    fun main(args:Array<String>)
    {
      println("let test it")



    }
    fun obtainFuture(): CompletableFuture<String> {

      return CompletableFuture.completedFuture("kiquetal")
    }
  }


}
