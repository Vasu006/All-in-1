package com.example.allin1.data

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.allin1.data.datasource.CustomersDao
import com.example.allin1.data.datasource.CustomersDatabase
import com.example.allin1.domain.businessLogic.model.Customers
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class CustomersDaoTest {

    private lateinit var database: CustomersDatabase
    private lateinit var dao : CustomersDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            CustomersDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.CustomersDao()
    }

    @After
    fun teardown(){
        database.close()
    }

    @Test
    fun insertCustomerTest() {
        val customer = Customers("Vasu", "9876543210","abc@gmail.com","Abcd@123")
        dao.addCustomer(customer)

        val customerExist = dao.customerExists(customer.customer_email)

        assertThat(customerExist).isEqualTo(true)
    }

    @Test
    fun deleteCustomerTest() {
        val customer = Customers("Vasu", "9876543210","abc@gmail.com","Abcd@123")
        dao.addCustomer(customer)

        val customerList = dao.loginCustomer(customer.customer_email)



        assertThat(customerList).contains(customer)
    }
}