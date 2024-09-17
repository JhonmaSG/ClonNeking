package com.example.neking

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class activity_envia_neking_confirmado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_envia_neking_confirmado)

        /*val listaContador_comprobantes = ArrayList<ArrayList<String?>>()*/
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


        btnconfirmar.setOnClickListener {
            val datosLista = arrayListOf(name, cel, cua)
            Log.d("Historial", "datosLista recibido en funcion: $datosLista") // Agregar un log para verificar
            // Enviar datos a Historial (reemplaza con tu lógica real)
            val intentHistorial = Intent(this@activity_envia_neking_confirmado, historial::class.java).apply {
                putStringArrayListExtra("datosLista", datosLista)
            }
            startActivity(intentHistorial)
        }


    }

    fun enviarDatosAHistorialYVolverAHome(name: String, cel: String, cua: String) = CoroutineScope(Dispatchers.IO).launch {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val datosLista = arrayListOf(name, cel, cua)
                Log.d("Historial", "datosLista recibido en funcion: $datosLista") // Agregar un log para verificar

                // Simular una operación que toma tiempo
                delay(2000) // Simula un retraso de 2 segundos

                // Enviar datos a Historial (reemplaza con tu lógica real)
                val intentHistorial = Intent(this@activity_envia_neking_confirmado, historial::class.java).apply {
                        putStringArrayListExtra("datosLista", datosLista)
                    }
                startActivity(intentHistorial)

                // Iniciar la actividad Home
                val intentHome = Intent(this@activity_envia_neking_confirmado, Home::class.java)
                startActivity(intentHome)


            } catch (e: Exception) {
                withContext(Dispatchers.Main) { // Cambiar al hilo principal para actualizar la UI
                    Toast.makeText(
                        this@activity_envia_neking_confirmado,
                        "Error al enviar datos",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }

        }

    }
}

