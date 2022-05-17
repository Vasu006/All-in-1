package com.example.allin1.domain.businessLogic.repository

import androidx.lifecycle.LiveData
import com.example.allin1.MainApplicationJava
import com.example.allin1.data.*
import com.example.allin1.data.datasource.CustomersDatabase
import com.example.allin1.domain.businessLogic.model.Cartitems

interface CartRepository{

    fun insertCartItem(item: Cartitems)

    fun removeCartItem(item: Cartitems)

    fun getCartItem(): LiveData<List<Cartitems>>

    fun getCartQuantity(): Int

    fun getCartValue(): Double

    fun clearCart()

    fun cartItemExist(Cart_Name: String): Boolean

    fun getFinalCart(): List<Cartitems>
}