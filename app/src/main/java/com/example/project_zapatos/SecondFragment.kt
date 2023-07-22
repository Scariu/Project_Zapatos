package com.example.project_zapatos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.example.project_zapatos.databinding.FragmentSecondBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment(){
    private lateinit var binding: FragmentSecondBinding
    var zapatos = mutableListOf<Zapatos>()
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
        binding = FragmentSecondBinding.inflate(LayoutInflater.from(activity))
        //val adapter = Adapter()
        val listaZapatos = ListaZapatos.zapatos
        setComponent(listaZapatos)
       // adapter.setData(listaZapatos)
        //adapter.setZapatoCallBack(this)
        return (binding.root)
    }

    private fun setComponent(listZapatos: List<Zapatos>) {
        for (z in listZapatos) {
            binding.textViewNombre.text = z.nombre
            binding.imageViewProducto.load(z.imagenUrl)
            binding.textViewPrecioSecond.text = z.precio.toString()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SecondFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    /*override fun showZapato(s: Zapatos) {
        for (z in zapatos) {
            binding.textViewNombre.text = s.nombre
            binding.imageViewProducto.load(s.imagenUrl)
            binding.textViewPrecioSecond.text = s.precio.toString()
        }
    }*/
}