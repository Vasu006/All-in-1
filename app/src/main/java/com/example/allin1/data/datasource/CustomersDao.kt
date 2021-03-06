package com.example.allin1.data.datasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.allin1.domain.businessLogic.model.Customers

@Dao
interface CustomersDao {
    @Insert
    fun addCustomer(customer : Customers)

    @Update
    fun updateCustomer(customer: Customers)

    @Query("SELECT EXISTS (SELECT * FROM Customers_details WHERE customer_email = :cust_email) ")
    fun customerExists(cust_email : String) : Boolean

    @Query("SELECT * FROM Customers_details WHERE customer_email = :cust_email ")
    fun loginCustomer(cust_email: String) : List<Customers>
}