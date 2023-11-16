package com.example.cvdurandgabin.pages.acteur

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.cvdurandgabin.models.MainViewModel
import com.example.cvdurandgabin.pages.acteur.components.CardActor
import com.example.cvdurandgabin.pages.film.components.CardFilm

@Composable
fun acteur(viewModel: MainViewModel) {
    val actors by viewModel.actors.collectAsStateWithLifecycle()
    LaunchedEffect(key1 = true){
        viewModel.getActors()
    }
    LazyColumn() {
        items(actors.size) {
            CardActor(actors[it])
        }
    }
}