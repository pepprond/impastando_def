package com.android.example.impastando.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.example.impastando.Adapter.ImpastiAdapter
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
        val adapter = ImpastiAdapter(listImp)
        binding.RVimpasti.adapter = adapter
        binding.RVimpasti.layoutManager = LinearLayoutManager(view.context)
        adapter.notifyDataSetChanged()

    }


}

private fun listToShow(impasti: List<Impasti>): MutableList<Impasti> {
    val listToReturn = mutableListOf<Impasti>()
    listToReturn.add(Impasti(imageImpasti.FROLLA,"Impasto Frolla",0))
    listToReturn.add(Impasti(imageImpasti.PIZZA,"Impasto Pizza",1))
    listToReturn.add(Impasti(imageImpasti.CREPES,"Impasto Crepes",2))
    return listToReturn
}