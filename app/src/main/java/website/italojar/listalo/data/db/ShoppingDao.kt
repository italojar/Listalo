package website.italojar.listalo.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import website.italojar.listalo.data.db.entities.ShoppingItem

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("Select * from shopping_items")
    fun getAllShoppingItems(): LiveData<List<ShoppingItem>>
}