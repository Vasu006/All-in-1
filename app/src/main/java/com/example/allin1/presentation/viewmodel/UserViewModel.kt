package com.example.allin1.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.allin1.domain.businessLogic.model.Customers
import com.example.allin1.domain.businessLogic.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

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