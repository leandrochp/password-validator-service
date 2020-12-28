package io.github.leandrochp.passw0rdvalidatorservice.domain.validators

import io.github.leandrochp.passw0rdvalidatorservice.domain.password.Password


class ValidatorDigit(private val minDigit: Int) : Validator<Password> {

    override fun validate(password: Password) = if (minDigit > 0) {
        var digits = 0
        password.raw.map {
            if (it.isDigit()) digits++
        }
        minDigit <= digits
    } else true
}
