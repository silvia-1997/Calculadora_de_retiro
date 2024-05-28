package com.ebc.calculadoraderetiro.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ebc.calculadoraderetiro.views.BienvenidoView

//se agregara toda la logica de navegacion

@Composable
fun NavManager (){
    val navController = rememberNavController()
    NavHost(navController =navController , startDestination = "Bienvenido"){
        composable( "Bienvenido"){
            BienvenidoView(navController=navController)
        }
    }
}