package website.italojar.listalo.ui.shopping.dialogs

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import website.italojar.listalo.data.db.entities.ShoppingItem
import website.italojar.listalo.databinding.DialogAddShoppingItemBinding
import website.italojar.listalo.ui.shopping.dialogs.AddShoppingItemDialog.*
import website.italojar.listalo.ui.shopping.interfaces.IDialogListener

class AddShoppingItemDialog(context: Context, var addIDialogListener: IDialogListener): AppCompatDialog(context) {

    private lateinit var binding: DialogAddShoppingItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogAddShoppingItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            tvAddDialog.setOnClickListener {
                val name = etNameDialog.text.toString()
                val amount = etAmountDialog.text.toString()
                if (name.isEmpty() || amount.isEmpty()) {
                    Toast.makeText(
                        context,
                        "Por favor, introduce toda la información",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@setOnClickListener
                }
                val item = ShoppingItem(name, amount.toInt())
                addIDialogListener.onAddButtonClicked(item)
                dismiss()
            }
            tvCancelDialog.setOnClickListener { cancel() }
        }
    }
}