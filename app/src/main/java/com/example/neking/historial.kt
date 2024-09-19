package com.example.neking

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class historial : AppCompatActivity() {
    private lateinit var onClickListener: (Int) -> Unit
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.historial)

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


        var rv_comprobantes: RecyclerView = findViewById(R.id.recycle_v_e)
        rv_comprobantes.layoutManager = LinearLayoutManager(this)

        var listaComprobantes = ArrayList<lista_comprobantes>()
        listaComprobantes.add(lista_comprobantes("Chao","De","-$50.000,00"))
        listaComprobantes.add(lista_comprobantes("Pepe","De","-$50.000,00"))
        listaComprobantes.add(lista_comprobantes("Antonio","De","-$50.000,00"))
        listaComprobantes.add(lista_comprobantes("Jose","De","-$50.000,00"))

        rv_comprobantes.adapter = conexion_lista(listaComprobantes)

    }
}
