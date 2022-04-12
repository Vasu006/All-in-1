package com.example.allin1.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.allin1.data.Cartitems
import com.example.allin1.domain.businessLogic.repository.CartRepository

class CartViewModel() : ViewModel() {

    private val cartRepository = CartRepository()


    fun insertCartItem(item: Cartitems) {
        cartRepository.insertCartItem(item)
    }

    fun removeCartItem(item: Cartitems) {
        cartRepository.removeCartItem(item)
    }

    fun getCartItem(): LiveData<List<Cartitems>> {
        return cartRepository.getCartItem()
    }

    fun getCartQuantity(): Int {
        return cartRepository.getCartQuantity()
    }

    fun getCartValue(): Double {
        return cartRepository.getCartValue()
    }

    fun clearCart() {
        cartRepository.clearCart()
    }

    fun cartItemExist(Cart_Name: String): Boolean {
        return cartRepository.cartItemExist(Cart_Name)
    }

    fun getFinalCart(): List<Cartitems> {
        return cartRepository.getFinalCart()
    }

}