package com.ebc.calculadoraderetiro.model

data class CalculadoraState(
    val monto_anual:String="",
    val interes:String="",
    val años:String="",
    val monto_ahorrado: Double=0.0,
    val monto_retiro:Double=0.0,
    val mostrarAlerta: Boolean =false
)
