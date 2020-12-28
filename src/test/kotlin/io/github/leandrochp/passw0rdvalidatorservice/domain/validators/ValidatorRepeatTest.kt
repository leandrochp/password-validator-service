package io.github.leandrochp.passw0rdvalidatorservice.domain.validators

import io.github.leandrochp.passw0rdvalidatorservice.application.configs.EnvironmentVariablesConfig
import io.github.leandrochp.passw0rdvalidatorservice.domain.mockk.PasswordMockk
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ValidatorRepeatTest {

    private val env = mockk<EnvironmentVariablesConfig>()
    private val mock = PasswordMockk.sampleValid()

    @Test
    fun `should return false when the password does not have the minimum allowed`() {

        val mockk = PasswordMockk.sampleValid().copy("AAbTp9!fok")

        every { env.validatorPasswordMinRepeat } returns 0

        val isValid = ValidatorRepeat(env.validatorPasswordMinRepeat).validate(mockk)
        assertThat(isValid).isEqualTo(false)
    }

    @Test
    fun `should return true when the password does have the minimum allowed`() {

        every { env.validatorPasswordMinRepeat } returns 0

        val isValid = ValidatorRepeat(env.validatorPasswordMinRepeat).validate(mock)
        assertThat(isValid).isEqualTo(true)
    }
}