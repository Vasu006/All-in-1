package com.example.allin1.domain.businessLogic

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.allin1.data.Cart_items
import com.example.allin1.data.Customers
import com.example.allin1.data.CustomersDatabase

class MainViewModel : ViewModel() {
    private val database = CustomersDatabase.getDatabase_instance(MainApplication_Java.getContext())

    fun insert_customer(customer : Customers){
        database.CustomersDao().addCustomer(customer)
    }

    fun Customer_Exists(email: String) : Boolean{
        return database.CustomersDao().CustomerExists(email)
    }

    fun Login_Customer(email : String) : List<Customers>{
        return database.CustomersDao().LoginCustomer(email)
    }

    fun insert_CartItem(item : Cart_items){
        database.Cart_itemsDao().add_cartItem(item)
    }

    fun remove_CartItem(item : Cart_items){
        database.Cart_itemsDao().delete_cartItem(item)
    }

    fun get_CartItem () : LiveData<List<Cart_items>>{
        return database.Cart_itemsDao().get_CartItem()
    }

    fun get_CartQuantity() : Int{
        return database.Cart_itemsDao().get_CartQuantity()
    }

    fun get_CartValue() : Double{
        return database.Cart_itemsDao().get_CartValue()
    }

    fun clear_Cart(){
        database.Cart_itemsDao().clear_Cart()
    }

    fun cart_ItemExist(Cart_Name : String) : Boolean{
        return database.Cart_itemsDao().cart_ItemExist(Cart_Name)
    }

    fun get_FinalCart() : List<Cart_items>{
        return database.Cart_itemsDao().get_finalCart()
    }

}