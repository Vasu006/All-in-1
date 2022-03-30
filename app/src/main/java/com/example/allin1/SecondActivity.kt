package com.example.allin1

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    val firebase_instance = Firebase.firestore

    private lateinit var items_list: ArrayList<Gloceries_data>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    override fun onResume() {
        super.onResume()
        val selected_categories = intent.getStringExtra("Selected_categories")

        firebase_instance.collection("Groceries").whereEqualTo("Type", selected_categories)
            .get()
            .addOnSuccessListener { result ->
                var temp_items: MutableList<Gloceries_data> = mutableListOf()
                for (document in result.documents) {
                    val item: Gloceries_data? = document.toObject(Gloceries_data::class.java)
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


    }
}