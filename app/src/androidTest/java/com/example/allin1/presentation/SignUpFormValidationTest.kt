package com.example.allin1.presentation

import com.example.allin1.utils.SignUpFormValidation
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class SignUpFormValidationTest{

    /**
     * Username empty
     * Contact empty
     * Contact 10 digit
     * Email empty
     * Email format
     * Email exist
     * Password empty
     * Password without Capital
     * Password without Number
     * Password without symbol
     * Password length
     * Confirm Password empty
     * Confirm Password mismatch
     * valid form
     */

    @Test
    fun emptyUsername_ReturnFalse () {
        val result = SignUpFormValidation.validateSignUpFormInput(
            "",
            "1234567890",
            "abc@gmail.com",
            "abc@123",
            "abc@123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun emptyContact_ReturnFalse () {
        val result = SignUpFormValidation.validateSignUpFormInput(
            "Vasu",
            "",
            "abc@gmail.com",
            "abc@123",
            "abc@123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun contactLengthNot10Digit_ReturnFalse () {
        val result = SignUpFormValidation.validateSignUpFormInput(
            "Vasu",
            "12334",
            "abc@gmail.com",
            "abc@123",
            "abc@123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun emptyEmail_ReturnFalse () {
        val result = SignUpFormValidation.validateSignUpFormInput(
            "Vasu",
            "9876543210",
            "",
            "abc@123",
            "abc@123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun invalidEmailFormat_ReturnFalse () {
        val result = SignUpFormValidation.validateSignUpFormInput(
            "Vasu",
            "9876543210",
            "abc",
            "abc@123",
            "abc@123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun existingEmail_ReturnFalse () {
        val result = SignUpFormValidation.validateSignUpFormInput(
            "Vasu",
            "9876543210",
            "xyz@gmail.com",
            "abc@123",
            "abc@123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun emptyPassword_ReturnFalse () {
        val result = SignUpFormValidation.validateSignUpFormInput(
            "Vasu",
            "9876543210",
            "xy@gmail.com",
            "",
            "abc@123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun passwordWithoutCapital_ReturnFalse () {
        val result = SignUpFormValidation.validateSignUpFormInput(
            "Vasu",
            "9876543210",
            "xy@gmail.com",
            "pass@123",
            "abc@123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun passwordWithoutNumber_ReturnFalse () {
        val result = SignUpFormValidation.validateSignUpFormInput(
            "Vasu",
            "9876543210",
            "xy@gmail.com",
            "Pass@",
            "abc@123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun passwordWithoutSymbol_ReturnFalse () {
        val result = SignUpFormValidation.validateSignUpFormInput(
            "Vasu",
            "9876543210",
            "xy@gmail.com",
            "Pass123",
            "abc@123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun passwordLengthLessThan8_ReturnFalse () {
        val result = SignUpFormValidation.validateSignUpFormInput(
            "Vasu",
            "9876543210",
            "xy@gmail.com",
            "Pass@1",
            "abc@123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun emptyConfirmPassword_ReturnFalse () {
        val result = SignUpFormValidation.validateSignUpFormInput(
            "Vasu",
            "9876543210",
            "xy@gmail.com",
            "Pass@123",
            ""
        )
        assertThat(result).isFalse()
    }

    @Test
    fun mismatchedConfirmPassword_ReturnFalse () {
        val result = SignUpFormValidation.validateSignUpFormInput(
            "Vasu",
            "9876543210",
            "xy@gmail.com",
            "Pass@123",
            "Pass@12"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun validSignUpForm_ReturnFalse () {
        val result = SignUpFormValidation.validateSignUpFormInput(
            "Vasu",
            "9876543210",
            "xy@gmail.com",
            "Pass@123",
            "Pass@123"
        )
        assertThat(result).isTrue()
    }
}