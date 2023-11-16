package com.example.cvdurandgabin.pages.film

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.cvdurandgabin.models.MainViewModel
import com.example.cvdurandgabin.models.TmdbMovie
import com.example.cvdurandgabin.pages.film.components.CardFilm
import com.example.cvdurandgabin.pages.mainpage.component.Image
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun film(viewModel: MainViewModel) {
    val movies by viewModel.movies.collectAsStateWithLifecycle()
    LaunchedEffect(key1 = true) {
        viewModel.getMoviesWeek()
    }
    Box(modifier = Modifier.padding(20.dp).fillMaxSize()) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(movies.size) {
                CardFilm(movies[it])
            }
        }
    }
}