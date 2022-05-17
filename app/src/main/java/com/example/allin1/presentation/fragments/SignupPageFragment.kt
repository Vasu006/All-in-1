package com.example.allin1.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.allin1.domain.businessLogic.model.Customers
import com.example.allin1.MainApplicationJava
import com.example.allin1.R
import com.example.allin1.presentation.viewmodel.CartViewModel
import com.example.allin1.presentation.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_signuppage.*

@AndroidEntryPoint
class SignupPageFragment : Fragment() {

    private lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signuppage, container, false)
    }

    override fun onResume() {
        super.onResume()

        btn_signup.setOnClickListener {
            if (signupValidation()) {
                userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
                userViewModel.insertCustomer(
                    Customers(
                        signup_name.text.toString(),
                        signup_phone.text.toString(),
                        signup_emailId.text.toString(),
                        signup_password.text.toString()
                    )
                )

                Toast.makeText(
                    MainApplicationJava.getContext(),
                    "Customer Created",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }


    fun signupValidation(): Boolean {

        if (signup_name.text.toString().isEmpty()) {
            Toast.makeText(MainApplicationJava.getContext(), "Check Name", Toast.LENGTH_SHORT)
                .show()
            return false
        }

        if (!android.util.Patterns.PHONE.matcher(signup_phone.text.toString())
                .matches() || signup_phone.text.toString().length != 10
        ) {
            Toast.makeText(
                MainApplicationJava.getContext(),
                "Check Contact number",
                Toast.LENGTH_SHORT
            ).show()
            return false
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(signup_emailId.text.toString())
                .matches()
        ) {
            Toast.makeText(
                MainApplicationJava.getContext(),
                "Check Email address",
                Toast.LENGTH_SHORT
            ).show()
            return false
        }

        if (signup_password.text.toString().isEmpty()) {
            Toast.makeText(MainApplicationJava.getContext(), "Check Password", Toast.LENGTH_SHORT)
                .show()
            return false
        }
        val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$"
        val passwordMatcher = Regex(passwordPattern)

        if (passwordMatcher.find(signup_password.text.toString()) == null) {
            Toast.makeText(
                MainApplicationJava.getContext(),
                "Password should be minimum 8 char with number, alphabet and symbols",
                Toast.LENGTH_SHORT
            ).show()
            return false
        }

        if (signup_confirmpassword.text.toString().isEmpty()) {
            Toast.makeText(MainApplicationJava.getContext(), "Check Password", Toast.LENGTH_SHORT)
                .show()
            return false
        }
        if (signup_password.text.toString() != signup_confirmpassword.text.toString()) {
            Toast.makeText(
                MainApplicationJava.getContext(),
                "Password doesn't match",
                Toast.LENGTH_SHORT
            ).show()
            return false
        }

        return true
    }
}