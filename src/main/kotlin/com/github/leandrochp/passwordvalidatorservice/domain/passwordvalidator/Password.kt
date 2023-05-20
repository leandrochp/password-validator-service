package com.github.leandrochp.passwordvalidatorservice.domain.passwordvalidator

data class Password(val raw: String) {

    override fun toString(): String {
        return raw
    }
}
