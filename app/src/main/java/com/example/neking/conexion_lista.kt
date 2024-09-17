package com.example.neking

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class conexion_lista(val listaComprobantes: List<lista_comprobantes>) :
    RecyclerView.Adapter<conexion_lista.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista =
            LayoutInflater.from(parent.context).inflate(R.layout.comprobante_retiro, parent, false)
        return ViewHolder(vista)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.nombre.text = listaComprobantes[position].nombre
            holder.estado.text = listaComprobantes[position].estado
            holder.valor.text = listaComprobantes[position].valor
    }

    override fun getItemCount(): Int {
        return listaComprobantes.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nombre: TextView = itemView.findViewById(R.id.nombre_user_h_r)
        var estado: TextView = itemView.findViewById(R.id.estado_user_h_r)
        var valor: TextView = itemView.findViewById(R.id.valor_user_h_c)

        init {
            itemView.setOnClickListener {
                try {
                    val intent = Intent(itemView.context, detalle_historico_r::class.java)
                    itemView.context.startActivity(intent)
                } catch (e: Exception) {
                    e.printStackTrace()
                    Toast.makeText(itemView.context, "Error al abrir detalle", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}