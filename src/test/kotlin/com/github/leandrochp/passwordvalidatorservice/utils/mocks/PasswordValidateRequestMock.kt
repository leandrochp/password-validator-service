package com.github.leandrochp.passwordvalidatorservice.utils.mocks

import com.github.leandrochp.passwordvalidatorservice.application.web.requests.PasswordValidateRequest

object PasswordValidateRequestMock {

    fun sampleValid() = PasswordValidateRequest("AbTp9!fok")

    fun sampleInValid() = PasswordValidateRequest("AbTp9 !fok")
}