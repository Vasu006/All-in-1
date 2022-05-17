package com.example.allin1.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.allin1.data.datasource.CartItemsDao
import com.example.allin1.data.datasource.CustomersDatabase
import com.example.allin1.domain.businessLogic.model.Cartitems
import com.example.allin1.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class CartItemDaoTest {

    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: CustomersDatabase
    private lateinit var dao: CartItemsDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            CustomersDatabase::class.java
        ).allowMainThreadQueries().build()

        dao = database.CartitemsDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun addCartItemTest() {
        val item = Cartitems("abc", "Banana", 10.0, "Fruit", "1 Kg")
        dao.addCartItem(item)

        val allItems = dao.getCartItem().getOrAwaitValue()
        assertThat(allItems).contains(item)
    }

    @Test
    fun deleteCartItemTest() {
        val item = Cartitems("abc", "Banana", 10.0, "Fruit", "1 Kg")
        dao.addCartItem(item)
        dao.deleteCartItem(item)

        val allItems = dao.getCartItem().getOrAwaitValue()
        assertThat(allItems).doesNotContain(item)
    }

    @Test
    fun countCartItemTest() {
        val item1 = Cartitems("abc", "Banana", 10.0, "Fruit", "1 Kg")
        val item2 = Cartitems("xyz", "Apple", 15.0, "Fruit", "1 Kg")
        dao.addCartItem(item1)
        dao.addCartItem(item2)

        val allItems = dao.getCartQuantity()
        assertThat(allItems).isEqualTo(2)
    }

    @Test
    fun sumCartItemTest() {
        val item1 = Cartitems("abc", "Banana", 10.0, "Fruit", "1 Kg")
        val item2 = Cartitems("xyz", "Apple", 15.0, "Fruit", "1 Kg")
        dao.addCartItem(item1)
        dao.addCartItem(item2)

        val allItems = dao.getCartValue()
        assertThat(allItems).isEqualTo(25.0)
    }

    @Test
    fun clearCartItemTest() {
        val item = Cartitems("abc", "Banana", 10.0, "Fruit", "1 Kg")
        dao.addCartItem(item)
        dao.clearCart()

        val allItems = dao.getCartItem().getOrAwaitValue()
        assertThat(allItems).doesNotContain(item)
    }

    @Test
    fun containsCartItemTest() {
        val item = Cartitems("abc", "Banana", 10.0, "Fruit", "1 Kg")
        dao.addCartItem(item)

        val allItems = dao.cartItemExist(item.Name)
        assertThat(allItems).isEqualTo(true)
    }
}