package com.github.leandrochp.passwordvalidatorservice.application.web.controllers

import com.github.leandrochp.passwordvalidatorservice.application.extensions.toModel
import com.github.leandrochp.passwordvalidatorservice.application.web.requests.PasswordValidateRequest
import com.github.leandrochp.passwordvalidatorservice.application.web.responses.PasswordValidateResponse
import com.github.leandrochp.passwordvalidatorservice.domain.services.PasswordValidatorService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.constraints.NotNull

@RestController
class PasswordValidatorController(
    private val passwordValidatorService: PasswordValidatorService
) {

    @PostMapping("/validate")
    fun validate(@NotNull @RequestBody request: PasswordValidateRequest) =
        PasswordValidateResponse(passwordValidatorService.validate(request.toModel()))
}