package io.github.leandrochp.passw0rdvalidatorservice.application.configs

import com.natpryce.konfig.Configuration
import com.natpryce.konfig.EnvironmentVariables
import com.natpryce.konfig.intType
import com.natpryce.konfig.stringType
import com.natpryce.konfig.getValue

class EnvironmentVariablesConfig(
    configuration: Configuration = EnvironmentVariables()
) {

    val serverPort = configuration[SERVER_PORT]

    val validatorPasswordMinLength = configuration[VALIDATOR_PASSWORD_MIN_LENGTH]
    val validatorPasswordMinLowerCase = configuration[VALIDATOR_PASSWORD_MIN_LOWERCASE]
    val validatorPasswordMinUpperCase = configuration[VALIDATOR_PASSWORD_MIN_UPPERCASE]
    val validatorPasswordMinDigits = configuration[VALIDATOR_PASSWORD_MIN_DIGITS]
    val validatorPasswordMinSpecial = configuration[VALIDATOR_PASSWORD_MIN_SPECIAL]
    val validatorPasswordValidSpecialChars = configuration[VALIDATOR_PASSWORD_VALID_SPECIAL_CHARS]
    val validatorPasswordMinRepeat = configuration[VALIDATOR_PASSWORD_MIN_REPEAT]

    companion object {

        private val SERVER_PORT by intType

        private val VALIDATOR_PASSWORD_MIN_LENGTH by intType
        private val VALIDATOR_PASSWORD_MIN_LOWERCASE by intType
        private val VALIDATOR_PASSWORD_MIN_UPPERCASE by intType
        private val VALIDATOR_PASSWORD_MIN_DIGITS by intType
        private val VALIDATOR_PASSWORD_MIN_SPECIAL by intType
        private val VALIDATOR_PASSWORD_VALID_SPECIAL_CHARS by stringType
        private val VALIDATOR_PASSWORD_MIN_REPEAT by intType
    }

}