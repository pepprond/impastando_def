package com.android.example.impastando

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.example.impastando.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Register_Activity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth
        binding.buttonRegistra.setOnClickListener {
            val email = binding.emailIscrizione.text.toString()
            val password = binding.passwordIscrizione.text.toString()
            val confermapassword = binding.confermaPasswordIscrizione.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty() && confermapassword.isNotEmpty()) {
                if (password == confermapassword) {
                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this, "le password non sono uguali", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "riempi tutti i campi", Toast.LENGTH_SHORT).show()
            }
        }
        binding.accedi.setOnClickListener {
            val loginIntent = Intent(this, LoginActivity::class.java)
            startActivity(loginIntent)
        }
    }
}