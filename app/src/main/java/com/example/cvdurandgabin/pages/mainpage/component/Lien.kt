package com.example.cvdurandgabin.pages.mainpage.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cvdurandgabin.R

@Composable
fun Lien(modifier: Modifier) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(verticalArrangement = Arrangement.Center) {
            androidx.compose.foundation.Image(
                painterResource(R.drawable.mail),
                contentDescription = "email",
                modifier = modifier
                    .size(20.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            androidx.compose.foundation.Image(
                painterResource(R.drawable.link),
                contentDescription = "linkedin",
                modifier = modifier
                    .size(20.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            androidx.compose.foundation.Image(
                painterResource(R.drawable.github),
                contentDescription = "github",
                modifier = modifier
                    .size(20.dp)
            )
        }
        Spacer(modifier = Modifier.width(5.dp))
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = "gabindx1@gmail.com",
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(7.dp))
            Text(
                text = "https://www.linkedin.com/in/gabin-durand-133949227/",
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(7.dp))
            Text(
                text = "https://github.com/DurandGab",
                fontSize = 12.sp
            )
        }
    }
    Spacer(modifier = Modifier.height(30.dp))
}