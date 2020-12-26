package io.github.leandrochp.passw0rdvalidatorservice.domain.validators

class ValidatorPasswordUpperCase(private val minUpperCase: Int) : ValidatorPassword {

    override fun validate(password: String) = if (minUpperCase > 0) {
        var upperCases = 0
        password.map {
            if (it.isUpperCase()) upperCases++
        }
        minUpperCase <= upperCases
    } else true
}
