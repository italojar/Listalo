package website.italojar.listalo.data.repositories

import website.italojar.listalo.data.db.ShoppingDatabase
import website.italojar.listalo.data.db.entities.ShoppingItem

class ShoppingRepository(private val db: ShoppingDatabase) {
    suspend fun insert(item: ShoppingItem) = db.getShoppingDao().insert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()
}