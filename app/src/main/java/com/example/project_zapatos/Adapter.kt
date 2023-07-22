package com.example.project_zapatos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.project_zapatos.databinding.ItemBinding

class Adapter: RecyclerView.Adapter<Adapter.ViewHolder>() {

    var zapatos = mutableListOf<Zapatos>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        var binding = ItemBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val item = zapatos[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return zapatos.size
    }

    fun setData(listaZapatos: MutableList<Zapatos>) {
        this.zapatos = listaZapatos.toMutableList()

    }

    class ViewHolder(private val binding: ItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(itemZapato: Zapatos) {
            binding.imageViewZapato.load(itemZapato.imagenUrl)
            binding.textViewNombreZapato.text = itemZapato.nombre
            binding.textViewPrecio.text = itemZapato.precio.toString()

        }

    }

}