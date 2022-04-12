package com.example.allin1.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CartItemsDao {
    @Insert
    fun addCartItem(item: Cartitems)

    @Delete
    fun deleteCartItem(item: Cartitems)

    @Query("SELECT * FROM Cart")
    fun getCartItem(): LiveData<List<Cartitems>>

    @Query("SELECT COUNT(Name) FROM Cart")
    fun getCartQuantity(): Int

    @Query("SELECT SUM(Price) FROM Cart")
    fun getCartValue(): Double

    @Query("DElETE FROM Cart")
    fun clearCart()

    @Query("SELECT * FROM Cart ORDER BY Type ASC, Name ASC")
    fun getFinalCart(): List<Cartitems>

    @Query("SELECT EXISTS (SELECT * FROM Cart WHERE Name = :Name ) ")
    fun cartItemExist(Name: String): Boolean
}
