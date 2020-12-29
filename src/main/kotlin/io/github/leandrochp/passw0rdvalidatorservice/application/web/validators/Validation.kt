package io.github.leandrochp.passw0rdvalidatorservice.application.web.validators

data class Validation<T>(
    val fieldName: String,
    val fieldValue: T,
    val errorMessageList: MutableList<String> = mutableListOf()
)

