package website.italojar.listalo.ui.shopping

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import website.italojar.listalo.R
import website.italojar.listalo.data.db.ShoppingDatabase
import website.italojar.listalo.data.db.entities.ShoppingItem
import website.italojar.listalo.data.repositories.ShoppingRepository
import website.italojar.listalo.databinding.ActivityShoppingBinding
import website.italojar.listalo.ui.shopping.adapters.ShoppingAdapter
import website.italojar.listalo.ui.shopping.dialogs.AddShoppingItemDialog
import website.italojar.listalo.ui.shopping.interfaces.IDialogListener
import website.italojar.listalo.ui.shopping.interfaces.IShoppingItemListener

class ShoppingActivity : AppCompatActivity(), IShoppingItemListener {

    private lateinit var viewModel: ShoppingViewModel
    private lateinit var binding: ActivityShoppingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = ShoppingDatabase(this)
        val repository =  ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)

        viewModel = ViewModelProvider(this, factory)[ShoppingViewModel::class.java]

        val adapter = ShoppingAdapter(listOf(), this)
        binding.rvShoppingItem.layoutManager = LinearLayoutManager(this)
        binding.rvShoppingItem.adapter = adapter

        viewModel.getAllShoppingItems().observe(this, Observer { listShoppingItems ->
            adapter.items = listShoppingItems
            adapter.notifyDataSetChanged()
        })

        binding.floatingActionButton.setOnClickListener {
            AddShoppingItemDialog(this,
                object: IDialogListener {
                    override fun onAddButtonClicked(item: ShoppingItem) {
                        viewModel.insert(item)
                    }
            }).show()
        }
    }

    override fun plusShoppingItem(item: ShoppingItem) { viewModel.insert(item) }

    override fun minusShoppingItem(item: ShoppingItem) { viewModel.insert(item) }

    override fun removeShoppingItem(item: ShoppingItem) { viewModel.delete(item) }
}