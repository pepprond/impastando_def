package com.android.example.impastando

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.android.example.impastando.fragment.listaImpasti
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.app

class Register_Activity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = Firebase.auth
        val loginText : TextView =findViewById(R.id.accedi)

        loginText.setOnClickListener {
            val intent = Intent(this, Login_activity::class.java)
            startActivity(intent)

        }

        val bottoneRegistra : Button = findViewById(R.id.button_registra)

        bottoneRegistra.setOnClickListener {
            performSingup()
        }

    }

    private fun performSingup() {
        val email = findViewById<EditText>(R.id.email_iscrizione)
        val password = findViewById<EditText>(R.id.password_iscrizione)
        if(email.text.isEmpty()|| password.text.isEmpty()){
            Toast.makeText(this,"riempi tutti i campi", Toast.LENGTH_SHORT).show()
            return
        }
        val inputEmail = email.text.toString()
        val inputPassword = password.text.toString()

        auth.createUserWithEmailAndPassword(inputEmail,inputPassword)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(baseContext, "Autenticazione riuscita.",
                        Toast.LENGTH_SHORT).show()
                } else {

                    Toast.makeText(baseContext, "Autenticazione fallita.",
                        Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener {
                Toast.makeText(this, "errore ${it.localizedMessage}",Toast.LENGTH_SHORT).show()
            }
    }
}