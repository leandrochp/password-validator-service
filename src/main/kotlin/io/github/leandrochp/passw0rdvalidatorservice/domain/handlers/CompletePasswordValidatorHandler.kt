package io.github.leandrochp.passw0rdvalidatorservice.domain.handlers

import io.github.leandrochp.passw0rdvalidatorservice.domain.password.Password
import io.github.leandrochp.passw0rdvalidatorservice.domain.validators.Validator

class CompletePasswordValidatorHandler(
    validators: List<Validator<Password>>
) : ValidatorHandler(validators) {

    override fun check(password: Password): Boolean {
        validators.map {
            if (!it.validate(password)) return false
        }
        return true
    }
}
