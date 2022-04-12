package com.example.allin1.presentation.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.allin1.data.Customers
import com.example.allin1.MainApplicationJava
import com.example.allin1.R
import com.example.allin1.presentation.viewmodel.CartViewModel
import com.example.allin1.presentation.viewmodel.UserViewModel
import com.example.allin1.utils.Constants
import kotlinx.android.synthetic.main.activity_homepage.*

class HomePageActivity : AppCompatActivity() {
    private lateinit var cartViewModel: CartViewModel
    private lateinit var userViewModel: UserViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)
        cartViewModel = ViewModelProvider(this)[CartViewModel::class.java]
        cartViewModel.clearCart()

    }

    override fun onResume() {
        super.onResume()
        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        val currentEmail = intent.getStringExtra("Curr_Cust_email")
        val currentCustomer: Customers? = currentEmail?.let { userViewModel.loginCustomer(it)[0] }

        Glide.with(MainApplicationJava.getContext())
            .load(Constants.imgFruits)
            .into(img_fruit)

        Glide.with(MainApplicationJava.getContext())
            .load(Constants.imgVegetables)
            .into(img_vegetables)

        home_profile.text = "${currentCustomer?.customer_name}"

        img_fruit.setOnClickListener {
            Intent(MainApplicationJava.getContext(), SecondActivity::class.java).also {
                it.putExtra("Selected_categories", "Fruit")
                startActivity(it)
            }
        }

        img_vegetables.setOnClickListener {
            Intent(MainApplicationJava.getContext(), SecondActivity::class.java).also {
                it.putExtra("Selected_categories", "Vegetable")
                startActivity(it)
            }
        }

    }
}