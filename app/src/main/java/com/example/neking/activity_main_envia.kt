package com.example.neking

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class activity_main_envia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_envia)
        val btnneking = findViewById<Button>(R.id.btnneking)
        val btnbancos = findViewById<Button>(R.id.btnotrosbancos)

        btnneking.setOnClickListener{
            val intentPuntoFisico = Intent(this,activity_envia_plata::class.java).apply {}
            startActivity(intentPuntoFisico)
        }
    }
}