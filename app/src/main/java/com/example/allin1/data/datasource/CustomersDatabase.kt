package com.example.allin1.data.datasource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.allin1.domain.businessLogic.model.Cartitems
import com.example.allin1.domain.businessLogic.model.Customers
import com.example.allin1.utils.Constants

@Database(entities = [Customers::class, Cartitems::class], version = 1)
abstract class CustomersDatabase : RoomDatabase() {
    abstract val CustomersDao: CustomersDao
    abstract val CartitemsDao: CartItemsDao

    companion object {
        @Volatile
        private var instance: CustomersDatabase? = null

        fun getDatabaseInstance(context: Context): CustomersDatabase {
            if (instance == null) {
                synchronized(CustomersDatabase::class.java) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CustomersDatabase::class.java,
                        Constants.dbName
                    ).allowMainThreadQueries().build()
                }
            }
            return instance!!
        }
    }
}