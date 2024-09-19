package com.example.neking

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val celular = findViewById<EditText>(R.id.txtNumber)
        val ingresar = findViewById<FrameLayout>(R.id.btnEntra)

        ingresar.setOnClickListener{
            val cel = celular.text.toString()
            // Validar el número de celular
            if (cel.length == 10 && cel.all { it.isDigit() }) {
                // Crear el Intent para enviar al siguiente Activity
                val intent = Intent(this, Password::class.java).apply {
                    putExtra("Cel", cel)
                }
                startActivity(intent)
            } else {
                // Mostrar mensaje de error si el número no es válido
                Toast.makeText(this, "El número de celular debe tener 10 dígitos", Toast.LENGTH_LONG).show()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}