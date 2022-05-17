package com.example.allin1.utils

import kotlinx.android.synthetic.main.fragment_loginpage.*

object LoginFormValidation {

    val existingUser = mapOf<String, String>("abc@gmail.com" to "abc@123", "xyz@gmail.com" to "xyz@123")

    fun validateLoginFormInput(
        userEmail : String,
        userPassword : String
    ) : Boolean {

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(userEmail).matches())
            return false

        if (existingUser[userEmail] != userPassword)
            return false

        return true
    }

}