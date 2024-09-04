package com.example.neking

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Codigo : AppCompatActivity() {
    private var isCodeHidden = false  // Variable para llevar el control del estado
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sacar_codigo)
        val btnCodigoAtras = findViewById<ImageView>(R.id.imgretroceder)

        val imgeye = findViewById<ImageView>(R.id.imgeye)
        val txtcodigo = findViewById<TextView>(R.id.txtcodigo)

        btnCodigoAtras.setOnClickListener {
            val intentCodigoAtras = Intent(this,MainActivity::class.java).apply {}
            startActivity(intentCodigoAtras)
        }
        imgeye.setOnClickListener {
            if (isCodeHidden) {
                // Mostrar código e imagen
                txtcodigo.text = "947821"
                imgeye.setImageResource(R.drawable.eye_regular)
            } else {
                // Ocultar el código e imagen
                txtcodigo.text = "------"
                imgeye.setImageResource(R.drawable.eye_slash_regular)
            }
            isCodeHidden = !isCodeHidden  // Cambiar el estado
        }
    }
}