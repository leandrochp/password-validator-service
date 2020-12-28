package io.github.leandrochp.passw0rdvalidatorservice.application.modules

import io.github.leandrochp.passw0rdvalidatorservice.application.configs.EnvironmentVariablesConfig
import io.github.leandrochp.passw0rdvalidatorservice.domain.handlers.CompletePasswordValidatorHandler
import io.github.leandrochp.passw0rdvalidatorservice.domain.validators.ValidatorDigit
import io.github.leandrochp.passw0rdvalidatorservice.domain.validators.ValidatorLength
import io.github.leandrochp.passw0rdvalidatorservice.domain.validators.ValidatorLowerCase
import io.github.leandrochp.passw0rdvalidatorservice.domain.validators.ValidatorRepeat
import io.github.leandrochp.passw0rdvalidatorservice.domain.validators.ValidatorSpecial
import io.github.leandrochp.passw0rdvalidatorservice.domain.validators.ValidatorUpperCase
import org.koin.dsl.module

val validatorModules = module {
    single { CompletePasswordValidatorHandler(
        listOf(
            ValidatorLength(get<EnvironmentVariablesConfig>().validatorPasswordMinLength),
            ValidatorLowerCase(get<EnvironmentVariablesConfig>().validatorPasswordMinLowerCase),
            ValidatorUpperCase(get<EnvironmentVariablesConfig>().validatorPasswordMinUpperCase),
            ValidatorDigit(get<EnvironmentVariablesConfig>().validatorPasswordMinDigits),
            ValidatorSpecial(
                get<EnvironmentVariablesConfig>().validatorPasswordMinSpecial,
                get<EnvironmentVariablesConfig>().validatorPasswordValidSpecialChars
            ),
            ValidatorRepeat(get<EnvironmentVariablesConfig>().validatorPasswordMinRepeat)
        )
    ) }
}
