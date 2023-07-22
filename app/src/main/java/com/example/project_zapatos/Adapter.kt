package com.example.project_zapatos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.project_zapatos.databinding.ItemBinding

class Adapter: RecyclerView.Adapter<Adapter.ViewHolder>() {

    private var zapatos = mutableListOf<Zapatos>()
    //private var callBack: ZapatoCallBack?=null

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
    /*fun setZapatoCallBack(c: ZapatoCallBack){
        this.callBack = c
    }*/

    inner class ViewHolder(private val binding: ItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(itemZapato: Zapatos) {
            binding.imageViewZapato.load(itemZapato.imagenUrl)
            binding.textViewNombreZapato.text = itemZapato.nombre
            binding.textViewPrecio.text = itemZapato.precio.toString()
            binding.cardViewItem.setOnClickListener{
                Navigation.findNavController(binding.root).navigate(R.id.action_firstFragment_to_secondFragment)
               // callBack?.showZapato(itemZapato)

            }
        }

    }

}