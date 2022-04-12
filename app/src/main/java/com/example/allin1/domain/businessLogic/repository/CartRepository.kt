package com.example.allin1.domain.businessLogic.repository

import androidx.lifecycle.LiveData
import com.example.allin1.MainApplicationJava
import com.example.allin1.data.*

class CartRepository(){

    private val database = CustomersDatabase.getDatabaseInstance(MainApplicationJava.getContext())

    fun insertCartItem(item: Cartitems) {
        database.CartitemsDao().addCartItem(item)
    }

    fun removeCartItem(item: Cartitems) {
        database.CartitemsDao().deleteCartItem(item)
    }

    fun getCartItem(): LiveData<List<Cartitems>> {
        return database.CartitemsDao().getCartItem()
    }

    fun getCartQuantity(): Int {
        return database.CartitemsDao().getCartQuantity()
    }

    fun getCartValue(): Double {
        return database.CartitemsDao().getCartValue()
    }

    fun clearCart() {
        database.CartitemsDao().clearCart()
    }

    fun cartItemExist(Cart_Name: String): Boolean {
        return database.CartitemsDao().cartItemExist(Cart_Name)
    }

    fun getFinalCart(): List<Cartitems> {
        return database.CartitemsDao().getFinalCart()
    }
}