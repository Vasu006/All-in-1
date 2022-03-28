package com.example.allin1

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (entities = [Customers::class], version = 1)
abstract class CustomersDatabase : RoomDatabase() {
    abstract fun CustomersDao() : CustomersDao

    companion object {
        @Volatile
        private var instance: CustomersDatabase? = null

        fun getDatabase_instance(context: Context): CustomersDatabase {
            if (instance == null) {
                synchronized(CustomersDatabase::class.java) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CustomersDatabase::class.java,
                        "CustomersDB"
                    ).allowMainThreadQueries().build()
                }
            }
            return instance!!
        }
    }
}