package com.example.allin1.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.allin1.data.Customers
import com.example.allin1.domain.businessLogic.repository.UserRepository

class UserViewModel : ViewModel() {
    private val userRepository = UserRepository()

    fun insertCustomer(customer: Customers) {
        userRepository.insertCustomer(customer)
    }

    fun customerExists(email: String): Boolean {
        return userRepository.customerExists(email)
    }

    fun loginCustomer(email: String): List<Customers> {
        return userRepository.loginCustomer(email)
    }
}