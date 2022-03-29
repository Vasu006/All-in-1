package com.example.allin1

import android.content.Intent
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

        home_profile.setText("${current_customer?.customer_name}")

        img_fruit.setOnClickListener {
            Intent(MainApplication_Java.getContext(), SecondActivity::class.java).also {
                it.putExtra("Selected_categories", "Fruit")
                startActivity(it)
            }
        }

        img_vegetables.setOnClickListener {
            Intent(MainApplication_Java.getContext(), SecondActivity::class.java).also {
                it.putExtra("Selected_categories", "Vegetables")
                startActivity(it)
            }
        }

    }
}