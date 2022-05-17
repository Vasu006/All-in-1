package com.example.allin1.utils

import android.widget.Toast
import com.example.allin1.MainApplicationJava
import kotlinx.android.synthetic.main.fragment_signuppage.*

object SignUpFormValidation {

    val existingUser = mapOf<String, String>("abc@gmail.com" to "abc@123", "xyz@gmail.com" to "xyz@123")

    fun validateSignUpFormInput (
        userName : String,
        userContact : String,
        userEmail : String,
        userPassword : String,
        userConfirmPassword : String
    ) : Boolean {
        if (userName.isEmpty())
            return false

        if (!android.util.Patterns.PHONE.matcher(userContact).matches() || userContact.length != 10)
            return false

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(userEmail).matches())
            return false

        if (userPassword.isEmpty())
            return false

        val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$"
        val passwordMatcher = Regex(passwordPattern)

        if (passwordMatcher.find(userPassword) == null)
            return false

        if (userConfirmPassword.isEmpty())
            return false

        if (userPassword != userConfirmPassword)
            return false

        return true
    }
}