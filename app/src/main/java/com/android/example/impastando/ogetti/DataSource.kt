package com.android.example.impastando.ogetti

import com.android.example.impastando.dataclass.Impasti
import com.android.example.impastando.dataclass.imageImpasti

    object DataSource {
        val impastilist = listOf<Impasti>(
            Impasti(
                type = "Impasto Pizza",
                image = imageImpasti.PIZZA,
                id = 0
            ),

            Impasti(
                type = "Impasto Frolla",
                image = imageImpasti.FROLLA,
                id = 1
            ),
            Impasti(
                type = "Impasto Crepes",
                image = imageImpasti.CREPES,
                id = 2
            ),
        )
        fun getdata(): List<Impasti> {
            return impastilist
        }

    }


