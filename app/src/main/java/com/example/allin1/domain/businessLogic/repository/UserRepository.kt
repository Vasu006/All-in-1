package com.example.allin1.domain.businessLogic.repository

import com.example.allin1.MainApplicationJava
import com.example.allin1.data.Customers
import com.example.allin1.data.CustomersDatabase

class UserRepository {
    private val database = CustomersDatabase.getDatabaseInstance(MainApplicationJava.getContext())

    fun insertCustomer(customer: Customers) {
        database.CustomersDao().addCustomer(customer)
    }

    fun customerExists(email: String): Boolean {
        return database.CustomersDao().customerExists(email)
    }

    fun loginCustomer(email: String): List<Customers> {
        return database.CustomersDao().loginCustomer(email)
    }
}