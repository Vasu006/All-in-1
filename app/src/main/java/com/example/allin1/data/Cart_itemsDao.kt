package com.example.allin1.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Cart_itemsDao {
    @Insert
    fun add_cartItem(item: Cart_items)

    @Delete
    fun delete_cartItem(item: Cart_items)

    @Query("SELECT * FROM Cart")
    fun get_CartItem(): LiveData<List<Cart_items>>

    @Query("SELECT COUNT(Name) FROM Cart")
    fun get_CartQuantity(): Int

    @Query("SELECT SUM(Price) FROM Cart")
    fun get_CartValue(): Double

    @Query("DElETE FROM Cart")
    fun clear_Cart()

    @Query("SELECT * FROM Cart ORDER BY Type ASC, Name ASC")
    fun get_finalCart(): List<Cart_items>

    @Query("SELECT EXISTS (SELECT * FROM Cart WHERE Name = :Name ) ")
    fun cart_ItemExist(Name: String): Boolean
}
