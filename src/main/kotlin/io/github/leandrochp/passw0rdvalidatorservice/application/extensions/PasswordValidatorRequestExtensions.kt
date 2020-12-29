package io.github.leandrochp.passw0rdvalidatorservice.application.extensions

import io.github.leandrochp.passw0rdvalidatorservice.application.web.requests.ValidateRequest
import io.github.leandrochp.passw0rdvalidatorservice.domain.password.Password

fun ValidateRequest.toPassword() = Password(this.password)