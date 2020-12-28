package io.github.leandrochp.passw0rdvalidatorservice.domain.validators

import io.github.leandrochp.passw0rdvalidatorservice.domain.password.Password

class ValidatorSpecial(
    private val minSpecialChar: Int,
    private val validSpecialChar: String) : Validator<Password> {

    override fun validate(password: Password) = if (minSpecialChar > 0) {
        var specialChars = 0
        password.raw.map {
            if (!it.isLetterOrDigit()) specialChars++

            if (!it.isLetterOrDigit() && !isValidSpecialChar(it)) return false
            if (it.isWhitespace()) return false
        }
        minSpecialChar <= specialChars
    } else true

    private fun isValidSpecialChar(char: Char) = validSpecialChar.contains(char)
}
