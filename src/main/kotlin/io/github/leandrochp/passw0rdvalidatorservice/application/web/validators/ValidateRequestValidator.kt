package io.github.leandrochp.passw0rdvalidatorservice.application.web.validators

import io.github.leandrochp.passw0rdvalidatorservice.application.configs.EnvironmentVariablesConfig
import io.github.leandrochp.passw0rdvalidatorservice.application.extensions.isInvalidLength
import io.github.leandrochp.passw0rdvalidatorservice.application.extensions.isNullOrBlank
import io.github.leandrochp.passw0rdvalidatorservice.application.web.requests.ValidateRequest
import org.koin.core.KoinComponent
import org.koin.core.inject

class ValidateRequestValidator() :  KoinComponent, Validator<ValidateRequest> {

    private val environmentVariablesConfig : EnvironmentVariablesConfig by inject()

    override fun validate(request: ValidateRequest): Map<String, List<String>> {

        val errorList = mutableListOf<Validation<*>>()

        with(request) {
            errorList.add(Validation("password", this.password).isNullOrBlank())
            errorList.add(
                Validation("password", this.password)
                    .isInvalidLength(
                        min = environmentVariablesConfig.validatorPasswordMinLength,
                        max = environmentVariablesConfig.validatorPasswordMaxLength
                    )
            )
        }

        return errorList.filter { it.errorMessageList.isNotEmpty() }
            .groupBy { it.fieldName }
            .mapValues { it.value.flatMap { valueItem -> valueItem.errorMessageList } }
    }
}