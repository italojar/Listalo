package website.italojar.listalo.ui.shopping.interfaces

import website.italojar.listalo.data.db.entities.ShoppingItem

interface IShoppingItemListener {
    fun plusShoppingItem(item: ShoppingItem)
    fun minusShoppingItem(item: ShoppingItem)
    fun removeShoppingItem(item: ShoppingItem)
}