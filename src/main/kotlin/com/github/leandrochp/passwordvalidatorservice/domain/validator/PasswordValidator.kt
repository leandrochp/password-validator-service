package com.github.leandrochp.passwordvalidatorservice.domain.validator

object PasswordValidator {

    fun validate(value: String) = require(
        value.length > 8
                && value.toCharArray().any { it.isDigit() }
                && value.toCharArray().any { it.isLowerCase() }
                && value.toCharArray().any { it.isUpperCase() }
                && value.toCharArray().any { "!@#\$%^&*()-+".toCharArray().contains(it) }
                && value.toCharArray().distinct().size == value.toCharArray().size
                && value.toCharArray().none { it == ' ' }
    )

}