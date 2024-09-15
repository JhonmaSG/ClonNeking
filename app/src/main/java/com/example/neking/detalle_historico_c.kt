package com.example.neking

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class detalle_historico_c: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detalle_historico_c)
        val btn_regresar : ImageView = findViewById(R.id.retroceder_detalle_c)
        btn_regresar.setOnClickListener {
            val intent = Intent(this, historial::class.java)
            startActivity(intent)
        }
    }

}