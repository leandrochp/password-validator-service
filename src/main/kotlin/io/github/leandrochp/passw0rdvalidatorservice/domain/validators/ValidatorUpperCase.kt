package io.github.leandrochp.passw0rdvalidatorservice.domain.validators

import io.github.leandrochp.passw0rdvalidatorservice.domain.password.Password

class ValidatorUpperCase(private val minUpperCase: Int) : Validator<Password> {

    override fun validate(password: Password) = if (minUpperCase > 0) {
        var upperCases = 0
        password.raw.map {
            if (it.isUpperCase()) upperCases++
        }
        minUpperCase <= upperCases
    } else true
}
