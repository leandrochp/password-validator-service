package io.github.leandrochp.passw0rdvalidatorservice.application.extensions

import io.github.leandrochp.passw0rdvalidatorservice.application.web.requests.PasswordValidatorRequest
import io.github.leandrochp.passw0rdvalidatorservice.domain.password.Password

fun PasswordValidatorRequest.toPassword() = Password(this.raw)