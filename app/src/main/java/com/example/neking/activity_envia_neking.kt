package com.example.neking

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class activity_envia_neking : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_envia_neking)
        val btnCodigoAtras = findViewById<ImageView>(R.id.imgretroceder)

        val edtcelular = findViewById<EditText>(R.id.inputcel)
        val edtcuanto = findViewById<EditText>(R.id.inputcuanto)
        val edtmensaje = findViewById<EditText>(R.id.inputmensaje)
        val btnsiguiente = findViewById<Button>(R.id.btnlisto)

        btnCodigoAtras.setOnClickListener {
            val intentCodigoAtras = Intent(this,activity_envia::class.java).apply {}
            startActivity(intentCodigoAtras)
        }

        btnsiguiente.setOnClickListener {
            val cel = edtcelular.text.toString()
            val cuanto = edtcuanto.text.toString()
            val mensaje = edtmensaje.text.toString()

            val intentConfirmarPago = Intent(this,activity_envia_por_confirmar::class.java).apply {
                putExtra("Celular",cel)
                putExtra("Cuanto",cuanto)
                putExtra("Mensaje",mensaje)
            }
            startActivity(intentConfirmarPago)
        }
    }
}