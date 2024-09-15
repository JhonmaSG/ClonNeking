package com.example.neking

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class detaller_historico_r : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.detalle_historico_r)
        val btn_regresar : ImageView = findViewById(R.id.retroceder_detalle_r)
        btn_regresar.setOnClickListener {
            val intent = Intent(this, historial::class.java)
            startActivity(intent)
        }
    }
}