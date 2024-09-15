package com.example.neking

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class activity_envia_neking_confirmado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_envia_neking_confirmado)

        val btnconfirmar = findViewById<Button>(R.id.btnlisto)

        val tvname = findViewById<TextView>(R.id.txtresulnombredestino)
        val tvcelular = findViewById<TextView>(R.id.txtresulcelular)
        val tvcuanto = findViewById<TextView>(R.id.txtresulcuanto)
        val tvmensaje = findViewById<TextView>(R.id.txtresulmensaje)
        //Traer los datos de la Activity Anterior
        val name = intent.getStringExtra("Nombre")
        val cel = intent.getStringExtra("Celular")
        val cua = intent.getStringExtra("Cuanto")
        val men = intent.getStringExtra("Mensaje")
        // Imprimir los Datos en el Activity
        tvname.text = "$name"
        tvcelular.text = "$cel"
        tvcuanto.text = "$cua"
        tvmensaje.text = "$men"


        btnconfirmar.setOnClickListener{
            val intentConfirmar = Intent(this,Home::class.java).apply {}
            startActivity(intentConfirmar)
        }


    }
}