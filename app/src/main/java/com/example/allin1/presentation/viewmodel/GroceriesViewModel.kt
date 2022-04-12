package com.example.allin1.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.allin1.data.Cartitems
import com.example.allin1.domain.businessLogic.repository.GroceriesRepository

class GroceriesViewModel : ViewModel() {
    private val firebaseRepository = GroceriesRepository()

    fun getGroceriesItems(selectedCategories: String){
        Log.d("Selected_Item", "$selectedCategories")
        firebaseRepository.getGroceriesItem(selectedCategories)
    }

    fun getGroceriesList() : MutableLiveData<List<Cartitems>> {
        return firebaseRepository.getGroceriesList()
    }
}