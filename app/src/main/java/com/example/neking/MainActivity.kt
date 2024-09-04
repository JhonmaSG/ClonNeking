package com.example.neking

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val celular = findViewById<EditText>(R.id.txtNumber)
        val ingresar = findViewById<FrameLayout>(R.id.btnEntra)

        ingresar.setOnClickListener{
            val cel = celular.text.toString()
            //CREAR EL INTENT PARA ENVIAR AL SIGUIENTE ACTIVITY
            val intent = Intent(this, Password::class.java).apply {
                putExtra("Cel", cel)
            }
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}