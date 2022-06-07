package website.italojar.listalo.ui.shopping.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import website.italojar.listalo.R
import website.italojar.listalo.data.db.entities.ShoppingItem
import website.italojar.listalo.databinding.ShoppingItemBinding
import website.italojar.listalo.ui.shopping.ShoppingViewModel
import website.italojar.listalo.ui.shopping.interfaces.IShoppingItemListener

class ShoppingAdapter(
    var items: List<ShoppingItem>,
    private val listener : IShoppingItemListener
): RecyclerView.Adapter<ShoppingAdapter.ShoppingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size


    inner class ShoppingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding = ShoppingItemBinding.bind(itemView)
        fun bind(item: ShoppingItem) {
            with(binding) {
                tvNameItem.text = item.name
                tvAmountItem.text = "${item.amount}"
                imvPlusAmount.setOnClickListener {
                    item.amount++
                    listener.plusShoppingItem(item)
                }
                imvMinusAmount.setOnClickListener {
                    if (item.amount > 0) {
                        item.amount--
                        listener.minusShoppingItem(item)
                    }
                }
                imvRemoveItem.setOnClickListener { listener.removeShoppingItem(item) }
            }
        }
    }
}