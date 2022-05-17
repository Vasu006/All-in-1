package com.example.allin1.domain.businessLogic.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Cart")
data class Cartitems(
    val Img_url: String = "",
    @PrimaryKey
    val Name: String = "",
    val Price: Double = 0.0,
    val Type: String = "",
    val Weight: String = "",
)
