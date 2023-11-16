package com.example.cvdurandgabin.pages.acteur

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.cvdurandgabin.models.MainViewModel
import com.example.cvdurandgabin.pages.acteur.components.CardActor
import com.example.cvdurandgabin.pages.film.components.CardFilm

@Composable
fun acteur(viewModel: MainViewModel) {
    val actors by viewModel.actors.collectAsStateWithLifecycle()
    LaunchedEffect(key1 = true) {
        viewModel.getActors()
    }
    Box(modifier = Modifier.padding(20.dp).fillMaxSize()) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(actors.size) {
                CardActor(actors[it])
            }
        }
    }
}