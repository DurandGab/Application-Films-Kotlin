package com.example.cvdurandgabin.pages.acteur.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cvdurandgabin.models.TmdbActor
import com.example.cvdurandgabin.models.TmdbMovie

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CardActor(actor: TmdbActor, onClick : (id: Int)-> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    MaterialTheme.colorScheme.background,
                    shape = RoundedCornerShape(12.dp)
                )
                .shadow(4.dp),
            elevation = 0.dp,
            onClick = {onClick(actor.id)}
        ) {
        Column (horizontalAlignment = Alignment.CenterHorizontally){
            AsyncImage(
                model = "https://image.tmdb.org/t/p/w500/${actor.profile_path}",
                contentDescription = "Affiche Acteur",
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Text(
                actor.name,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(5.dp),
                textAlign = TextAlign.Center,
            )
        }
    }
    }
}