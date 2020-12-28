package io.github.leandrochp.passw0rdvalidatorservice.domain.validators

import io.github.leandrochp.passw0rdvalidatorservice.domain.password.Password

class ValidatorRepeat(private val minRepeat: Int) : Validator<Password> {

    override fun validate(password: Password) = if (minRepeat > -1) {
        var repeated = 0
        val chars = mutableListOf<Char>()

        password.raw.map {
            if (chars.contains(it)) repeated++ else chars.add(it)
        }
        minRepeat >= repeated
    } else true
}

