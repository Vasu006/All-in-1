package com.example.allin1.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CustomersDao {
    @Insert
    fun addCustomer(customer : Customers)

    @Update
    fun updateCustomer(customer: Customers)

    @Query("SELECT EXISTS (SELECT * FROM Customers_details WHERE customer_email = :cust_email) ")
    fun CustomerExists(cust_email : String) : Boolean

    @Query("SELECT * FROM Customers_details WHERE customer_email = :cust_email ")
    fun LoginCustomer(cust_email: String) : List<Customers>
}