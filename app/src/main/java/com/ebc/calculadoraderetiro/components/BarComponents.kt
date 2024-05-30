package com.ebc.calculadoraderetiro.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import org.w3c.dom.Text

@Composable

fun TitleBar(headerText: String){
    Text(text=headerText, fontSize = 40.sp, color= Color.White)
}


