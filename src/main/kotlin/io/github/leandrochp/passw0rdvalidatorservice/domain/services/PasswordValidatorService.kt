package io.github.leandrochp.passw0rdvalidatorservice.domain.services

import io.github.leandrochp.passw0rdvalidatorservice.domain.handlers.CompletePasswordValidatorHandler
import io.github.leandrochp.passw0rdvalidatorservice.domain.password.Password

class PasswordValidatorService(
    private val passwordHandler: CompletePasswordValidatorHandler
) {

    fun validate(password: Password) = passwordHandler.check(password)
}