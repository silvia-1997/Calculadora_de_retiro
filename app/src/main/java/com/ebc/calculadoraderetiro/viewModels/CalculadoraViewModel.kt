package com.ebc.calculadoraderetiro.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.ebc.calculadoraderetiro.model.CalculadoraState
import kotlin.math.pow

class CalculadoraViewModel : ViewModel() {
    var state by mutableStateOf(CalculadoraState())
        private set

    fun onValue(value: String, text: String) {
        when (text) {
            "monto_anual" -> state = state.copy(monto_anual = value)
            "interes" -> state = state.copy(interes = value)
            "años" -> state = state.copy(años = value)
        }
    }

    fun calcular() {
        val monto_anual = state.monto_anual
        val interes = state.interes
        val años = state.años

        val montoAnualDouble = monto_anual.toDoubleOrNull()
        val interesDouble = interes.toDoubleOrNull()
        val añosDouble = años.toDoubleOrNull()

        if (montoAnualDouble != null && interesDouble != null && añosDouble != null) {
            state = state.copy(
                monto_ahorrado = calcularMontoAhorrado(montoAnualDouble, añosDouble),
                monto_retiro = calcularMontoFinal(montoAnualDouble, interesDouble, añosDouble),
                mostrarAlerta = false
            )
        } else {
            state = state.copy(
                mostrarAlerta = true
            )
        }
    }

    private fun calcularMontoAhorrado(monto_anual: Double, años: Double): Double {
        return monto_anual * años
    }

    private fun calcularMontoFinal(monto_anual: Double, interes: Double, años: Double): Double {
        return monto_anual * ((1 + interes).pow(años))
    }
}
