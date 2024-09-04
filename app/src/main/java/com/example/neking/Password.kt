package com.example.neking

import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Password : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.password_layout)

        // CAMBIAR PUNTOS POR ASTERISCOS
        val pass1 = findViewById<EditText>(R.id.pass1)
        val pass2 = findViewById<EditText>(R.id.pass2)
        val pass3 = findViewById<EditText>(R.id.pass3)
        val pass4 = findViewById<EditText>(R.id.pass4)
        // Aplicar la transformación a todos los EditText
        applyPasswordTransformation(pass1, pass2, pass3, pass4)
    }

    // Función para aplicar la transformación de contraseñas
    private fun applyPasswordTransformation(vararg editTexts: EditText) {
        val passwordTransformation = object : PasswordTransformationMethod() {
            override fun getTransformation(source: CharSequence, view: View): CharSequence {
                return PasswordCharSequence(source)
            }
        }
        editTexts.forEach { it.transformationMethod = passwordTransformation }
    }

    // Clase para reemplazar el texto con asteriscos
    private class PasswordCharSequence(private val source: CharSequence) : CharSequence {
        override val length: Int
            get() = source.length

        override fun get(index: Int): Char {
            return '*'
        }

        override fun subSequence(startIndex: Int, endIndex: Int): CharSequence {
            return source.subSequence(startIndex, endIndex)
        }
    }
}
