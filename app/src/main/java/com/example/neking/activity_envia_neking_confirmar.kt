package com.example.neking

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class activity_envia_neking_confirmar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_envia_neking_confirmar)

        val btnCodigoAtras = findViewById<ImageView>(R.id.imgretroceder)
        val btnconfirmar = findViewById<Button>(R.id.btnconfirmar)
        val btnscorregir = findViewById<Button>(R.id.btncorregir)

        val tvnombree = findViewById<TextView>(R.id.txtresulnombredestino)
        val tvcelular = findViewById<TextView>(R.id.txtresulcelular)
        val tvcuanto = findViewById<TextView>(R.id.txtresulcuanto)
        val tvmensaje = findViewById<TextView>(R.id.txtresulmensaje)
        //Traer los datos de la Activity Anterior
        val cel = intent.getStringExtra("Celular")
        val name = intent.getStringExtra("Nombre")
        val cua = intent.getStringExtra("Cuanto")
        val men = intent.getStringExtra("Mensaje")
        // Imprimir los Datos en el Activity
        tvnombree.text = "$name"
        tvcelular.text = "$cel"
        tvcuanto.text = "$cua"
        tvmensaje.text = "$men"

        btnCodigoAtras.setOnClickListener{
            val intentAtras = Intent(this,activity_envia::class.java).apply {}
            startActivity(intentAtras)
        }
        btnconfirmar.setOnClickListener{
            val names = tvnombree.text.toString()
            val cell = tvcelular.text.toString()
            val cuanto = tvcuanto.text.toString()
            val mensaje = tvmensaje.text.toString()
            val intentConfirmar = Intent(this,activity_envia_neking_confirmado::class.java).apply {
                putExtra("Nombre",names)
                putExtra("Celular",cell)
                putExtra("Cuanto",cuanto)
                putExtra("Mensaje",mensaje)
            }
            startActivity(intentConfirmar)
        }
        btnscorregir.setOnClickListener{
            val intentCorregir = Intent().apply {
                putExtra("Nombre", name)
                putExtra("Celular", cel)
                putExtra("Cuanto", cua)
                putExtra("Mensaje", men)
            }
            setResult(RESULT_OK, intentCorregir)
            finish() // Cierra esta activity y regresa a la anterior
        }

    }
}