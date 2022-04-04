package com.example.allin1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.fragment_cart__item.*

class Checkout_CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout_cart)

        val fragment_cartItem = Cart_ItemFragment()
        val orderflacedfragment = OrderPlacedFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_cart, fragment_cartItem)
                .commit()
        }

    }
}