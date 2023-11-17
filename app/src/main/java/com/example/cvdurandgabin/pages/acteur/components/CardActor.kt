package com.example.cvdurandgabin.pages.acteur.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cvdurandgabin.models.TmdbActor
import com.example.cvdurandgabin.models.TmdbMovie

@Composable
fun CardActor(actor: TmdbActor) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .shadow(4.dp)
            .padding(12.dp)
    ) {
        Column {


        AsyncImage(
            model = "https://image.tmdb.org/t/p/w500/${actor.profile_path}",
            contentDescription = "Affiche Acteur",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Text(
            actor.name
        )
    }
    }
}