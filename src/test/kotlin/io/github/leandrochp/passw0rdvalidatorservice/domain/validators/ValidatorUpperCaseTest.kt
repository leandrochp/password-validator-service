package io.github.leandrochp.passw0rdvalidatorservice.domain.validators

import io.github.leandrochp.passw0rdvalidatorservice.application.configs.EnvironmentVariablesConfig
import io.github.leandrochp.passw0rdvalidatorservice.domain.mockk.PasswordMockk
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ValidatorUpperCaseTest {

    private val env = mockk<EnvironmentVariablesConfig>()
    private val mock = PasswordMockk.sampleValid()

    @Test
    fun `should return false when the password does have the minimum allowed`() {

        every { env.validatorPasswordMinUpperCase } returns 222

        val isValid = ValidatorUpperCase(env.validatorPasswordMinUpperCase).validate(mock)
        assertThat(isValid).isEqualTo(false)
    }

    @Test
    fun `should return true when the password does have the minimum allowed`() {

        every { env.validatorPasswordMinUpperCase } returns 2

        val isValid = ValidatorUpperCase(env.validatorPasswordMinUpperCase).validate(mock)
        assertThat(isValid).isEqualTo(true)
    }
}