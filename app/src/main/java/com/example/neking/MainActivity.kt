package com.example.neking

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_sacar)
        val btnPuntoFisico = findViewById<Button>(R.id.btnPuntoFisico)
        val btnCajero = findViewById<Button>(R.id.btnCajero)

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