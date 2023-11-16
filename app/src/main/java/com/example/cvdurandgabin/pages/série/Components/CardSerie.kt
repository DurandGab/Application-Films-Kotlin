package com.example.cvdurandgabin.pages.série.Components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import coil.compose.AsyncImage
import com.example.cvdurandgabin.models.TmdbMovie
import com.example.cvdurandgabin.models.TmdbSerie

@Composable
fun CardSerie(serie: TmdbSerie){
    AsyncImage(model = "https://image.tmdb.org/t/p/w500/${serie.poster_path}",
        contentDescription = "Affiche Film")
    Text(
        serie.name
    )
}