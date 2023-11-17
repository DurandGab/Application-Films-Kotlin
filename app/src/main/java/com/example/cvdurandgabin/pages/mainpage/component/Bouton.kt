package com.example.cvdurandgabin.pages.mainpage.component

import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun Bouton(modifier: Modifier, onClick: () -> Unit){
    Log.d("XXX", "onButton")
    Button(
        onClick = { onClick()
                  Log.d("XXX", "onClick")},
        colors = ButtonDefaults.buttonColors(Color(0xff00ffd4))) {
        Text( text="Démarrer",
            fontSize= 25.sp,
            color = Color.Black
        )
    }
}