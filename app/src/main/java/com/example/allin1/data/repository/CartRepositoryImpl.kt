package com.example.allin1.data.repository

import androidx.lifecycle.LiveData
import com.example.allin1.data.datasource.CartItemsDao
import com.example.allin1.domain.businessLogic.model.Cartitems
import com.example.allin1.domain.businessLogic.repository.CartRepository

class CartRepositoryImpl(private val cartItemsDao: CartItemsDao) : CartRepository{
    override fun insertCartItem(item: Cartitems) {
        cartItemsDao.addCartItem(item)
    }

    override fun removeCartItem(item: Cartitems) {
        cartItemsDao.deleteCartItem(item)
    }

    override fun getCartItem(): LiveData<List<Cartitems>> {
        return cartItemsDao.getCartItem()
    }

    override fun getCartQuantity(): Int {
        return cartItemsDao.getCartQuantity()
    }

    override fun getCartValue(): Double {
        return cartItemsDao.getCartValue()
    }

    override fun clearCart() {
        cartItemsDao.clearCart()
    }

    override fun cartItemExist(Cart_Name: String): Boolean {
        return cartItemsDao.cartItemExist(Cart_Name)
    }

    override fun getFinalCart(): List<Cartitems> {
        return cartItemsDao.getFinalCart()
    }
}