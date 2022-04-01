package com.example.allin1

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (entities = [Customers::class, Cart_items::class], version = 1)
abstract class CustomersDatabase : RoomDatabase() {
    abstract fun CustomersDao() : CustomersDao
    abstract fun Cart_itemsDao() : Cart_itemsDao

    companion object {
        @Volatile
        private var instance: CustomersDatabase? = null

        fun getDatabase_instance(context: Context): CustomersDatabase {
            if (instance == null) {
                synchronized(CustomersDatabase::class.java) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CustomersDatabase::class.java,
                        "GloceriesDB"
                    ).allowMainThreadQueries().build()
                }
            }
            return instance!!
        }
    }
}