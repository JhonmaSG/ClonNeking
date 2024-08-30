package com.example.neking

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_principal)

        val btnNavigate = findViewById<Button>(R.id.btnColchon)
        btnNavigate.setOnClickListener {
                val inflater = LayoutInflater.from(this)
                val colchonView = inflater.inflate(R.layout.colchon, null)
                setContentView(colchonView)

        }
    }
}
