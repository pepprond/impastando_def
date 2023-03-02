package com.android.example.impastando.logicaImpasti

class logicaCalcoloImpasto(val totale: Float, val farina: Float, val acqua: Float, val Lievito: Float, val Sale: Float){
        init {
            println("totale impasto: $totale")

            fun calcoloperc(percFarina: Float= 0.0f,percAcqua: Float=0.0f, percSale: Float=0.0f, percLievito: Float=0.0f){
                val percFarina= (farina*100)/totale
                val percAcqua= (acqua*100)/totale
                val percSale=(Sale*100)/totale
                val percLievito=(Lievito*100)/totale
                println("calcolo percentuali impasto:\nfarina:$percFarina% \nAcqua:$percAcqua% \nSale:$percSale% \nLievito:$percLievito%")
            }
            println(calcoloperc())
        }
    }
