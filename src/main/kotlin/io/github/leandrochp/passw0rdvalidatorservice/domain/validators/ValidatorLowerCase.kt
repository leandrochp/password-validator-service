package io.github.leandrochp.passw0rdvalidatorservice.domain.validators

import io.github.leandrochp.passw0rdvalidatorservice.domain.password.Password

class ValidatorLowerCase(private val minLowerCase: Int) : Validator<Password> {

    override fun validate(password: Password) = if (minLowerCase > 0) {
        var lowerCases = 0
        password.raw.map {
            if (it.isLowerCase()) lowerCases++
        }
        minLowerCase <= lowerCases
    } else true
}
