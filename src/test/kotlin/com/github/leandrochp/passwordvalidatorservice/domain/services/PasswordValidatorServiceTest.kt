package com.github.leandrochp.passwordvalidatorservice.domain.services

import com.github.leandrochp.passwordvalidatorservice.domain.services.impl.PasswordValidatorServiceImpl
import com.github.leandrochp.passwordvalidatorservice.domain.passwordvalidator.PasswordMock
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PasswordValidatorServiceTest {

    private val passwordValidatorService = PasswordValidatorServiceImpl()

    @Test
    fun `should return true when the password is valid`() {

        assertEquals(
            true,
            passwordValidatorService.validate(PasswordMock.sampleValid())
        )
    }

    @Test
    fun `should return false when the password is invalid`() {

        assertEquals(
            false,
            passwordValidatorService.validate(PasswordMock.sampleInValid())
        )
    }
}