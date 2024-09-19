package com.example.neking

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class activity_envia_neking : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_envia_neking)
        val btnCodigoAtras = findViewById<ImageView>(R.id.imgretroceder)

        val edtcelular = findViewById<EditText>(R.id.inputcel)
        val edtname = findViewById<EditText>(R.id.inputname)
        val edtcuanto = findViewById<EditText>(R.id.inputcuanto)
        val edtmensaje = findViewById<EditText>(R.id.inputmensaje)
        val btnsiguiente = findViewById<Button>(R.id.btnlisto)

        // Expresión regular para validar solo letras y espacios
        val nombrePattern = Regex("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")

        btnCodigoAtras.setOnClickListener {
            val intentCodigoAtras = Intent(this, activity_envia::class.java).apply {}
            startActivity(intentCodigoAtras)
        }

        btnsiguiente.setOnClickListener {

            // Obtén los valores de los campos de texto
            val vericel = edtcelular.text.toString().trim()
            val veriname = edtname.text.toString().trim()
            val vericuanto = edtcuanto.text.toString().trim()
            val verimensaje = edtmensaje.text.toString().trim()

            // Validación
            if (vericel.isEmpty() || veriname.isEmpty() || vericuanto.isEmpty() || verimensaje.isEmpty()) {
                Toast.makeText(this, "Llene todos los campos", Toast.LENGTH_LONG).show()
            } else if (!veriname.matches(nombrePattern)) {
                // Validación para nombre: no permitir números ni caracteres especiales
                Toast.makeText(this, "El nombre solo puede contener letras y espacios", Toast.LENGTH_LONG).show()

            } else if (vericel.length > 10 || vericel.length < 10) {
                Toast.makeText(this, "El número de celular debe tener 10 dígitos", Toast.LENGTH_LONG).show()
            } else {
                val cel = edtcelular.text.toString()
                val name = edtname.text.toString()
                val cuanto = edtcuanto.text.toString()
                val mensaje = edtmensaje.text.toString()

                val intentConfirmarPago =
                    Intent(this, activity_envia_neking_confirmar::class.java).apply {
                        putExtra("Celular", cel)
                        putExtra("Nombre", name)
                        putExtra("Cuanto", cuanto)
                        putExtra("Mensaje", mensaje)
                    }
                startActivity(intentConfirmarPago)
            }
        }
    }
}
