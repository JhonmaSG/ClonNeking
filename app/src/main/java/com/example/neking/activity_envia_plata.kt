package com.example.neking

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class activity_envia_plata : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_envia_plata)
        val btnCodigoAtras = findViewById<ImageView>(R.id.imgretroceder)

        btnCodigoAtras.setOnClickListener {
            val intentCodigoAtras = Intent(this,activity_main_envia::class.java).apply {}
            startActivity(intentCodigoAtras)
        }
    }
}