package io.github.leandrochp.passw0rdvalidatorservice.domain.validators

class ValidatorPasswordDigit(private val minDigit: Int) : ValidatorPassword {

    override fun validate(password: String) = if (minDigit > 0) {
        var digits = 0
        password.map {
            if (it.isDigit()) digits++
        }
        minDigit <= digits
    } else true
}
