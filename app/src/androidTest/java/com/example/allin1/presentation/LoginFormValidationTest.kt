package com.example.allin1.presentation

import com.example.allin1.utils.LoginFormValidation
import com.google.common.truth.Truth.assertThat
import org.junit.Test


class LoginFormValidationTest{

    @Test
    fun emptyEmail_ReturnFalse () {
        val result = LoginFormValidation.validateLoginFormInput(
            "",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun invalidEmailFormat_ReturnFalse () {
        val result = LoginFormValidation.validateLoginFormInput(
            "abc",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun emptyPassword_ReturnFalse () {
        val result = LoginFormValidation.validateLoginFormInput(
            "abc@gmail.com",
            ""
        )
        assertThat(result).isFalse()
    }

    @Test
    fun incorrectPassword_ReturnFalse () {
        val result = LoginFormValidation.validateLoginFormInput(
            "xyz@gmail.com",
            "abc@123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun correctPassword_ReturnTrue () {
        val result = LoginFormValidation.validateLoginFormInput(
            "xyz@gmail.com",
            "xyz@123"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun validEmailFormatAndPassword_ReturnTrue () {
        val result = LoginFormValidation.validateLoginFormInput(
            "abc@gmail.com",
            "abc@123"
        )
        assertThat(result).isTrue()
    }
}