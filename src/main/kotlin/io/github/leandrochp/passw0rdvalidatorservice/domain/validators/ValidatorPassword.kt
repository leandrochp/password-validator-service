package io.github.leandrochp.passw0rdvalidatorservice.domain.validators

interface ValidatorPassword {

    fun validate(password: String): Boolean
}
