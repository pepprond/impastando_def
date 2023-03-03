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

class Login_activity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = Firebase.auth
        val registerText : TextView =findViewById(R.id.Registrati)

        registerText.setOnClickListener {
            val intent = Intent(this, Register_Activity::class.java)
            startActivity(intent)

        }
        val loginButton : Button = findViewById(R.id.button_accedi)
        loginButton.setOnClickListener {
            performLogin()
        }

    }

    private fun performLogin() {
        val email: EditText =findViewById(R.id.email_login)
        val password: EditText =findViewById(R.id.password_login)

        if (email.text.isEmpty()||password.text.isEmpty()){
            Toast.makeText(this,"riempi tutti i campi",Toast.LENGTH_SHORT).show()
            return
        }
        val emailInput =email.text.toString()
        val passwordInput = password.text.toString()

        auth.signInWithEmailAndPassword(emailInput, passwordInput)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(baseContext, "Autenticazione riuscita.",
                        Toast.LENGTH_SHORT).show()
                } else {

                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()

                }
            }
            .addOnFailureListener {
                Toast.makeText(baseContext, "Authentication failed.${it.localizedMessage}",
                    Toast.LENGTH_SHORT).show()
            }
    }
}