package com.android.example.impastando.ogetti

import com.android.example.impastando.dataclass.Impasti
import com.android.example.impastando.dataclass.imageImpasti

    object DataSource {
        val impastilist = listOf<Impasti>(
            Impasti(
                type = "Impasto Pizza",
                image = imageImpasti.PIZZA,

            ),

            Impasti(
                type = "Impasto Frolla",
                image = imageImpasti.FROLLA,

            ),
            Impasti(
                type = "Impasto Crepes",
                image = imageImpasti.CREPES,

            ),
        )
        fun getdata(): List<Impasti> {
            return impastilist
        }

    }


