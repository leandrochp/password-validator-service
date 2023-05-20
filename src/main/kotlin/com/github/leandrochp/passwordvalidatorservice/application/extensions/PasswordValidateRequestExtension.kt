package com.github.leandrochp.passwordvalidatorservice.application.extensions

import com.github.leandrochp.passwordvalidatorservice.application.web.requests.PasswordValidateRequest
import com.github.leandrochp.passwordvalidatorservice.domain.passwordvalidator.Password

fun PasswordValidateRequest.toModel() = Password(this.password)