package com.github.leandrochp.passwordvalidatorservice.application.web.handler

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.HttpMediaTypeNotAcceptableException
import org.springframework.web.HttpMediaTypeNotSupportedException
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class RestResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {

    override fun handleHttpRequestMethodNotSupported(
        ex: HttpRequestMethodNotSupportedException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {

        val apiError = ApiError(
            status = status,
            message = ex.cause?.message ?: ex.message!!
        )
        return buildResponseEntity(apiError)
    }

    override fun handleHttpMediaTypeNotSupported(
        ex: HttpMediaTypeNotSupportedException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {

        val apiError = ApiError(
            status = status,
            message = ex.cause?.message ?: ex.message!!
        )
        return buildResponseEntity(apiError)
    }

    override fun handleHttpMediaTypeNotAcceptable(
        ex: HttpMediaTypeNotAcceptableException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {

        val apiError = ApiError(
            status = status,
            message = ex.cause?.message ?: ex.message!!
        )
        return buildResponseEntity(apiError)
    }

    override fun handleExceptionInternal(
        ex: Exception,
        body: Any?,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {

        val apiError = ApiError(
            status = status,
            message = ex.cause?.message ?: ex.message!!
        )
        return buildResponseEntity(apiError)
    }

    private fun buildResponseEntity(apiError: ApiError) = ResponseEntity<Any>(apiError, apiError.status)
}
