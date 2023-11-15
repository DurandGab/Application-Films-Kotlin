package com.example.cvdurandgabin.pages.film

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.cvdurandgabin.models.MainViewModel
import com.example.cvdurandgabin.models.TmdbMovie
import com.example.cvdurandgabin.pages.film.components.CardFilm
import com.example.cvdurandgabin.pages.mainpage.component.Image
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun film(viewModel: MainViewModel) {
    Log.d("XXXX", "Film")
    val movies by viewModel.movies.collectAsStateWithLifecycle()
    LaunchedEffect(key1 = true){
        viewModel.getMoviesWeek()
    }
    LazyColumn() {
        items(movies.size) {
            CardFilm(movies[it])
        }
    }
}