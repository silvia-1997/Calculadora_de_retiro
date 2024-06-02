package com.ebc.calculadoraderetiro.views

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.ebc.calculadoraderetiro.model.CalculadoraSate
import kotlin.math.pow

class CalculadoraViewModel: ViewModel() {
    var state by mutableStateOf(CalculadoraSate())
        private set

    fun onValue(value: String, text: String, ) {
        when (text) {
            "monto_anual" -> state = state.copy(monto_mensual = value)
            "interes" -> state = state.copy(interes = value)
            "años" -> state = state.copy(años = value)
        }
    }

    fun calcular() {
        val monto_anual = state.monto_mensual
        val interes = state.interes
        val años = state.años

        state = if (monto_anual != "" && interes != "" && años != ""){
            state.copy(
                monto_ahorrado = CalcularTotalAhorrado( monto_anual.toDouble(), años.toDouble()),
                monto_retiro =CalcularMontoFinal(monto_anual.toDouble(), interes.toDouble(), años.toDouble())
            )
    }else{
        state.copy(
            mostrarAlerta=true
        )

    }
}
    private fun CalcularTotalAhorrado(monto_anual:Double, años:Double){
        val montoahorrado = CalcularTotalAhorrado(monto_anual, años)
        return montoahorrado * años

    }

    private fun CalcularMontoFinal (monto_anual:Double, interes:Double, años:Double):Double) {
        val montofinal = CalcularMontoFinal((monto_anual, interes, años))
        return monto_anual * (años.pow((1 + interes)))
    }
}



