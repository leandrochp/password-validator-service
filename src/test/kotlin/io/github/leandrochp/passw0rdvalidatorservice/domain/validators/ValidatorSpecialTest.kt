package io.github.leandrochp.passw0rdvalidatorservice.domain.validators

import io.github.leandrochp.passw0rdvalidatorservice.application.configs.EnvironmentVariablesConfig
import io.github.leandrochp.passw0rdvalidatorservice.domain.mockk.PasswordMockk
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ValidatorSpecialTest {

    private val env = mockk<EnvironmentVariablesConfig>()
    private val mock = PasswordMockk.sampleValid()

    @Test
    fun `should return false when the password does not have the minimum allowed`() {

        every { env.validatorPasswordMinSpecial } returns 111
        every { env.validatorPasswordValidSpecialChars } returns "!@#$%^&*()-+"

        val isValid = ValidatorSpecial(
            env.validatorPasswordMinSpecial,
            env.validatorPasswordValidSpecialChars
        ).validate(mock)

        assertThat(isValid).isEqualTo(false)
    }

    @Test
    fun `should return false when the password does not have the special char allowed`() {

        every { env.validatorPasswordMinSpecial } returns 1
        every { env.validatorPasswordValidSpecialChars } returns "£@#$%^&*()-+"

        val isValid = ValidatorSpecial(
            env.validatorPasswordMinSpecial,
            env.validatorPasswordValidSpecialChars
        ).validate(mock)

        assertThat(isValid).isEqualTo(false)
    }

    @Test
    fun `should return true when the password does have the minimum and special char allowed`() {

        every { env.validatorPasswordMinSpecial } returns 1
        every { env.validatorPasswordValidSpecialChars } returns "!@#$%^&*()-+"

        val isValid = ValidatorSpecial(
            env.validatorPasswordMinSpecial,
            env.validatorPasswordValidSpecialChars
        ).validate(mock)

        assertThat(isValid).isEqualTo(true)
    }
}