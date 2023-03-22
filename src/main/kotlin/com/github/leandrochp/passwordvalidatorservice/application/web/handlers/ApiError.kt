package com.github.leandrochp.passwordvalidatorservice.application.web.handlers

import org.springframework.http.HttpStatus
import java.time.LocalDateTime

data class ApiError(
    val status: HttpStatus,
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val message: String,
    val details: Map<String, Any>? = null
)
