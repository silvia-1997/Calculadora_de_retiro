package com.ebc.calculadoraderetiro.components

import android.R
import android.icu.text.CaseMap.Title
import android.service.autofill.OnClickAction
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TitleView(name:String){
    Text(text=name, fontSize=40.sp)
}

@Composable
fun Space(){
    Spacer(modifier=Modifier.height(10.dp))
}

@Composable
fun MainButton(name:String, backColor: Color, color:Color, OnClick:() -> Unit){
    Button(
        onClick = OnClick,
        colors = ButtonDefaults.buttonColors(
            contentColor = color,
            containerColor = backColor
        )
    ) {
        Text(text=name)
  }
}