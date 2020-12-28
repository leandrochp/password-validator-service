package io.github.leandrochp.passw0rdvalidatorservice.application.modules

import io.github.leandrochp.passw0rdvalidatorservice.domain.services.PasswordValidatorService
import org.koin.dsl.module

val serviceModules = module {
    single { PasswordValidatorService(get()) }
}