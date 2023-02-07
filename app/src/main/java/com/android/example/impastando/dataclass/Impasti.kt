package com.android.example.impastando.dataclass

import com.android.example.impastando.R

data class Impasti(val image: imageImpasti,val type:String, val id: Int)

enum class imageImpasti{
    FROLLA, PIZZA, CREPES;

    fun geticon():Int{
        return when(this){
            FROLLA -> R.drawable.froll
            PIZZA -> R.drawable.pizz
            CREPES -> R.drawable.crepes
        }
    }
}