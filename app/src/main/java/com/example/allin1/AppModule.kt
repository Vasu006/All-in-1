package com.example.allin1

import android.content.Context
import android.service.autofill.UserData
import com.example.allin1.data.datasource.CartItemsDao
import com.example.allin1.data.datasource.CustomersDao
import com.example.allin1.data.datasource.CustomersDatabase
import com.example.allin1.data.repository.CartRepositoryImpl
import com.example.allin1.data.repository.UserRepositoryImpl
import com.example.allin1.domain.businessLogic.repository.CartRepository
import com.example.allin1.domain.businessLogic.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) : CustomersDatabase{
        return CustomersDatabase.getDatabaseInstance(context)
    }

    @Singleton
    @Provides
    fun provideCartDao(database: CustomersDatabase) : CartItemsDao {
        return database.CartitemsDao
    }

    @Singleton
    @Provides
    fun provideCustomerDao(database: CustomersDatabase) :  CustomersDao{
        return database.CustomersDao
    }

    @Singleton
    @Provides
    fun getCartRepository(database: CustomersDatabase) : CartRepository{
        return CartRepositoryImpl(database.CartitemsDao)
    }

    @Singleton
    @Provides
    fun getUserRepository(database: CustomersDatabase) : UserRepository{
        return UserRepositoryImpl(database.CustomersDao)
    }
}