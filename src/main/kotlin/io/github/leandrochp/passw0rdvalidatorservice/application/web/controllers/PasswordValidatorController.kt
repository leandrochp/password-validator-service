package io.github.leandrochp.passw0rdvalidatorservice.application.web.controllers

import io.github.leandrochp.passw0rdvalidatorservice.application.extensions.toPassword
import io.github.leandrochp.passw0rdvalidatorservice.application.web.requests.ValidateRequest
import io.github.leandrochp.passw0rdvalidatorservice.application.web.responses.ValidateResponse
import io.github.leandrochp.passw0rdvalidatorservice.application.web.validators.Validator
import io.github.leandrochp.passw0rdvalidatorservice.domain.exceptions.InvalidRequestException
import io.github.leandrochp.passw0rdvalidatorservice.domain.services.PasswordValidatorService

class PasswordValidatorController(
    private val passwordValidatorService: PasswordValidatorService,
    private val validator: Validator<ValidateRequest>
) {

    fun validatePassword(validateRequest: ValidateRequest): ValidateResponse {

        validateRequest(validateRequest)

        return ValidateResponse(
            passwordValidatorService.validate(validateRequest.toPassword())
        )
    }

    private fun validateRequest(validateRequest: ValidateRequest) {
        val errors = validator.validate(validateRequest)

        if (errors.isNotEmpty()) {
            val message = "There are some invalids fields in request."

            throw InvalidRequestException(
                message = message,
                details = errors
            )
        }
    }
}