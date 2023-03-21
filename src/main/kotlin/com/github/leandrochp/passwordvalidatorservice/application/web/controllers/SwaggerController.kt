package com.github.leandrochp.passwordvalidatorservice.application.web.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class SwaggerController {

    @GetMapping("/docs")
    fun swaggerRedirect() = "redirect:swagger-ui/index.html"

}

