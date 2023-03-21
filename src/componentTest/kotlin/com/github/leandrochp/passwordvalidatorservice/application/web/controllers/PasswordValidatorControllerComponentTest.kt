package com.github.leandrochp.passwordvalidatorservice.application.web.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.github.leandrochp.passwordvalidatorservice.application.web.responses.PasswordValidateResponse
import com.github.leandrochp.passwordvalidatorservice.utils.ComponentTestsUtils
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class PasswordValidatorControllerComponentTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    private val objectMapper: ObjectMapper = ObjectMapper().registerModule(
        KotlinModule.Builder()
            .withReflectionCacheSize(512)
            .configure(KotlinFeature.NullToEmptyCollection, false)
            .configure(KotlinFeature.NullToEmptyMap, false)
            .configure(KotlinFeature.NullIsSameAsDefault, false)
            .configure(KotlinFeature.SingletonSupport, false)
            .configure(KotlinFeature.StrictNullChecks, false)
            .build()
    )

    @Test
    fun `should return true when a password is valid`() {
        mockMvc.perform(
            MockMvcRequestBuilders.post("/validate")
                .content(ComponentTestsUtils.readFile("requests/valid_password"))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk)
            .andReturn().also {
                val response = objectMapper.readValue(it.response.contentAsString, PasswordValidateResponse::class.java)
                assert(response.valid)
            }
    }

    @Test
    fun `should return false when a password is empty`() {
        mockMvc.perform(
            MockMvcRequestBuilders.post("/validate")
                .content(ComponentTestsUtils.readFile("requests/empty_password"))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk)
            .andReturn().also {
                val response = objectMapper.readValue(it.response.contentAsString, PasswordValidateResponse::class.java)
                assert(!response.valid)
            }
    }

    @Test
    fun `should return false when a password is without a digit`() {
        mockMvc.perform(
            MockMvcRequestBuilders.post("/validate")
                .content(ComponentTestsUtils.readFile("requests/without_digit"))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk)
            .andReturn().also {
                val response = objectMapper.readValue(it.response.contentAsString, PasswordValidateResponse::class.java)
                assert(!response.valid)
            }
    }

    @Test
    fun `should return false when a password is with only uppercase letters`() {
        mockMvc.perform(
            MockMvcRequestBuilders.post("/validate")
                .content(ComponentTestsUtils.readFile("requests/without_lower_case"))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk)
            .andReturn().also {
                val response = objectMapper.readValue(it.response.contentAsString, PasswordValidateResponse::class.java)
                assert(!response.valid)
            }
    }

    @Test
    fun `should return false when a password is without special characters`() {
        mockMvc.perform(
            MockMvcRequestBuilders.post("/validate")
                .content(ComponentTestsUtils.readFile("requests/without_special_character"))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk)
            .andReturn().also {
                val response = objectMapper.readValue(it.response.contentAsString, PasswordValidateResponse::class.java)
                assert(!response.valid)
            }
    }

    @Test
    fun `should return false when a password is with repeated characters`() {
        mockMvc.perform(
            MockMvcRequestBuilders.post("/validate")
                .content(ComponentTestsUtils.readFile("requests/with_repeated_characters"))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk)
            .andReturn().also {
                val response = objectMapper.readValue(it.response.contentAsString, PasswordValidateResponse::class.java)
                assert(!response.valid)
            }
    }

    @Test
    fun `should return false when a password is with spaces`() {
        mockMvc.perform(
            MockMvcRequestBuilders.post("/validate")
                .content(ComponentTestsUtils.readFile("requests/with_spaces"))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk)
            .andReturn().also {
                val response = objectMapper.readValue(it.response.contentAsString, PasswordValidateResponse::class.java)
                assert(!response.valid)
            }
    }
}