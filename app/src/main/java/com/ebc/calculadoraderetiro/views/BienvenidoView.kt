package com.ebc.calculadoraderetiro.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarColors
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
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable

fun BienvenidoView(navController: NavController){
    Scaffold (
        topBar={
            CenterAlignedTopAppBar(title = {Text(text="Bienvenido", fontSize = 25.sp, color=Color.White)},
                colors=TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Blue
                ))
        }
        ){
    }
}

@Composable
fun ContentBienvenidoView(navController: NavController){
    val id = 123
    var opcional by remember{
        mutableStateOf("")
    }

    Column(

        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView(name = "Bienvenido")
        Space()
        TextField(value = opcional, onValueChange = { opcional = it})
        Space()
        MainButton(name = "Realizar Calculo", backColor = Color.Blue, color = Color.White) {
           // navController.navigate("")
        }
    }
}


