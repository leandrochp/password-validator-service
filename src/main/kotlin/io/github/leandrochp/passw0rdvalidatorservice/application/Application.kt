package io.github.leandrochp.passw0rdvalidatorservice.application

import io.vertx.core.Vertx
import io.vertx.ext.web.Router

object Application {

    fun start() {
        val vertx = Vertx.vertx()
        val router = Router.router(vertx)
        val server = vertx.createHttpServer()

        router.get("/").handler {
            it.response().end("Welcome to Vert.x HTTP Server")
        }

        server.requestHandler(router).listen(8080) {
            if (it.failed()) {
                println("HTTP Server error ${it.cause()}")
            } else {
                println("HTTP Server started on port 8080")
            }
        }
    }
}

