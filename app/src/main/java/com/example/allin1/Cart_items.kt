package com.example.allin1

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Cart")
data class Cart_items(
    val Img_url: String = "",
    @PrimaryKey
    val Name: String = "",
    val Price: Double = 0.0,
    val Type: String = "",
    val Weight: String = "",
)