package com.example.allin1.domain.businessLogic.repository

import com.example.allin1.MainApplicationJava
import com.example.allin1.domain.businessLogic.model.Customers
import com.example.allin1.data.datasource.CustomersDatabase

interface UserRepository {
//    private val database = CustomersDatabase.getDatabaseInstance(MainApplicationJava.getContext())

    fun insertCustomer(customer: Customers)

    fun customerExists(email: String): Boolean

    fun loginCustomer(email: String): List<Customers>
}