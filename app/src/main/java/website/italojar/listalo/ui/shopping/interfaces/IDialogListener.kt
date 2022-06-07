package website.italojar.listalo.ui.shopping.interfaces

import website.italojar.listalo.data.db.entities.ShoppingItem

interface IDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}