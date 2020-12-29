package io.github.leandrochp.passw0rdvalidatorservice.application.modules

import io.github.leandrochp.passw0rdvalidatorservice.application.web.controllers.PasswordValidatorController
import org.koin.dsl.module

val controllerModules = module {
    single { PasswordValidatorController(get(), get()) }
}