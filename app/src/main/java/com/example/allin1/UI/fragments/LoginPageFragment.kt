package com.example.allin1.UI.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.allin1.*
import com.example.allin1.UI.activities.HomePageActivity
import com.example.allin1.data.Customers
import com.example.allin1.domain.businessLogic.MainApplication_Java
import kotlinx.android.synthetic.main.fragment_login_page.*

class LoginPageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login_page, container, false)
    }

    override fun onResume() {
        super.onResume()

        btn_login.setOnClickListener {
            if (Login_Validation() == true) {
                val current_customer: Customers =
                    mainviewmodel.Login_Customer(login_emailId.text.toString())[0]

                if (current_customer.customer_password == login_password.text.toString()) {
                    Toast.makeText(
                        MainApplication_Java.getContext(),
                        "Welcome, You have loggedin successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                    Intent(MainApplication_Java.getContext(), HomePageActivity::class.java).also {
                        it.putExtra("Curr_Cust_email", login_emailId.text.toString())
                        startActivity(it)
                    }
                } else {
                    Toast.makeText(
                        MainApplication_Java.getContext(),
                        "Incorrect Password",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    fun Login_Validation(): Boolean {

        if (android.util.Patterns.EMAIL_ADDRESS.matcher(login_emailId.text.toString())
                .matches() == false
        ) {
            Toast.makeText(
                MainApplication_Java.getContext(),
                "Enter a valid Email address",
                Toast.LENGTH_SHORT
            ).show()
            return false
        }

        if (mainviewmodel.Customer_Exists(login_emailId.text.toString()) == false) {

            Toast.makeText(
                MainApplication_Java.getContext(),
                "Check Email address",
                Toast.LENGTH_SHORT
            ).show()
            return false
        }

        return true
    }
}