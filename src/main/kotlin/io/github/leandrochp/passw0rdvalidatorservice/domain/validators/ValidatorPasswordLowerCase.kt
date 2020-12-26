package io.github.leandrochp.passw0rdvalidatorservice.domain.validators

class ValidatorPasswordLowerCase(private val minLowerCase: Int) : ValidatorPassword {

    override fun validate(password: String) = if (minLowerCase > 0) {
        var lowerCases = 0
        password.map {
            if (it.isLowerCase()) lowerCases++
        }
        minLowerCase <= lowerCases
    } else true
}
