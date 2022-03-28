package com.example.allin1

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Customers_details")
data class Customers(
    val customer_name : String,
    val customer_phone : String,
    @PrimaryKey
    val customer_email : String,
    val customer_password : String,
)
