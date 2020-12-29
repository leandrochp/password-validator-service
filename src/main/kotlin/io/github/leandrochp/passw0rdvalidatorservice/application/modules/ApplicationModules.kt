package io.github.leandrochp.passw0rdvalidatorservice.application.modules

import io.github.leandrochp.passw0rdvalidatorservice.application.configs.EnvironmentVariablesConfig
import io.github.leandrochp.passw0rdvalidatorservice.application.configs.configJsonMapper
import io.github.leandrochp.passw0rdvalidatorservice.application.web.handlers.FailureHandlerConfig
import io.github.leandrochp.passw0rdvalidatorservice.application.web.routes.RoutesConfig
import org.koin.dsl.module

val applicationModules = module {
    single { EnvironmentVariablesConfig() }
    single { RoutesConfig }
    single { FailureHandlerConfig }
    single { configJsonMapper() }
}