package com.github.leandrochp.passwordvalidatorservice.domain.validators

import com.github.leandrochp.passwordvalidatorservice.domain.passwordvalidator.PasswordMock
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class PasswordValidatorTest {

    @Test
    fun `given a valid password should does not throw exception`() {
        assertDoesNotThrow {
            PasswordValidator.validate(PasswordMock.sampleValid().toString())
        }
    }

    @Test
    fun `given an invalid password should throw IllegalArgumentException`() {
        assertThrows<IllegalArgumentException> {
            PasswordValidator.validate(PasswordMock.sampleInValid().toString())
        }
    }
}