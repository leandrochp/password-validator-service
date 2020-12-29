package io.github.leandrochp.passw0rdvalidatorservice.application.extensions

import io.github.leandrochp.passw0rdvalidatorservice.application.web.validators.Validation

fun Validation<String>.isNullOrBlank(): Validation<String> {
    this.fieldValue.takeIf { it.isBlank() }?.run {
        errorMessageList.add("must not be empty or null.")
    }
    return this
}

fun Validation<String>.isInvalidLength(min: Int, max: Int): Validation<String> {
    this.fieldValue.takeIf { it.length < min || it.length > max }?.run {
        errorMessageList.add("must be a min length $min and max length $max")
    }

    return this
}