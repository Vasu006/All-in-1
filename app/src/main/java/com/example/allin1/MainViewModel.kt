package com.example.allin1

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val database = CustomersDatabase.getDatabase_instance(MainApplication_Java.getContext()).CustomersDao()

    fun insert_customer(customer : Customers){
        database.addCustomer(customer)
    }

    fun Customer_Exists(email: String) : Boolean{
        return database.CustomerExists(email)
    }

    fun Login_Customer(email : String) : List<Customers>{
        return database.LoginCustomer(email)
    }
}