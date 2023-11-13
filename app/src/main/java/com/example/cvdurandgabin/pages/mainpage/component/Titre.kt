package com.example.cvdurandgabin.pages.mainpage.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Titre(modifier: Modifier){
    Text(
        text = "Gabin Durand",
        fontWeight = FontWeight.Bold,
        fontSize = 35.sp,
        modifier = modifier.background(Color.White)
    )
    Spacer(modifier = Modifier.height(25.dp))

    Text(
        text = "Étudiant en BUT Métier du multimédiat \n et de l'internet en 3eme année",
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Center
    )
    Spacer(modifier = Modifier.height(30.dp))

    Text(
        text = "IUT Paul Sabatier - Castres"
    )

}