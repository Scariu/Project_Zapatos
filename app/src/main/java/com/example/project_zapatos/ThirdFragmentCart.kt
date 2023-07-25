package com.example.project_zapatos

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.project_zapatos.ListaZapatos.Companion.zapatos
import com.example.project_zapatos.databinding.FragmentSecondBinding
import com.example.project_zapatos.databinding.FragmentThirdCartBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ThirdFragmentCart.newInstance] factory method to
 * create an instance of this fragment.
 */
class ThirdFragmentCart : Fragment(), AddItemsCart{
    private lateinit var binding: FragmentThirdCartBinding
    private lateinit var mSharedPreferences: SharedPreferences
    private var zapatosList: MutableList<Zapatos> = ListaZapatos.zapatos.toMutableList()
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThirdCartBinding.inflate(LayoutInflater.from(activity))
        mSharedPreferences = requireActivity().applicationContext.getSharedPreferences("cookie", Context.MODE_PRIVATE)
        initAdapter()
        initListeners()
        return (binding.root)
    }
    private fun updateLista(adapter: AdapterCart){
        val data = addItemsCart()
        adapter.setData(data)
        addSumaTotal(data)
    }
    public fun addSumaTotal(zapatos: List<Zapatos>){
        var total = 0F
        for (zapato in zapatos){
            total += zapato.precio
        }
        binding.textViewTotal.text = "TOTAL: $ $total"
    }
    private fun initListeners() {
        binding.imageButtonBackThird.setOnClickListener{
            Navigation.findNavController(binding.root).navigateUp();
        }
    }

    private fun initAdapter() {
        val cartAdapter = AdapterCart(mSharedPreferences, this)
        val listaZapatosCart = addItemsCart()
        cartAdapter.setData(listaZapatosCart)
        binding.recyclerViewThird.adapter = cartAdapter
        updateLista(cartAdapter)
    }
    override fun addItemsCart(): MutableList<Zapatos>{
        val zapatos = ListaZapatos.zapatos
        val carro = mutableListOf<Zapatos>()
        val nombres = mSharedPreferences.all
        for (z in zapatos) {
            if (nombres.containsKey(z.nombre))carro.add(z)
        }
        return carro
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ThirdFragmentCart.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ThirdFragmentCart().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}