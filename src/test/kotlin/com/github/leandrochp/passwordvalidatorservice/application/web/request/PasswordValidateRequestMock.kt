package com.github.leandrochp.passwordvalidatorservice.application.web.request

object PasswordValidateRequestMock {

    fun sampleValid() = PasswordValidateRequest("AbTp9!fok")

    fun sampleInValid() = PasswordValidateRequest("AbTp9 !fok")
}