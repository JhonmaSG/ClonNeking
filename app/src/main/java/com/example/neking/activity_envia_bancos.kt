package com.example.neking

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class activity_envia_bancos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_envia_bancos)

        val btnenviar = findViewById<Button>(R.id.btnlisto)
        val btnCodigoAtras = findViewById<ImageView>(R.id.imgretroceder)

        val inputNom = findViewById<EditText>(R.id.inputnombre)
        val inputTipoDoc = findViewById<EditText>(R.id.inputtipodocumento)
        val inputDoc = findViewById<EditText>(R.id.inputdocumento)
        val inputBanco = findViewById<EditText>(R.id.inputbanco)
        val inputTipoCuenta = findViewById<EditText>(R.id.inputtipocuenta)
        val inputNumCuenta = findViewById<EditText>(R.id.inputnumerocuenta)
        val inputCuanto = findViewById<EditText>(R.id.inputcuanto)

        btnCodigoAtras.setOnClickListener{
            val intentAtras = Intent(this,activity_envia::class.java).apply {}
            startActivity(intentAtras)
        }

        btnenviar.setOnClickListener{

            // Obtén los valores de los campos de texto
            val verinom = inputNom.text.toString().trim()
            val veritipoDoc = inputTipoDoc.text.toString().trim()
            val veridoc = inputDoc.text.toString().trim()
            val veribanco = inputBanco.text.toString().trim()
            val veritipoCuenta = inputTipoCuenta.text.toString().trim()
            val verinumCuenta = inputNumCuenta.text.toString().trim()
            val vericuanto = inputCuanto.text.toString().trim()

            if (verinom.isEmpty() || veritipoDoc.isEmpty() || veridoc.isEmpty() ||
                veribanco.isEmpty() || veritipoCuenta.isEmpty() ||
                verinumCuenta.isEmpty() || vericuanto.isEmpty()) {
                Toast.makeText(this, "Llene todos los campos", Toast.LENGTH_LONG).show()

            } else {
                // Si todos los campos están llenos, next activity
                val nom = inputNom.text.toString()
                val tipoDoc = inputTipoDoc.text.toString()
                val doc = inputDoc.text.toString()
                val banco = inputBanco.text.toString()
                val tipoCuenta = inputTipoCuenta.text.toString()
                val numCuenta = inputNumCuenta.text.toString()
                val cuanto = inputCuanto.text.toString()

                val intentAdelante =
                    Intent(this, activity_envia_bancos_confirmar::class.java).apply {
                        putExtra("Nombre", nom)
                        putExtra("TipoDocumento", tipoDoc)
                        putExtra("Documento", doc)
                        putExtra("Banco", banco)
                        putExtra("TipoCuenta", tipoCuenta)
                        putExtra("NumeroCuenta", numCuenta)
                        putExtra("Cuanto", cuanto)
                    }
                startActivity(intentAdelante)
            }
        }
    }
}