package com.example.neking

open class lista_comprobantes{
    var nombre:String? = null
    var estado:String? = null
    var valor:String? = null

    constructor(nombre:String,estado:String,valor:String){
        this.nombre = nombre
        this.estado = estado
        this.valor = valor
    }
}