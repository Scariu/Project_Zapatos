package com.example.project_zapatos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.project_zapatos.databinding.ItemBinding

class Adapter: RecyclerView.Adapter<Adapter.ViewHolder>() {

    private var zapatos = mutableListOf<Zapatos>()

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

    inner class ViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root), ZapatoCallBack {
        fun bind(itemZapato: Zapatos) {
            binding.imageViewZapato.load(itemZapato.imagenUrl)
            binding.textViewNombreZapato.text = itemZapato.nombre
            binding.textViewPrecio.text = "$ " + itemZapato.precio.toString()
            binding.cardViewItem.setOnClickListener {
                showZapato(itemZapato)
            }
        }


        override fun showZapato(s: Zapatos) {
            val bundle = Bundle()
            bundle.putString("nombre", s.nombre)
            bundle.putString("url", s.imagenUrl)
            bundle.putString("precio", s.precio.toString())
            Navigation.findNavController(binding.root)
                .navigate(R.id.action_firstFragment_to_secondFragment, bundle)
        }
    }
}






