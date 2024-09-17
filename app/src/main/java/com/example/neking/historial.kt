package com.example.neking

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class historial : AppCompatActivity() {
    private lateinit var onClickListener: (Int) -> Unit
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.historial)


        val datosLista = intent.getStringArrayListExtra("datosLista")
        Log.d("Historial", "datosLista recibido en historial: $datosLista") // Agregar un log para verificar


        val btn_regresar = findViewById<Button>(R.id.btnhome)
        btn_regresar.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

        val btn_history = findViewById<Button>(R.id.btnhistory)
        btn_history.setOnClickListener {
            val intent = Intent(this, historial::class.java)
            startActivity(intent)
        }



            var listaComprobantes = ArrayList<lista_comprobantes>()


            // Priorizamos los datos recibidos en el Intent
            if (datosLista != null) {

                Log.d("Historial", "datosLista recibido en el recycle: $datosLista") // Agregar un log para verificar
                listaComprobantes.add(lista_comprobantes(datosLista[0], datosLista[1], datosLista[2]))

            } else {
                // Si no hay datos en el Intent, usamos una lista predefinida (opcional)
                listaComprobantes.add(lista_comprobantes("Chao", "De", "-$50.000,00"))
                // ... (agregar más elementos si es necesario)
            }

        // Actualizar el RecyclerView con los nuevos datos
        var rv_comprobantes: RecyclerView = findViewById(R.id.recycle_v_e)
        rv_comprobantes.layoutManager = LinearLayoutManager(this)
        // Crear una instancia de tu adaptador
        rv_comprobantes.adapter = conexion_lista(listaComprobantes)




    }
}

