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

    val mainviewmodel = MainViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart__item, container, false)
    }

    override fun onResume() {
        super.onResume()
        var cartItems = mainviewmodel.get_FinalCart()

        val rv_adapter = Checkout_Item_RV_Adapter(cartItems)
        RV_Groceries_cart.adapter = rv_adapter
        RV_Groceries_cart.layoutManager = LinearLayoutManager(MainApplication_Java.getContext())

    }
}