package com.ebc.calculadoraderetiro.views

import android.annotation.SuppressLint
import android.icu.text.CaseMap.Title
import android.view.View
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.ebc.calculadoraderetiro.components.MainButton
import com.ebc.calculadoraderetiro.components.Space
import com.ebc.calculadoraderetiro.components.TitleView
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ebc.calculadoraderetiro.components.TitleBar


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

@Composable
fun HomeView(navController: NavController){
    Scaffold (
        topBar={
            CenterAlignedTopAppBar(
                title = { TitleBar(headerText ="Piensa en grande") },
                colors=TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Black
                )
            )
        }
        ){
        ContentHomeView(navController)
    }
}


@Composable
fun ContentHomeView(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView(name = "Comienza a controlar tu futuro")
        Space()
        MainButton(
            name = "Calcular Retiro",
            backColor = Color.Blue,
            color = Color.White
        ) {
            navController.navigate("Calculadora")
        }
    }
}