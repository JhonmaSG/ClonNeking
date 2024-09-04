package com.example.neking

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Password : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.password_layout)

        //LOGICA DE LA CONTRASEÑA
        val pass1 = findViewById<TextView>(R.id.txtPass1)
        val pass2 = findViewById<TextView>(R.id.txtPass2)
        val pass3 = findViewById<TextView>(R.id.txtPass3)
        val pass4 = findViewById<TextView>(R.id.txtPass4)
        //BOTONES
        val btn1 = findViewById<TextView>(R.id.btn1)
        val btn2 = findViewById<TextView>(R.id.btn2)
        val btn3 = findViewById<TextView>(R.id.btn3)
        val btn4 = findViewById<TextView>(R.id.btn4)
        val btn5 = findViewById<TextView>(R.id.btn5)
        val btn6 = findViewById<TextView>(R.id.btn6)
        val btn7 = findViewById<TextView>(R.id.btn7)
        val btn8 = findViewById<TextView>(R.id.btn8)
        val btn9 = findViewById<TextView>(R.id.btn9)
        val btn0 = findViewById<TextView>(R.id.btn0)
        val btnDelete = findViewById<ImageView>(R.id.btnDelete)
        val btnVolver = findViewById<FrameLayout>(R.id.btnVolver)

        var password = ""
        btnVolver.setOnClickListener {
            // Terminar la actividad actual y regresar a la actividad anterior
            finish()
        }
        // Función para actualizar los TextView basados en la contraseña actual
        fun updatePasswordViews() {
            val passViews = listOf(pass1, pass2, pass3, pass4)
            passViews.forEachIndexed { index, textView ->
                if (index < password.length) {
                    textView.text = "*"
                } else {
                    textView.text = ""
                }
            }
        }
        btnDelete.setOnClickListener {
            if (password.isNotEmpty()) {
                password = password.dropLast(1)
                Log.d("Password", "Contraseña modificada (último dígito eliminado): $password")
                updatePasswordViews()
            }
        }
        // Función para manejar el clic de los botones numéricos
        fun onNumberButtonClick(number: Int) {
            if (password.length < 4) {
                password += number.toString()
                Log.d("Password", "Contraseña modificada: $password")
                updatePasswordViews()
                if(password == "1234"){
                    val intent = Intent(this, Home::class.java)
                    startActivity(intent)
                }
            }
        }
        // Asignación de la acción a cada botón numérico
        btn1.setOnClickListener { onNumberButtonClick(1) }
        btn2.setOnClickListener { onNumberButtonClick(2) }
        btn3.setOnClickListener { onNumberButtonClick(3) }
        btn4.setOnClickListener { onNumberButtonClick(4) }
        btn5.setOnClickListener { onNumberButtonClick(5) }
        btn6.setOnClickListener { onNumberButtonClick(6) }
        btn7.setOnClickListener { onNumberButtonClick(7) }
        btn8.setOnClickListener { onNumberButtonClick(8) }
        btn9.setOnClickListener { onNumberButtonClick(9) }
        btn0.setOnClickListener { onNumberButtonClick(0) }

    }

}
