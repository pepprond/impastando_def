package com.android.example.impastando.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.android.example.impastando.R
import com.android.example.impastando.databinding.FragmentImpastoPizzaBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class Impasto_pizza : Fragment() {
    private lateinit var binding: FragmentImpastoPizzaBinding
    private lateinit var input: EditText
    private lateinit var output: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentImpastoPizzaBinding.inflate(layoutInflater)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        input = view.findViewById(R.id.input_pizza)
        output = view.findViewById(R.id.output_pizza)
        button = view.findViewById(R.id.button_calcolo_pizza)


    }

    override fun onStart() {
        super.onStart()
        button.setOnClickListener {
            val totale = input.text.toString().toIntOrNull()
            if (totale == null) {
                output.text = "inserisci un valore numerico valido"
            } else {
                output.text = getPercentualePizza(totale)
            }
        }

    }


}


fun getPercentualePizza(totale: Int): String {

    val Farina = 56.37 * totale / 100
    val Acqua = totale * 42.28 / 100
    val Lievito = totale * 1.13 / 100
    val Sale = totale * 0.22 / 100
    return "Percentuali impasto:\n\nfarina(56,37%) grammi:${Farina.toFloat()}\n\nacqua(42,28%) grammi:${Acqua.toFloat()} \n\nlievito(1,13%) grammi:${Lievito.toFloat()}\n\nsale(0, 22 %) grammi:${Sale.toFloat()}"
}













