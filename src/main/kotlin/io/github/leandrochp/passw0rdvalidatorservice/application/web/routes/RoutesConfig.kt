package io.github.leandrochp.passw0rdvalidatorservice.application.web.routes

import io.github.leandrochp.passw0rdvalidatorservice.application.web.controllers.PasswordValidatorController
import io.github.leandrochp.passw0rdvalidatorservice.application.web.requests.PasswordValidatorRequest
import io.netty.handler.codec.http.HttpResponseStatus
import io.vertx.core.Vertx
import io.vertx.ext.web.Router
import io.vertx.ext.web.handler.BodyHandler
import org.koin.core.KoinComponent
import org.koin.core.inject

object RoutesConfig : KoinComponent {

    private val passwordValidatorController: PasswordValidatorController by inject()

    fun getRoutes(vertx: Vertx): Router {
        val router = Router.router(vertx)
        router.route().handler(BodyHandler.create())

        router.get("/validate/:password").handler {
            val response = passwordValidatorController.validate(
                PasswordValidatorRequest(it.pathParam("password"))
            )
            it.response()
                .setStatusCode(HttpResponseStatus.OK.code())
                .end(response.valid.toString())
        }

        return router
    }
}