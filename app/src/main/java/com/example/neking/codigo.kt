package com.example.neking

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class codigo : AppCompatActivity() {
    private var isCodeHidden = false  // Variable para llevar el control del estado
    private var generatedCode: String = ""  // Variable para almacenar el código generado

    private lateinit var txtTime: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sacar_codigo)

        val btnCodigoAtras = findViewById<ImageView>(R.id.imgretroceder)
        val imgeye = findViewById<ImageView>(R.id.imgeye)
        val txtcodigo = findViewById<TextView>(R.id.txtcodigo)

        txtTime = findViewById(R.id.txttime)

        // Generar el código aleatorio de 6 dígitos
        generatedCode = generateRandomCode()

        // Mostrar el código generado al iniciar la actividad
        txtcodigo.text = generatedCode

        // Iniciar el temporizador
        startTimer()

        btnCodigoAtras.setOnClickListener {
            val intentCodigoAtras = Intent(this, activity_sacar::class.java)
            startActivity(intentCodigoAtras)
        }

        imgeye.setOnClickListener {
            if (isCodeHidden) {
                // Mostrar el código generado e imagen
                txtcodigo.text = generatedCode
                imgeye.setImageResource(R.drawable.eye_regular)
            } else {
                // Ocultar el código e imagen
                txtcodigo.text = "***-***"
                imgeye.setImageResource(R.drawable.eye_slash_regular)
            }
            isCodeHidden = !isCodeHidden  // Cambiar el estado
        }
    }

    // Función para generar un código aleatorio de 6 dígitos
    private fun generateRandomCode(): String {
        val randomNumber = Random.nextInt(100000, 999999)  // Genera un número entre 100000 y 999999
        return randomNumber.toString()
    }

    // Función para iniciar el temporizador
    private fun startTimer() {
        val timer = object : CountDownTimer(29 * 60 * 1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val minutes = (millisUntilFinished / 1000) / 60
                val seconds = (millisUntilFinished / 1000) % 60
                txtTime.text = String.format("%02d:%02d", minutes, seconds)
            }

            override fun onFinish() {
                txtTime.text = "00:00"
            }
        }

        timer.start()
    }
}
