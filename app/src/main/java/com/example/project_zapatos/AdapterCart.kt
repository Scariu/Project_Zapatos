package com.example.project_zapatos

import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.project_zapatos.databinding.ItemCartBinding

class AdapterCart: RecyclerView.Adapter<AdapterCart.ViewHolder>() {
    private var zapatosCart = mutableListOf<Zapatos>()

override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    var bindingCart = ItemCartBinding.inflate(LayoutInflater.from(parent.context))
    return ViewHolder(bindingCart)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemCart = zapatosCart[position]
        holder.bind(itemCart)
    }

    override fun getItemCount(): Int {
        return zapatosCart.size
    }
    fun setData(listaZapatos: MutableList<Zapatos>) {
        this.zapatosCart = listaZapatos.toMutableList()

    }

    class ViewHolder(private val binding: ItemCartBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(itemZapato: Zapatos) {
            binding.imageViewCart.load(itemZapato.imagenUrl)
            binding.textViewNombreCart.text = itemZapato.nombre
            binding.textViewPrecioCart.text = "$ " + itemZapato.precio.toString()
            binding.imageButtonDelete.setOnClickListener {
            }
        }
    }
}