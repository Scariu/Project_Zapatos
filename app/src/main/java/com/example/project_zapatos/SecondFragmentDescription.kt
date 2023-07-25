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
import coil.load
import com.example.project_zapatos.databinding.FragmentSecondBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragmentDescription.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragmentDescription : Fragment(){
    private lateinit var binding: FragmentSecondBinding
    private lateinit var mSharedPreferences: SharedPreferences
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var param3: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString("nombre")
            param2 = it.getString("url")
            param3 = it.getString("precio")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(LayoutInflater.from(activity))
        mSharedPreferences = requireActivity().applicationContext.getSharedPreferences("cookie", Context.MODE_PRIVATE)
        setComponent()
        initListeners()
        return (binding.root)
    }


    private fun initListeners() {
        binding.imageButtonShowCart.setOnClickListener {
            findNavController()
                .navigate(R.id.action_secondFragment_to_thirdFragmentCart)
        }
        binding.imageButtonBack.setOnClickListener {
            Navigation.findNavController(binding.root).navigateUp();
        }
        binding.buttonAddCart.setOnClickListener {
            addToCart()
        }
    }

    private fun setComponent() {
        binding.textViewNombre.text = param1
        binding.imageViewProducto.load(param2)
        binding.textViewPrecioSecond.text = "$ $param3"
    }

    private fun addToCart() {
        mSharedPreferences.edit().putString(param1, param1).apply()
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
            SecondFragmentDescription().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)

                }
            }
    }

}