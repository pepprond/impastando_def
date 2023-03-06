package com.android.example.impastando

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.android.example.impastando.Adapter.ImpastiAdapter
import com.android.example.impastando.Adapter.onItemClickView
import com.android.example.impastando.databinding.ActivityMainBinding
import com.android.example.impastando.fragment.listToShow
import com.android.example.impastando.ogetti.DataSource.getdata


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerView = binding.RVMain
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = ImpastiAdapter(listToShow(getdata()), object : onItemClickView {
            override fun onCardItemClick(position : Int) {

                Toast.makeText(this@MainActivity,"Hai cliccato sulla posizione n $position",Toast.LENGTH_SHORT).show()

            }
        })
        recyclerView.adapter = adapter


    }


}


