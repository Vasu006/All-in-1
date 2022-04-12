package com.example.allin1.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.allin1.presentation.adapters.CheckoutItemRVAdapter
import com.example.allin1.MainApplicationJava
import com.example.allin1.R
import com.example.allin1.presentation.viewmodel.CartViewModel
import kotlinx.android.synthetic.main.fragment_cartitem.*


class CartItemFragment : Fragment() {

    private lateinit var cartViewModel: CartViewModel
    lateinit var fragmentTransition: FragmentTransition

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cartitem, container, false)
    }

    override fun onResume() {
        super.onResume()
        cartViewModel = ViewModelProvider(this)[CartViewModel::class.java]

        text_Cart_TotalPrice.text = "Rs ${cartViewModel.getCartValue()}"

        var cartItems = cartViewModel.getFinalCart()
        val rv_adapter = CheckoutItemRVAdapter(cartItems)
        RV_Groceries_cart.adapter = rv_adapter
        RV_Groceries_cart.layoutManager = LinearLayoutManager(MainApplicationJava.getContext())

        constraint_place_order.setOnClickListener {

            fragmentTransition = activity as FragmentTransition
            fragmentTransition.placeOrder()
        }
    }

    interface FragmentTransition{
        fun placeOrder()
    }
}