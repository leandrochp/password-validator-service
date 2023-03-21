package com.github.leandrochp.passwordvalidatorservice.utils.mocks

import com.github.leandrochp.passwordvalidatorservice.domain.password.Password

object PasswordMock {

    fun sampleValid() = Password("AbTp9!fok")

    fun sampleInValid() = Password("AbTp9 !fok")
}