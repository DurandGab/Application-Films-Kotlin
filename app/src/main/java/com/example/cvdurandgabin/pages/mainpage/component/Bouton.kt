package com.example.cvdurandgabin.pages.mainpage.component

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun Bouton(modifier: Modifier){
    Button(onClick = { /*TODO*/ },colors = ButtonDefaults.buttonColors(Color.Blue)) {
        Text( text="Démarrer",
            fontSize= 25.sp
        )
    }
}