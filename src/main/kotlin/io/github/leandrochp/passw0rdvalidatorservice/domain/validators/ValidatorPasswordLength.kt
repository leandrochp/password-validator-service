package io.github.leandrochp.passw0rdvalidatorservice.domain.validators

class ValidatorPasswordLength(private val minLength: Int) : ValidatorPassword {

    override fun validate(password: String) = if (minLength > 0) {
        minLength <= password.length
    } else true
}
