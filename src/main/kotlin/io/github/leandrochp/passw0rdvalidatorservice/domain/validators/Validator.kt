package io.github.leandrochp.passw0rdvalidatorservice.domain.validators

interface Validator<T> {

    fun validate(password: T): Boolean
}
