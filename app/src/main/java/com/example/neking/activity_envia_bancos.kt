package com.example.neking

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class activity_envia_bancos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_envia_bancos)

        val btnenviar = findViewById<Button>(R.id.btnlisto)
        val btnCodigoAtras = findViewById<ImageView>(R.id.imgretroceder)

        val inputNom = findViewById<EditText>(R.id.inputnombre)
        val inputTipoDoc = findViewById<Spinner>(R.id.inputtipodocumento)
        val inputDoc = findViewById<EditText>(R.id.inputdocumento)
        val inputBanco = findViewById<Spinner>(R.id.inputbanco)
        val inputTipoCuenta = findViewById<Spinner>(R.id.inputtipocuenta)
        val inputNumCuenta = findViewById<EditText>(R.id.inputnumerocuenta)
        val inputCuanto = findViewById<EditText>(R.id.inputcuanto)

        // Cargar los datos en los Spinners
        val documentTypes = resources.getStringArray(R.array.tipos_documentos)
        val banks = resources.getStringArray(R.array.bancos)
        val accountTypes = resources.getStringArray(R.array.tipo_cuenta)

        val adapterDoc = ArrayAdapter(this, android.R.layout.simple_spinner_item, documentTypes)
        adapterDoc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        inputTipoDoc.adapter = adapterDoc

        val adapterBank = ArrayAdapter(this, android.R.layout.simple_spinner_item, banks)
        adapterBank.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        inputBanco.adapter = adapterBank

        val adapterAccount = ArrayAdapter(this, android.R.layout.simple_spinner_item, accountTypes)
        adapterAccount.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        inputTipoCuenta.adapter = adapterAccount

        btnCodigoAtras.setOnClickListener {
            val intentAtras = Intent(this, activity_envia::class.java).apply {}
            startActivity(intentAtras)
        }

        btnenviar.setOnClickListener {
            // Obtén los valores de los campos de texto
            val verinom = inputNom.text.toString().trim()
            val veritipoDoc = inputTipoDoc.selectedItem.toString().trim()
            val veridoc = inputDoc.text.toString().trim()
            val veribanco = inputBanco.selectedItem.toString().trim()
            val veritipoCuenta = inputTipoCuenta.selectedItem.toString().trim()
            val verinumCuenta = inputNumCuenta.text.toString().trim()
            val vericuanto = inputCuanto.text.toString().trim()

            // Validaciones
            val invalidOption = "Tipo de documento"  // Para inputTipoDoc
            val invalidBank = "Bancos"                // Para inputBanco
            val invalidAccount = "Tipo de cuenta"     // Para inputTipoCuenta

            if (verinom.isEmpty() || veridoc.isEmpty() || veribanco.isEmpty() ||
                veritipoCuenta.isEmpty() || verinumCuenta.isEmpty() || vericuanto.isEmpty()) {
                Toast.makeText(this, "Llene todos los campos", Toast.LENGTH_LONG).show()
            } else if (veritipoDoc == invalidOption || veribanco == invalidBank || veritipoCuenta == invalidAccount) {
                Toast.makeText(this, "Por favor, seleccione una opción válida para todos los campos", Toast.LENGTH_LONG).show()
            } else {
                val nom = inputNom.text.toString()
                val tipoDoc = veritipoDoc
                val doc = veridoc
                val banco = veribanco
                val tipoCuenta = veritipoCuenta
                val numCuenta = verinumCuenta
                val cuanto = vericuanto

                val intentAdelante = Intent(this, activity_envia_bancos_confirmar::class.java).apply {
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
