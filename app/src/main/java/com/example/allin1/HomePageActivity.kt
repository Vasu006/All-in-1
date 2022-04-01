package com.example.allin1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_home_page.*
import kotlinx.android.synthetic.main.items_recyclerview.view.*

val mainviewmodel = MainViewModel()

class HomePageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        mainviewmodel.clear_Cart()

    }

    override fun onResume() {
        super.onResume()
        val curr_email = intent.getStringExtra("Curr_Cust_email")
        val current_customer: Customers? = curr_email?.let { mainviewmodel.Login_Customer(it)[0] }

        Glide.with(MainApplication_Java.getContext())
            .load("https://s3.envato.com/files/306843079/2971_17.jpg")
            .into(img_fruit)

        Glide.with(MainApplication_Java.getContext())
            .load("https://static.vecteezy.com/system/resources/previews/004/288/604/large_2x/vegetables-and-fruits-on-white-background-photo.jpg")
            .into(img_vegetables)

        home_profile.setText("${current_customer?.customer_name}")



        img_fruit.setOnClickListener {
            Intent(MainApplication_Java.getContext(), SecondActivity::class.java).also {
                it.putExtra("Selected_categories", "Fruit")
                startActivity(it)
            }
        }

        img_vegetables.setOnClickListener {
            Intent(MainApplication_Java.getContext(), SecondActivity::class.java).also {
                it.putExtra("Selected_categories", "Vegetable")
                startActivity(it)
            }
        }

    }
}