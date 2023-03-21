package com.github.leandrochp.passwordvalidatorservice.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["com.github.leandrochp.passwordvalidatorservice"])
class PasswordValidatorServiceApplication

fun main(args: Array<String>) {
    runApplication<PasswordValidatorServiceApplication>(*args)
}