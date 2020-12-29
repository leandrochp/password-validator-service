package io.github.leandrochp.passw0rdvalidatorservice.application.web.validators

interface Validator<T> {

    fun validate(request: T): Map<String, List<String>>
}
