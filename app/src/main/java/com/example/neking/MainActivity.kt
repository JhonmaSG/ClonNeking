package com.example.neking

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_sacar)
        val btnPuntoFisico = findViewById<Button>(R.id.btnotrosbancos)
        val btnCajero = findViewById<Button>(R.id.btnneking)

        btnPuntoFisico.setOnClickListener{
            val intentPuntoFisico = Intent(this,Codigo::class.java).apply {}
            startActivity(intentPuntoFisico)
        }
        btnCajero.setOnClickListener {
            val intentCajero = Intent(this,Codigo::class.java).apply {}
            startActivity(intentCajero)
        }

    }
}