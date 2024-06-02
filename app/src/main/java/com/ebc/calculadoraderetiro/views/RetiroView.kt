package com.ebc.calculadoraderetiro.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ebc.calculadoraderetiro.components.MainIconButton
import com.ebc.calculadoraderetiro.components.TitleBar
import com.ebc.calculadoraderetiro.R
import com.ebc.calculadoraderetiro.components.DosCartas

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RetiroView(navController: NavController,viewModel: CalculadoraViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { TitleBar(headerText = "Calcula tu retiro") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Blue
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.Default.ArrowBack) {
                        navController.popBackStack()
                    }
                }
            )
        }
    ) {
        ContentRetiroView(paddingValues = it, viewModel = viewModel)
    }
    @Composable
    fun ContentRetiroView(paddingValues: PaddingValues, viewModel: CalculadoraViewModel) {

            Spacer(modifier = Modifier.height(10.dp))
            val imagenAhorro = painterResource(id = R.drawable.puerco)
            Image(
                painter = imagenAhorro,
                contentDescription = "imagenAhorro"
            )

        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = state.monto_anual,
            onValueChange = {
                viewModel.onValue(it, "Monto anual")
            },
            label = { Text(text = "Monto anual")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = state.interes,
            onValueChange = {
                viewModel.onValue(it, "Interes")
            },
            label = { Text(text = "Interes %")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = state.años,
            onValueChange = {
                viewModel.onValue(it, "Años")
            },
            label = { Text(text = "Años")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )

        Column(
            modifier =
            Modifier
                .padding(paddingValues)
                .padding(10.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val state = viewModel.state

            DosCartas(
                titulo1 = "Total Ahorrado", dato1 = state.monto_ahorrado,
                titulo2 = "Monto Final", dato2 = state.monto_retiro
            )

        }

    }

}
