package com.example.neking

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


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

    }
}
