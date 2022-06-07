package website.italojar.listalo.ui.shopping

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import website.italojar.listalo.data.repositories.ShoppingRepository

class ShoppingViewModelFactory(
    private val repository:  ShoppingRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repository) as T
    }
}