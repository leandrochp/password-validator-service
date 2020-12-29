package io.github.leandrochp.passw0rdvalidatorservice.domain.services

import io.github.leandrochp.passw0rdvalidatorservice.domain.handlers.ValidatorHandler
import io.github.leandrochp.passw0rdvalidatorservice.domain.password.Password

class PasswordValidatorService(
    private val passwordHandler: ValidatorHandler
) {

    fun validate(password: Password) = passwordHandler.check(password)
}