package com.example.cvdurandgabin.pages.acteur.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import coil.compose.AsyncImage
import com.example.cvdurandgabin.models.TmdbActor
import com.example.cvdurandgabin.models.TmdbMovie

@Composable
fun CardActor(actor: TmdbActor){
    AsyncImage(model = "https://image.tmdb.org/t/p/w500/${actor.profile_path}",
        contentDescription = "Affiche Acteur")
    Text(
        actor.name
    )
}