package com.example.cvdurandgabin.pages.film.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import coil.compose.AsyncImage
import com.example.cvdurandgabin.models.TmdbMovie

@Composable
fun CardFilm(movie: TmdbMovie){
    AsyncImage(model = "https://image.tmdb.org/t/p/w500/${movie.poster_path}",
                contentDescription = "Affiche Film")
    Text(
        movie.title
    )
}