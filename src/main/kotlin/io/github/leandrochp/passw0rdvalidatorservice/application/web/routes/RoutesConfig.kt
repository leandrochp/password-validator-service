package io.github.leandrochp.passw0rdvalidatorservice.application.web.routes

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import io.github.leandrochp.passw0rdvalidatorservice.application.web.constants.APPLICATION_JSON_CHARSET_UTF_8
import io.github.leandrochp.passw0rdvalidatorservice.application.web.constants.CONTENT_TYPE
import io.github.leandrochp.passw0rdvalidatorservice.application.web.controllers.PasswordValidatorController
import io.netty.handler.codec.http.HttpResponseStatus
import io.vertx.core.Vertx
import io.vertx.ext.web.Router
import io.vertx.ext.web.handler.BodyHandler
import org.koin.core.KoinComponent
import org.koin.core.inject

object RoutesConfig : KoinComponent {

    private val objectMapper: ObjectMapper by inject()
    private val passwordValidatorController: PasswordValidatorController by inject()

    fun getRoutes(vertx: Vertx): Router {
        val router = Router.router(vertx)
        router.route().handler(BodyHandler.create())

        router.post("/validate").handler {
            val response = passwordValidatorController.validatePassword(objectMapper.readValue(it.bodyAsString))
            it.response()
                .setStatusCode(HttpResponseStatus.OK.code())
                .putHeader(CONTENT_TYPE, APPLICATION_JSON_CHARSET_UTF_8)
                .end(objectMapper.writeValueAsString(response))
        }

        return router
    }
}