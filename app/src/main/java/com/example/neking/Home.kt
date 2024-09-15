package com.example.neking

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.util.Log

class Home : AppCompatActivity() {

    private var isMenuOpen = false  // Controla si el menú está abierto o cerrado
    private var isObscured = false // Variable para verificar si el texto está oculto
    private var originalText: String = ""

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_principal)

        // Botón para navegar a la vista "colchon.xml"
        val btnNavigate = findViewById<Button>(R.id.btnColchon)
        btnNavigate.setOnClickListener {
            val inflater = LayoutInflater.from(this)
            val colchonView = inflater.inflate(R.layout.colchon, null)
            setContentView(colchonView)

            // Botón para regresar al menú principal desde la vista colchon.xml
            val buttonBack = colchonView.findViewById<Button>(R.id.buttonback)
            buttonBack.setOnClickListener {
                // Regresar al menú principal
                val intent = Intent(this, Home::class.java)
                startActivity(intent)
                finish() // Finalizar la actividad actual si quieres evitar que se pueda regresar a ella
            }
        }

        // Listener para el botón btnview
        val btnView: Button = findViewById(R.id.btnview)
        val textViewMoney: TextView = findViewById(R.id.textViewMoney)

        // Guardar el texto original del TextView
        originalText = textViewMoney.text.toString()

        // Listener para el botón btnview
        btnView.setOnClickListener {
            // Alternar entre guiones y el valor original
            if (isObscured) {
                // Si está oculto, mostrar el texto original
                textViewMoney.text = originalText
            } else {
                // Si no está oculto, cambiar a guiones
                textViewMoney.text = "---.---"
            }
            // Cambiar el estado
            isObscured = !isObscured
        }

        // Botón de acción principal
        val btnAccion = findViewById<Button>(R.id.btnAccion)
        val blurView = findViewById<View>(R.id.blur_view)  // Vista de desenfoque para resaltar menú

        // Botones que se desplegarán
        val btnAction1 = findViewById<Button>(R.id.btnAction1)
        val btnAction2 = findViewById<Button>(R.id.btnAction2)
        val btnAction3 = findViewById<Button>(R.id.btnAction3)
        val btnAction4 = findViewById<Button>(R.id.btnAction4)

        // Textos descriptivos correspondientes a los botones
        val descAction1 = findViewById<TextView>(R.id.descAction1)
        val descAction2 = findViewById<TextView>(R.id.descAction2)
        val descAction3 = findViewById<TextView>(R.id.descAction3)
        val descAction4 = findViewById<TextView>(R.id.descAction4)

        // Lista de botones y textos
        val buttons = listOf(btnAction1, btnAction2, btnAction3, btnAction4)
        val descriptions = listOf(descAction1, descAction2, descAction3, descAction4)

        // Al hacer clic en el botón de acción, se despliega el menú
        btnAccion.setOnClickListener {
            if (isMenuOpen) {
                closeMenu(buttons, descriptions)
                animateBlurView(blurView, false)  // Desactivar desenfoque solo en el fondo
                btnAccion.text = "$"  // Cambia el texto al cerrar el menú
            } else {
                openMenu(buttons, descriptions)
                animateBlurView(blurView, true)  // Activar desenfoque solo en el fondo
                btnAccion.text = "X"  // Cambia el texto al abrir el menú
            }
            isMenuOpen = !isMenuOpen  // Alterna el estado del menú
        }

        // Configuración de clics para los botones dentro del menú desplegable
        btnAction1.setOnClickListener {
            Log.d("Menu", "Acción 1 seleccionada")
            closeMenu(buttons, descriptions)

        }
        btnAction2.setOnClickListener {
            Log.d("Menu", "Acción 2 seleccionada")
            closeMenu(buttons, descriptions)
        }
        btnAction3.setOnClickListener {
            Log.d("Menu", "Acción 3 seleccionada")
            closeMenu(buttons, descriptions)
        }
        btnAction4.setOnClickListener {
            Log.d("Menu", "Acción 4 seleccionada")
            closeMenu(buttons, descriptions)
        }
    }

    // Función para abrir el menú con animación
    private fun openMenu(buttons: List<Button>, descriptions: List<TextView>) {
        buttons.forEachIndexed { index, button ->
            button.visibility = View.VISIBLE
            descriptions[index].visibility = View.VISIBLE  // Hacer visible la descripción
            val animation = TranslateAnimation(0f, 0f, button.height.toFloat(), 0f)
            animation.duration = (index * 100 + 300).toLong()  // Animación escalonada
            button.startAnimation(animation)
            descriptions[index].startAnimation(animation)  // Animar la descripción
        }
    }

    // Función para cerrar el menú con animación
    private fun closeMenu(buttons: List<Button>, descriptions: List<TextView>) {
        buttons.forEachIndexed { index, button ->
            val animation = TranslateAnimation(0f, 0f, 0f, button.height.toFloat())
            animation.duration = (index * 100 + 300).toLong()
            animation.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {}
                override fun onAnimationEnd(animation: Animation) {
                    button.visibility = View.GONE  // Ocultar el botón al terminar la animación
                    descriptions[index].visibility = View.GONE  // Ocultar la descripción
                }
                override fun onAnimationRepeat(animation: Animation) {}
            })
            button.startAnimation(animation)
            descriptions[index].startAnimation(animation)  // Animar la descripción
        }
    }

    // Función para animar el desenfoque de la vista
    private fun animateBlurView(view: View, show: Boolean) {
        val alpha = if (show) 1f else 0f
        val animator = ObjectAnimator.ofFloat(view, "alpha", alpha)
        animator.duration = 300  // Duración de la animación en milisegundos
        animator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                if (!show) {
                    view.visibility = View.GONE
                }
            }
        })
        view.visibility = View.VISIBLE  // Mostrar la vista de desenfoque
        animator.start()
    }
}