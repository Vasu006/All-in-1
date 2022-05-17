package com.example.allin1.presentation.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.allin1.*
import com.example.allin1.domain.businessLogic.model.Cartitems
import com.example.allin1.presentation.adapters.ItemRVAdapter
import com.example.allin1.MainApplicationJava
import com.example.allin1.presentation.viewmodel.CartViewModel
import com.example.allin1.presentation.viewmodel.GroceriesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.items_recyclerview.view.*

@AndroidEntryPoint
class SecondActivity : AppCompatActivity() {
    private lateinit var cartViewModel: CartViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    override fun onResume() {
        super.onResume()

        val groceriesViewModel = GroceriesViewModel()

        val selected_categories = intent.getStringExtra("Selected_categories")

        cartValue_box.setOnClickListener {
            Intent(MainApplicationJava.getContext(), CheckoutCartActivity::class.java).also {
                startActivity(it)
            }
        }

        if (selected_categories != null) {
            groceriesViewModel.getGroceriesItems(selected_categories)
        }

        val rv_adapter = ItemRVAdapter()
        second_fragment_RV.adapter = rv_adapter
        second_fragment_RV.layoutManager = LinearLayoutManager(this)

        cartViewModel = ViewModelProvider(this)[CartViewModel::class.java]

        rv_adapter.setInterface(object : ItemRVAdapter.Listener {
            override fun checkCartItem(item: Cartitems, view: View) {
                if (cartViewModel.cartItemExist(item.Name))
                    view.btn_addToCart.text = "Remove Item"
                else
                    view.btn_addToCart.text = "Add to cart"
            }

            override fun onClickItem(item: Cartitems, view: View) {
                if (cartViewModel.cartItemExist(item.Name)) {
                    view.btn_addToCart.text = "Add to cart"
                    cartViewModel.removeCartItem(item)
                } else {
                    view.btn_addToCart.text = "Remove Item"
                    cartViewModel.insertCartItem(item)
                }
            }
        })

        groceriesViewModel.getGroceriesList().observe(this) {
            rv_adapter.setItems(it)
        }

        cartViewModel.getCartItem().observe(this, Observer {

            if (cartViewModel.getCartQuantity() > 0)
                cartValue_box.visibility = View.VISIBLE
            else
                cartValue_box.visibility = View.INVISIBLE

            cart_quantity.text = "${cartViewModel.getCartQuantity()} Item"
            cart_totalValue.text = "Rs ${cartViewModel.getCartValue()}"
        })

    }


}