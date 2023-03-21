package com.github.leandrochp.passwordvalidatorservice.application.config

import com.github.leandrochp.passwordvalidatorservice.domain.log.LoggableClass
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig : LoggableClass() {

    fun openAPI(): OpenAPI {
        logger.info("Starting open-api/swagger...")
        return OpenAPI().info(getInfo())
    }

    private fun getInfo(): Info {
        return Info()
            .title("Password Validator Service")
            .description("API docs.")
    }
}