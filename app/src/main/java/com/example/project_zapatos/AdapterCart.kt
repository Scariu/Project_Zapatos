package com.example.project_zapatos

import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.project_zapatos.databinding.ItemCartBinding

class AdapterCart(private val mSharedPreferences: SharedPreferences, private val cart: ThirdFragmentCart): RecyclerView.Adapter<AdapterCart.ViewHolder>() {
    private var shoesCart = mutableListOf<Zapatos>()

override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    var bindingCart = ItemCartBinding.inflate(LayoutInflater.from(parent.context))
    return ViewHolder(bindingCart)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemCart = shoesCart[position]
        holder.bind(itemCart)
    }

    override fun getItemCount(): Int {
        return shoesCart.size
    }
    fun setData(listaZapatos: MutableList<Zapatos>) {
        this.shoesCart = listaZapatos.toMutableList()
        notifyDataSetChanged()

    }

    inner class ViewHolder(val binding: ItemCartBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(itemZapato: Zapatos) {
            binding.imageViewCart.load(itemZapato.imagenUrl)
            binding.textViewNombreCart.text = itemZapato.nombre
            binding.textViewPrecioCart.text = "$ " + itemZapato.precio.toString()
            binding.imageButtonDelete.setOnClickListener {
                val position = adapterPosition
                val itemToRemove = shoesCart[position]
                mSharedPreferences.edit().remove(itemToRemove.nombre).apply()
                shoesCart.removeAt(position)
                notifyItemRemoved(position)
                cart.addSumaTotal(shoesCart)
            }
        }
    }
}