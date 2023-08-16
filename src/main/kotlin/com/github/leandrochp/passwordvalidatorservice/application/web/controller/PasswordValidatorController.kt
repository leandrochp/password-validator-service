package com.github.leandrochp.passwordvalidatorservice.application.web.controller

import com.github.leandrochp.passwordvalidatorservice.application.extension.toModel
import com.github.leandrochp.passwordvalidatorservice.application.web.request.PasswordValidateRequest
import com.github.leandrochp.passwordvalidatorservice.application.web.response.PasswordValidateResponse
import com.github.leandrochp.passwordvalidatorservice.domain.service.PasswordValidatorService
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