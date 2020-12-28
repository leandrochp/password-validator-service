package io.github.leandrochp.passw0rdvalidatorservice.domain.validators

import io.github.leandrochp.passw0rdvalidatorservice.application.configs.EnvironmentVariablesConfig
import io.github.leandrochp.passw0rdvalidatorservice.domain.mockk.PasswordMockk
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ValidatorDigitTest {

    private val env = mockk<EnvironmentVariablesConfig>()
    private val mock = PasswordMockk.sampleValid()

    @Test
    fun `should return false when the password does not have the minimum allowed`() {

        every { env.validatorPasswordMinDigits } returns 111

        val isValid = ValidatorDigit(env.validatorPasswordMinDigits).validate(mock)
        assertThat(isValid).isEqualTo(false)
    }

    @Test
    fun `should return true when the password does have the minimum allowed`() {

        every { env.validatorPasswordMinDigits } returns 1

        val isValid = ValidatorDigit(env.validatorPasswordMinDigits).validate(mock)
        assertThat(isValid).isEqualTo(true)
    }
}