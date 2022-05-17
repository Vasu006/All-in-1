package com.example.allin1.data.repository

import com.example.allin1.data.datasource.CustomersDao
import com.example.allin1.domain.businessLogic.model.Customers
import com.example.allin1.domain.businessLogic.repository.UserRepository

class UserRepositoryImpl(private val customersDao: CustomersDao) : UserRepository {
    override fun insertCustomer(customer: Customers) {
        customersDao.addCustomer(customer)
    }

    override fun customerExists(email: String): Boolean {
        return customersDao.customerExists(email)
    }

    override fun loginCustomer(email: String): List<Customers> {
        return customersDao.loginCustomer(email)
    }
}