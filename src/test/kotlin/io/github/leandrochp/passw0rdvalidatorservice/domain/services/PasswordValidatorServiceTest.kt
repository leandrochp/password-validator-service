package io.github.leandrochp.passw0rdvalidatorservice.domain.services

import io.github.leandrochp.passw0rdvalidatorservice.domain.handlers.CompletePasswordValidatorHandler
import io.github.leandrochp.passw0rdvalidatorservice.domain.mockk.PasswordMockk
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class PasswordValidatorServiceTest {

    private val handler = mockk<CompletePasswordValidatorHandler>()
    private val service = PasswordValidatorService(handler)

    private val mock = PasswordMockk.sampleValid()

    @Test
    fun `should return true when the password is valid`() {

        every { handler.check(any()) } returns true

        service.validate(mock)
        verify { handler.check(mock) }
    }
}