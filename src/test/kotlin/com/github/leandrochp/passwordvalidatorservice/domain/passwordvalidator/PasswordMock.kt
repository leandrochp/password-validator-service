package com.github.leandrochp.passwordvalidatorservice.domain.passwordvalidator

import com.github.leandrochp.passwordvalidatorservice.domain.passwordvalidator.Password

object PasswordMock {

    fun sampleValid() = Password("AbTp9!fok")

    fun sampleInValid() = Password("AbTp9 !fok")
}