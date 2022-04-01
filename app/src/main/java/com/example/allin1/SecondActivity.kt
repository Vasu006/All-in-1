package com.example.allin1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.fragment_login_page.*

class SecondActivity : AppCompatActivity() {
    val firebase_instance = Firebase.firestore

    private lateinit var items_list: ArrayList<Cart_items>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    override fun onResume() {
        super.onResume()
        val mainviewmodel: MainViewModel = MainViewModel()

        val selected_categories = intent.getStringExtra("Selected_categories")

        cartValue_box.setOnClickListener {
            Intent(MainApplication_Java.getContext(),Checkout_CartActivity::class.java).also{
                startActivity(it)
            }
        }

        firebase_instance.collection("Groceries").whereEqualTo("Type", selected_categories)
            .get()
            .addOnSuccessListener { result ->
                var temp_items: MutableList<Cart_items> = mutableListOf()
                for (document in result.documents) {
                    val item: Cart_items? = document.toObject(Cart_items::class.java)
                    Log.d("item_data", "$item")
                    temp_items.add(item!!)
                }

                val rv_adapter = Item_RV_Adapter(temp_items)
                second_fragment_RV.adapter = rv_adapter
                second_fragment_RV.layoutManager = LinearLayoutManager(this)
            }
            .addOnFailureListener { exception ->
                Log.w("get_data", "Error getting documents.", exception)
            }

        mainviewmodel.get_CartItem().observe(this, Observer {

            if (mainviewmodel.get_CartQuantity() > 0)
                cartValue_box.visibility = View.VISIBLE
            else
                cartValue_box.visibility = View.INVISIBLE

            cart_quantity.text = "${mainviewmodel.get_CartQuantity()} Item"
            cart_totalValue.text = "Rs ${mainviewmodel.get_CartValue()}"
        })

    }
}