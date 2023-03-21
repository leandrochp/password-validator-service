package com.github.leandrochp.passwordvalidatorservice.domain.password

data class Password(val raw: String) {

    override fun toString(): String {
        return raw
    }
}
