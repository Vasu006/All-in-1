package com.example.allin1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.fragment_cart__item.*

class Cart_ItemFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart__item, container, false)
    }

    override fun onResume() {
        super.onResume()

        text_Cart_TotalPrice.setText("Rs ${mainviewmodel.get_CartValue()}")

        var cartItems = mainviewmodel.get_FinalCart()
        val rv_adapter = Checkout_Item_RV_Adapter(cartItems)
        RV_Groceries_cart.adapter = rv_adapter
        RV_Groceries_cart.layoutManager = LinearLayoutManager(MainApplication_Java.getContext())

        constraint_place_order.setOnClickListener {
            val orderPlacefragment = OrderPlacedFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_cart,orderPlacefragment)?.commit()
        }


    }
}