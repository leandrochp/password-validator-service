package io.github.leandrochp.passw0rdvalidatorservice.domain.handlers

import io.github.leandrochp.passw0rdvalidatorservice.domain.password.Password
import io.github.leandrochp.passw0rdvalidatorservice.domain.validators.Validator

abstract class ValidatorHandler(
    val validators: List<Validator<Password>>
) {

    abstract fun check(password: Password): Boolean
}