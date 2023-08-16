package com.github.leandrochp.passwordvalidatorservice.application.extension

import com.github.leandrochp.passwordvalidatorservice.application.web.request.PasswordValidateRequest
import com.github.leandrochp.passwordvalidatorservice.domain.passwordvalidator.Password

fun PasswordValidateRequest.toModel() = Password(this.password)