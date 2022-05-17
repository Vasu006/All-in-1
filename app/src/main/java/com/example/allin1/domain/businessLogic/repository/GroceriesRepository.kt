package com.example.allin1.domain.businessLogic.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.allin1.domain.businessLogic.model.Cartitems
import com.example.allin1.utils.Constants
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class GroceriesRepository {

    private var groceriesList :MutableLiveData<List<Cartitems>> = MutableLiveData()
    fun getGroceriesItem(selectedCategories: String) {
        var items_list: MutableList<Cartitems> = mutableListOf()


        val firebaseInstance = Firebase.firestore
        firebaseInstance.collection(Constants.firebaseCollectionName)
            .whereEqualTo("Type", selectedCategories)
            .get()
            .addOnSuccessListener { result ->
                var temp_items: MutableList<Cartitems> = mutableListOf()
                for (document in result.documents) {
                    val item: Cartitems? = document.toObject(Cartitems::class.java)
                    temp_items.add(item!!)
                    groceriesList.postValue(temp_items)
                }
                items_list.addAll(temp_items)
            }
            .addOnFailureListener { exception ->
                Log.w("get_data", "Error getting documents.", exception)
            }
    }

    fun getGroceriesList() : MutableLiveData<List<Cartitems>> {
        return groceriesList
    }
}