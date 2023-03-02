package com.android.example.impastando.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.SmoothScroller.Action
import com.android.example.impastando.Adapter.ImpastiAdapter
import com.android.example.impastando.Adapter.onItemClickView
import com.android.example.impastando.R
import com.android.example.impastando.databinding.FragmentListaImpastiBinding
import com.android.example.impastando.dataclass.Impasti
import com.android.example.impastando.dataclass.imageImpasti
import com.android.example.impastando.ogetti.DataSource.getdata


class listaImpasti : Fragment() {
    private lateinit var binding: FragmentListaImpastiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentListaImpastiBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val listImp = listToShow(getdata())


        val adapter = ImpastiAdapter(listImp, object : onItemClickView {
            override fun onCardItemClick(position : Int) {
                Toast.makeText(requireContext(),"Hai cliccato sulla posizione n $position",Toast.LENGTH_SHORT).show()
                when(position){
                    0 -> findNavController().navigate(R.id.action_listaImpasti_to_impasto_frolla)
                    1 -> findNavController().navigate(R.id.action_listaImpasti_to_impasto_pizza)
                }


                }


        })
        binding.RVimpasti.adapter = adapter
        binding.RVimpasti.layoutManager = LinearLayoutManager(view.context)

    }


}

private fun listToShow(impasti: List<Impasti>): MutableList<Impasti> {
    val listToReturn = mutableListOf<Impasti>()
    listToReturn.add(Impasti(imageImpasti.FROLLA,"Impasto Frolla"))
    listToReturn.add(Impasti(imageImpasti.PIZZA,"Impasto Pizza"))
    listToReturn.add(Impasti(imageImpasti.CREPES,"Impasto Crepes"))
    return listToReturn
}