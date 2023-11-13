package com.example.cvdurandgabin.pages.mainpage.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cvdurandgabin.R

@Composable
fun Image(modifier: Modifier){
    androidx.compose.foundation.Image(
        painterResource(R.drawable.gabix),
        contentDescription = "gabix",
        modifier = modifier
            .size(200.dp)
            .border(BorderStroke(2.dp, Color.Black), CircleShape)
            .clip(CircleShape)

    )
}
