package io.github.leandrochp.passw0rdvalidatorservice.domain.validators

import io.github.leandrochp.passw0rdvalidatorservice.application.configs.EnvironmentVariablesConfig
import io.github.leandrochp.passw0rdvalidatorservice.domain.mockk.PasswordMockk
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ValidatorLowerCaseTest {

    private val env = mockk<EnvironmentVariablesConfig>()
    private val mock = PasswordMockk.sampleValid()

    @Test
    fun `should return false when the password does not have the minimum allowed`() {

        every { env.validatorPasswordMinLowerCase } returns 555

        val isValid = ValidatorLowerCase(env.validatorPasswordMinLowerCase).validate(mock)
        assertThat(isValid).isEqualTo(false)
    }

    @Test
    fun `should return true when the password does have the minimum allowed`() {

        every { env.validatorPasswordMinLowerCase } returns 5

        val isValid = ValidatorLowerCase(env.validatorPasswordMinLowerCase).validate(mock)
        assertThat(isValid).isEqualTo(true)
    }

}