package com.example.neking

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_principal)

        // Botón para navegar a la vista "colchon.xml"
        val btnNavigate = findViewById<Button>(R.id.btnColchon)
        btnNavigate.setOnClickListener {
            val inflater = LayoutInflater.from(this)
            val colchonView = inflater.inflate(R.layout.colchon, null)
            setContentView(colchonView)
        }

        // Botón para mostrar el menú desplegable (BottomSheet)
        val btnAccion = findViewById<Button>(R.id.btnaccion)
        btnAccion.setOnClickListener {
            // Crear y mostrar el BottomSheetDialog
            val bottomSheetDialog = BottomSheetDialog(this)

            // Inflar el layout del menú
            val view = LayoutInflater.from(this).inflate(R.layout.desplegable, null)

            // Configurar el layout al BottomSheetDialog
            bottomSheetDialog.setContentView(view)

            // Mostrar el BottomSheet
            bottomSheetDialog.show()

            // Configurar clics en las acciones del menú
            view.findViewById<Button>(R.id.action1).setOnClickListener {
                // Manejar la acción 1
                Log.d("BottomSheet", "Acción 1 seleccionada")
                bottomSheetDialog.dismiss()  // Ocultar el BottomSheet
            }

            view.findViewById<Button>(R.id.action2).setOnClickListener {
                // Manejar la acción 2
                Log.d("BottomSheet", "Acción 2 seleccionada")
                bottomSheetDialog.dismiss()  // Ocultar el BottomSheet
            }

            view.findViewById<Button>(R.id.action3).setOnClickListener {
                // Manejar la acción 3
                Log.d("BottomSheet", "Acción 3 seleccionada")
                bottomSheetDialog.dismiss()  // Ocultar el BottomSheet
            }
        }
    }
}
