package com.example.allin1.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.allin1.R
import com.example.allin1.presentation.fragments.CartItemFragment
import com.example.allin1.presentation.fragments.OrderPlacedFragment

class CheckoutCartActivity : AppCompatActivity(), CartItemFragment.FragmentTransition {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkoutcart)

        val fragment_cartItem = CartItemFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_cart, fragment_cartItem)
                .commit()
        }


    }

    override fun placeOrder() {

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_cart, OrderPlacedFragment())
                .commit()
        }
    }
}