package com.github.leandrochp.passwordvalidatorservice.application.web.controllers

import com.github.leandrochp.passwordvalidatorservice.domain.services.PasswordValidatorService
import com.github.leandrochp.passwordvalidatorservice.utils.mocks.PasswordValidateRequestMock
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class PasswordValidatorControllerTest {

    private val passwordValidatorServiceMock = mockk<PasswordValidatorService>()

    private val passwordValidatorController = PasswordValidatorController(
        passwordValidatorServiceMock
    )

    @Test
    fun `should return true when the password is valid`() {
        every { passwordValidatorServiceMock.validate(any()) } returns true
        val response = assertDoesNotThrow {
            passwordValidatorController.validate(PasswordValidateRequestMock.sampleValid())
        }

        verify { passwordValidatorServiceMock.validate(any()) }

        assertThat(response).isNotNull
        assertThat(response.valid).isEqualTo(true)
    }

    @Test
    fun `should return false when the password is invalid`() {
        every { passwordValidatorServiceMock.validate(any()) } returns false
        val response = assertDoesNotThrow {
            passwordValidatorController.validate(PasswordValidateRequestMock.sampleInValid())
        }

        verify { passwordValidatorServiceMock.validate(any()) }

        assertThat(response).isNotNull
        assertThat(response.valid).isEqualTo(false)
    }
}