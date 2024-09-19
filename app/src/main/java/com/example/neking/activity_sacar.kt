package com.example.neking

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class activity_sacar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sacar)
        val btnPuntoFisico = findViewById<Button>(R.id.btnneking)
        val btnCajero = findViewById<Button>(R.id.btncajero)
        val btnCodigoAtras = findViewById<ImageView>(R.id.imgretroceder)

        btnCodigoAtras.setOnClickListener{
            val intentAtras = Intent(this,Home::class.java).apply {}
            startActivity(intentAtras)
        }

        btnPuntoFisico.setOnClickListener{
            val intentPuntoFisico = Intent(this,codigo::class.java).apply {}
            startActivity(intentPuntoFisico)
        }
        btnCajero.setOnClickListener {
            val intentCajero = Intent(this,codigo::class.java).apply {}
            startActivity(intentCajero)
        }

    }
}