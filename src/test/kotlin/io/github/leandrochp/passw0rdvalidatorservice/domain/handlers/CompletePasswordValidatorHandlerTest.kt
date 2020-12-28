package io.github.leandrochp.passw0rdvalidatorservice.domain.handlers

import io.github.leandrochp.passw0rdvalidatorservice.domain.mockk.PasswordMockk
import io.github.leandrochp.passw0rdvalidatorservice.domain.mockk.ValidatorMockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class CompletePasswordValidatorHandlerTest {

    private val validators = ValidatorMockk.sampleAll()
    private val handler = CompletePasswordValidatorHandler(validators)

    private val mock = PasswordMockk.sampleValid()

    @Test
    fun `should return false when the password has blank character`() {

        val mock = PasswordMockk.sampleValid().copy("AbTp9! fok")

        val isValid = handler.check(mock)
        assertThat(isValid).isEqualTo(false)
    }

    @Test
    fun `should return true when the password has all settings validated`() {

        val isValid = handler.check(mock)
        assertThat(isValid).isEqualTo(true)
    }
}