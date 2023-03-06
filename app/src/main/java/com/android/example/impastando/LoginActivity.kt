package com.android.example.impastando

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.findNavController
import com.android.example.impastando.databinding.ActivityLoginBinding
import com.android.example.impastando.databinding.ActivityRegisterBinding
import com.android.example.impastando.fragment.listaImpasti
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth

        binding.buttonAccedi.setOnClickListener {
            val email = binding.emailLogin.text.toString()
            val password = binding.passwordLogin.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty()) {
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "riempi tutti i campi", Toast.LENGTH_SHORT).show()
            }
        }
        binding.passwordDimenticata.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val view = layoutInflater.inflate(R.layout.password_dimenticata, null)
            val userEmail = findViewById<EditText>(R.id.edit_text_pass_dimenticata)
            builder.setView(view)
            val dialog = builder.create()
            view.findViewById<Button>(R.id.reset_password).setOnClickListener {
                complareEmail(userEmail)
                dialog.dismiss()
            }
            view.findViewById<Button>(R.id.button_forgot).setOnClickListener {
                dialog.dismiss()
            }
            if (dialog.window != null) {
                dialog.window!!.setBackgroundDrawable(ColorDrawable(0))
            }
            dialog.show()

        }

        binding.Registrati.setOnClickListener {
            val singunIntent = Intent(this, Register_Activity::class.java)
            startActivity(singunIntent)
        }
    }

    private fun complareEmail(email: EditText) {
        if (email.text.toString().isEmpty()) {
            return
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()){
            return
        }
        auth.sendPasswordResetEmail(email.text.toString()).addOnCompleteListener { task ->
            if (task.isSuccessful){
                Toast.makeText(this,"guarda la tua mail",Toast.LENGTH_SHORT).show()
            }
        }
    }

}