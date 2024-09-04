package com.example.neking

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class activity_envia_por_confirmar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_envia_neking_confirmar)

        val btnCodigoAtras = findViewById<ImageView>(R.id.imgretroceder)
        val btnconfirmar = findViewById<Button>(R.id.btnconfirmar)
        val btnscorregir = findViewById<Button>(R.id.btncorregir)

        val tvcelular = findViewById<TextView>(R.id.txtresulcel)
        val tvcuanto = findViewById<TextView>(R.id.txtresulcuanto)
        val tvmensaje = findViewById<TextView>(R.id.txtresulmensaje)
        //Traer los datos de la Activity Anterior
        val cel = intent.getStringExtra("Celular")
        val cua = intent.getStringExtra("Cuanto")
        val men = intent.getStringExtra("Mensaje")
        // Imprimir los Datos en el Activity
        tvcelular.text = "$cel"
        tvcuanto.text = "$cua"
        tvmensaje.text = "$men"

        btnCodigoAtras.setOnClickListener{
            val intentAtras = Intent(this,activity_envia::class.java).apply {}
            startActivity(intentAtras)
        }
        btnconfirmar.setOnClickListener{
            val cell = tvcelular.text.toString()
            val cuanto = tvcuanto.text.toString()
            val mensaje = tvmensaje.text.toString()
            val intentConfirmar = Intent(this,activity_envia_confirmado::class.java).apply {
                putExtra("Celular",cell)
                putExtra("Cuanto",cuanto)
                putExtra("Mensaje",mensaje)
            }
            startActivity(intentConfirmar)
        }
        btnscorregir.setOnClickListener{
            val intentCorregir = Intent(this,activity_envia_neking::class.java).apply {}
            startActivity(intentCorregir)
        }

    }
}