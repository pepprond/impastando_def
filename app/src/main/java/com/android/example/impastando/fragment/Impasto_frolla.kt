package com.android.example.impastando.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.android.example.impastando.R
import com.android.example.impastando.databinding.FragmentImpastoFrollaBinding
import com.android.example.impastando.databinding.FragmentImpastoPizzaBinding


class Impasto_frolla : Fragment() {
    private lateinit var binding: FragmentImpastoFrollaBinding
    private lateinit var input: EditText
    private lateinit var output: TextView
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentImpastoFrollaBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        input = view.findViewById(R.id.input_frolla)
        output = view.findViewById(R.id.output_frolla)
        button = view.findViewById(R.id.button_calcolo_frolla)
    }

    override fun onStart() {
        super.onStart()
        button.setOnClickListener {
            val totale = input.text.toString().toIntOrNull()
            if (totale == null) {
                output.text = "inserisci un valore numerico valido"
            } else {
                output.text = getPercentualeFrolla(totale)
            }
        }
    }

}


fun getPercentualeFrolla(totale: Int): String {

    val Farina = totale * 45.82 / 100
    val Burro = totale * 27.49 / 100
    val Zucchero = totale * 18.33 / 100
    val Tuorli = totale * 8.25 / 100
    val Sale = totale * 0.11 / 100
    return "Percentuali impasto:\n\nFarina(45,82%) grammi:${Farina.toFloat()} \n\nBurro(27,49%) grammi:${Burro.toFloat()} \n\nZucchero(18,33%) grammi:${Zucchero.toFloat()} \n\nTuorli(8,25%) grammi:${Tuorli.toFloat()} \n\nsale(0,11%) grammi:${Sale.toFloat()}"
}

