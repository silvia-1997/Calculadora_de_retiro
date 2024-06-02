package com.ebc.calculadoraderetiro.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ebc.calculadoraderetiro.ui.theme.CalculadoraDeRetiroTheme
import com.ebc.calculadoraderetiro.viewModels.CalculadoraViewModel
import com.ebc.calculadoraderetiro.views.HomeView
import com.ebc.calculadoraderetiro.views.HomeView
import com.ebc.calculadoraderetiro.views.RetiroView

//se agregara toda la logica de navegacion

@Composable
fun NavManager () {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home") {
        composable("Home") {
            HomeView(navController = navController)

        }
        composable("Calculadora") {
            val viewModel: CalculadoraViewModel = viewModel()
            RetiroView(navController = navController, viewModel = viewModel)

    }
    }
}

