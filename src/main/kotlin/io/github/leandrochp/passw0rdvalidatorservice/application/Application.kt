package io.github.leandrochp.passw0rdvalidatorservice.application

import io.github.leandrochp.passw0rdvalidatorservice.application.configs.EnvironmentVariablesConfig
import io.github.leandrochp.passw0rdvalidatorservice.application.modules.applicationModules
import io.github.leandrochp.passw0rdvalidatorservice.application.modules.controllerModules
import io.github.leandrochp.passw0rdvalidatorservice.application.modules.serviceModules
import io.github.leandrochp.passw0rdvalidatorservice.application.modules.validatorModules
import io.github.leandrochp.passw0rdvalidatorservice.application.web.handlers.FailureHandlerConfig
import io.github.leandrochp.passw0rdvalidatorservice.application.web.routes.RoutesConfig
import io.vertx.core.Vertx
import io.vertx.core.VertxOptions
import org.koin.core.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.inject
import java.util.concurrent.TimeUnit

object Application : KoinComponent {

    private val environmentVariablesConfig: EnvironmentVariablesConfig by inject()
    private val routesConfig: RoutesConfig by inject()
    private val failureHandlerConfig: FailureHandlerConfig by inject()

    fun start() {
        startKoin {
            modules(
                applicationModules,
                controllerModules,
                serviceModules,
                validatorModules
            )
        }
        loadServer()
    }

    private fun loadServer() {
        val options = configureOptions()
        val vertx = Vertx.vertx(options)

        val server = vertx.createHttpServer()
        val port = environmentVariablesConfig.serverPort
        val router = configureRoutes(vertx)

        server.requestHandler(router).listen(port) {
            if (it.succeeded()) {
                println("passw0rd-validator-service started on port $port")
            } else {
                println("an error occurred when trie to start passw0rd-validator-service: ${it.cause()}")
            }
        }
    }

    private fun configureOptions() = VertxOptions().apply {
        blockedThreadCheckInterval = 5
        blockedThreadCheckIntervalUnit = TimeUnit.SECONDS

        maxEventLoopExecuteTime = 100
        maxEventLoopExecuteTimeUnit = TimeUnit.MILLISECONDS

        maxWorkerExecuteTime = 10
        maxWorkerExecuteTimeUnit = TimeUnit.SECONDS

        warningExceptionTime = 20
        warningExceptionTimeUnit = TimeUnit.SECONDS
    }

    private fun configureRoutes(vertx: Vertx) = routesConfig.getRoutes(vertx)
        .also { failureHandlerConfig.handle(it) }
}

