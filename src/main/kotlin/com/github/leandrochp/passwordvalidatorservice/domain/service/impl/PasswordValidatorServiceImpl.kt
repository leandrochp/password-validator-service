package com.github.leandrochp.passwordvalidatorservice.domain.service.impl

import com.github.leandrochp.passwordvalidatorservice.domain.log.LoggableClass
import com.github.leandrochp.passwordvalidatorservice.domain.passwordvalidator.Password
import com.github.leandrochp.passwordvalidatorservice.domain.service.PasswordValidatorService
import com.github.leandrochp.passwordvalidatorservice.domain.validator.PasswordValidator
import org.springframework.stereotype.Service

@Service
class PasswordValidatorServiceImpl: PasswordValidatorService, LoggableClass() {

    override fun validate(password: Password) =
        try {
            logger.debug("Received password to validate: $password")
            PasswordValidator.validate(password.raw)
            logger.debug("The password $password is valid")
            true
        } catch(_: IllegalArgumentException) {
            logger.error("The password $password is not valid")
            false
        }
}
