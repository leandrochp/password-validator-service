package com.github.leandrochp.passwordvalidatorservice.domain.service

import com.github.leandrochp.passwordvalidatorservice.domain.passwordvalidator.Password

interface PasswordValidatorService {

    fun validate(password: Password): Boolean
}