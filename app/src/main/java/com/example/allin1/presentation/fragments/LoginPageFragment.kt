package com.example.allin1.presentation.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.allin1.*
import com.example.allin1.presentation.activities.HomePageActivity
import com.example.allin1.data.Customers
import com.example.allin1.MainApplicationJava
import com.example.allin1.presentation.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_loginpage.*

class LoginPageFragment : Fragment() {

    private lateinit var userViewModel: UserViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_loginpage, container, false)
    }

    override fun onResume() {
        super.onResume()

        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        btn_login.setOnClickListener {
            if (loginValidation() == true) {
                val current_customer: Customers =
                    userViewModel.loginCustomer(login_emailId.text.toString())[0]

                if (current_customer.customer_password == login_password.text.toString()) {
                    Toast.makeText(
                        MainApplicationJava.getContext(),
                        "Welcome, You have loggedin successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                    Intent(MainApplicationJava.getContext(), HomePageActivity::class.java).also {
                        it.putExtra("Curr_Cust_email", login_emailId.text.toString())
                        startActivity(it)
                    }
                } else {
                    Toast.makeText(
                        MainApplicationJava.getContext(),
                        "Incorrect Password",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    fun loginValidation(): Boolean {

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(login_emailId.text.toString())
                .matches()
        ) {
            Toast.makeText(
                MainApplicationJava.getContext(),
                "Enter a valid Email address",
                Toast.LENGTH_SHORT
            ).show()
            return false
        }

        if (!userViewModel.customerExists(login_emailId.text.toString())) {

            Toast.makeText(
                MainApplicationJava.getContext(),
                "Check Email address",
                Toast.LENGTH_SHORT
            ).show()
            return false
        }

        return true
    }
}