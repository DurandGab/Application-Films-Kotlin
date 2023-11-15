package com.example.cvdurandgabin.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val movies = MutableStateFlow<List<TmdbMovie>>(listOf())

    fun getMovies() {
        viewModelScope.launch {
            movies.value = api.lastmovies("d7a0c27757e49ea16fd7d78f18e896a5")
        }
    }
}