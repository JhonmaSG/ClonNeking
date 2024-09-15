package com.example.neking

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class activity_envia_bancos_confirmado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_envia_bancos_confirmado)

        val btnenviar = findViewById<Button>(R.id.btnlisto)

        val tvNom = findViewById<TextView>(R.id.txtresultnombredestino)
        val tvTipoDoc = findViewById<TextView>(R.id.txtresultipodocumento)
        val tvDoc = findViewById<TextView>(R.id.txtresuldestinario)
        val tvBanco = findViewById<TextView>(R.id.txtresulbanco)
        val tvTipoCuenta = findViewById<TextView>(R.id.txtresultipocuenta)
        val tvNumCuenta = findViewById<TextView>(R.id.txtresulnumerocuenta)
        val tvCuanto = findViewById<TextView>(R.id.txtresulcuanto)
        //Traer los datos de la Activity Anterior
        val nom = intent.getStringExtra("Nombre")
        val tipo = intent.getStringExtra("TipoDocumento")
        val doc = intent.getStringExtra("Documento")
        val banco = intent.getStringExtra("Banco")
        val tipocu = intent.getStringExtra("TipoCuenta")
        val numcu = intent.getStringExtra("NumeroCuenta")
        val cua = intent.getStringExtra("Cuanto")
        // Imprimir los Datos en el Activity
        tvNom.text = "$nom"
        tvTipoDoc.text = "$tipo"
        tvDoc.text = "$doc"
        tvBanco.text = "$banco"
        tvTipoCuenta.text = "$tipocu"
        tvNumCuenta.text = "$numcu"
        tvCuanto.text = "$cua"


        btnenviar.setOnClickListener{
            val intentAdelante = Intent(this,Home::class.java).apply {}
            startActivity(intentAdelante)
        }
    }
}