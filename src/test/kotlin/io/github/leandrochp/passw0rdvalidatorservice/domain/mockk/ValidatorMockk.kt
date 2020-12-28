package io.github.leandrochp.passw0rdvalidatorservice.domain.mockk

import io.github.leandrochp.passw0rdvalidatorservice.domain.validators.ValidatorDigit
import io.github.leandrochp.passw0rdvalidatorservice.domain.validators.ValidatorLength
import io.github.leandrochp.passw0rdvalidatorservice.domain.validators.ValidatorLowerCase
import io.github.leandrochp.passw0rdvalidatorservice.domain.validators.ValidatorRepeat
import io.github.leandrochp.passw0rdvalidatorservice.domain.validators.ValidatorSpecial
import io.github.leandrochp.passw0rdvalidatorservice.domain.validators.ValidatorUpperCase

object ValidatorMockk {

    fun sampleAll() = listOf(
        ValidatorLength(VALIDATOR_PASSWORD_MIN_LENGTH),
        ValidatorLowerCase(VALIDATOR_PASSWORD_MIN_LOWERCASE),
        ValidatorUpperCase(VALIDATOR_PASSWORD_MIN_UPPERCASE),
        ValidatorDigit(VALIDATOR_PASSWORD_MIN_DIGITS),
        ValidatorSpecial(
            VALIDATOR_PASSWORD_MIN_SPECIAL,
            VALIDATOR_PASSWORD_VALID_SPECIAL_CHARS
        ),
        ValidatorRepeat(VALIDATOR_PASSWORD_MIN_REPEAT)
    )

    private const val VALIDATOR_PASSWORD_MIN_LENGTH = 9
    private const val VALIDATOR_PASSWORD_MIN_LOWERCASE = 1
    private const val VALIDATOR_PASSWORD_MIN_UPPERCASE = 1
    private const val VALIDATOR_PASSWORD_MIN_DIGITS = 1
    private const val VALIDATOR_PASSWORD_MIN_SPECIAL = 1
    private const val VALIDATOR_PASSWORD_VALID_SPECIAL_CHARS = "!@#$%^&*()-+"
    private const val VALIDATOR_PASSWORD_MIN_REPEAT = 0

}