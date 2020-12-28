package io.github.leandrochp.passw0rdvalidatorservice.domain.validators

import io.github.leandrochp.passw0rdvalidatorservice.domain.password.Password

class ValidatorLength(private val minLength: Int) : Validator<Password> {

    override fun validate(password: Password) = if (minLength > 0) {
        minLength <= password.raw.length
    } else true
}
