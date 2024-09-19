package com.example.neking

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class activity_envia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_envia)
        val btnneking = findViewById<Button>(R.id.btnneking)
        val btnbancos = findViewById<Button>(R.id.btnotrosbancos)
        val btnCodigoAtras = findViewById<ImageView>(R.id.imgretroceder)

        btnCodigoAtras.setOnClickListener{
            val intentAtras = Intent(this,Home::class.java).apply {}
            startActivity(intentAtras)
        }

        btnneking.setOnClickListener{
            val intentPuntoFisico = Intent(this,activity_envia_neking::class.java).apply {}
            startActivity(intentPuntoFisico)
        }
        btnbancos.setOnClickListener{
            val intentBancos = Intent(this,activity_envia_bancos::class.java).apply {}
            startActivity(intentBancos)
        }
    }
}