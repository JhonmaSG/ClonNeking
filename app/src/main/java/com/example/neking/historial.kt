package com.example.neking

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class historial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.historial)
        /**val btn_regresar : Button = findViewById(R.id.chao)
        btn_regresar.setOnClickListener {
            val intent = Intent(this, detalle_historico_c::class.java)
            startActivity(intent)
        }**/
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
