package io.github.leandrochp.passw0rdvalidatorservice.application.web.controllers

import io.github.leandrochp.passw0rdvalidatorservice.application.extensions.toPassword
import io.github.leandrochp.passw0rdvalidatorservice.application.web.requests.PasswordValidatorRequest
import io.github.leandrochp.passw0rdvalidatorservice.application.web.responses.PasswordValidatorResponse
import io.github.leandrochp.passw0rdvalidatorservice.domain.services.PasswordValidatorService

class PasswordValidatorController(
    private val passwordValidatorService: PasswordValidatorService
) {

    fun validate(passwordValidatorRequest: PasswordValidatorRequest): PasswordValidatorResponse {

        return PasswordValidatorResponse(
            passwordValidatorService.validate(passwordValidatorRequest.toPassword())
        )
    }
}