package com.example.allin1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_signup_page.*

class SignupPageFragment : Fragment() {

    val mainviewmodel = MainViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup_page, container, false)
    }

    override fun onResume() {
        super.onResume()

        btn_signup.setOnClickListener {
            if(SignupValidation() == true){

                mainviewmodel.insert_customer(
                    Customers(
                        signup_name.text.toString(),
                        signup_phone.text.toString(),
                        signup_emailId.text.toString(),
                        signup_password.text.toString()
                    )
                )

                Toast.makeText(MainApplication_Java.getContext(),"Customer Created",Toast.LENGTH_SHORT).show()
            }
        }
    }


    fun SignupValidation() : Boolean{

        if (signup_name.text.toString().length < 1){
            Toast.makeText(MainApplication_Java.getContext(),"Check Name", Toast.LENGTH_SHORT).show()
            return false
        }

        if (android.util.Patterns.PHONE.matcher(signup_phone.text.toString()).matches() == false || signup_phone.text.toString().length != 10){
            Toast.makeText(MainApplication_Java.getContext(),"Check Contact number", Toast.LENGTH_SHORT).show()
            return false
        }

        if (android.util.Patterns.EMAIL_ADDRESS.matcher(signup_emailId.text.toString()).matches() == false)
        {
            Toast.makeText(MainApplication_Java.getContext(),"Check Email address",Toast.LENGTH_SHORT).show()
            return false
        }

        if (signup_password.text.toString().length < 1){
            Toast.makeText(MainApplication_Java.getContext(),"Check Password",Toast.LENGTH_SHORT).show()
            return false
        }
        if (signup_confirmpassword.text.toString().length < 1){
            Toast.makeText(MainApplication_Java.getContext(),"Check Password",Toast.LENGTH_SHORT).show()
            return false
        }
        if (signup_password.text.toString() != signup_confirmpassword.text.toString()){
            Toast.makeText(MainApplication_Java.getContext(),"Password doesn't match",Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }
}