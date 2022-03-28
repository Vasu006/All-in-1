package com.example.allin1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home_page.*

val mainviewmodel = MainViewModel()

class HomePageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val curr_email = intent.getStringExtra("Curr_Cust_email")
        val current_customer : Customers? = curr_email?.let { mainviewmodel.Login_Customer(it)[0] }

        home_text.setText("Welcome to All in 1 ${current_customer?.customer_name}")


    }
}