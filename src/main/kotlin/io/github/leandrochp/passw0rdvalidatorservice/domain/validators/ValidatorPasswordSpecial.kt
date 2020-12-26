package io.github.leandrochp.passw0rdvalidatorservice.domain.validators

class ValidatorPasswordSpecial(private val minSpecialChar: Int,
                               private val validSpecialChar: String) : ValidatorPassword {

    override fun validate(password: String) = if (minSpecialChar > 0) {
        var specialChars = 0
        password.map {
            if (!it.isLetterOrDigit()) specialChars++

            if (!it.isLetterOrDigit() && !isValidSpecialChar(it)) return false
            if (it.isWhitespace()) return false
        }
        minSpecialChar <= specialChars
    } else true

    private fun isValidSpecialChar(specialChar: Char) = validSpecialChar.contains(specialChar)
}
