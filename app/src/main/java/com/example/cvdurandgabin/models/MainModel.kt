package com.example.cvdurandgabin.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cvdurandgabin.api.Api
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainViewModel : ViewModel() {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build();

    val api = retrofit.create(Api::class.java)

    // à partir de là, on peut appeler api.lastMovies(...)
    val movies = MutableStateFlow<List<TmdbMovie>>(listOf())
    val series = MutableStateFlow<List<TmdbSerie>>(listOf())
    val actors = MutableStateFlow<List<TmdbActor>>(listOf())
    val detailMovie = MutableStateFlow<TmdbMovieDetail>(TmdbMovieDetail())
    val detailSerie = MutableStateFlow<TmdbSerieDetail>(TmdbSerieDetail())
    val detailActor = MutableStateFlow<TmdbActorDetail>(TmdbActorDetail())

    fun getMoviesWeek() {
        viewModelScope.launch {
            movies.value = api.lastmovies("d7a0c27757e49ea16fd7d78f18e896a5").results
        }
    }

    fun getDetailMovie(id: Int) {
        viewModelScope.launch {
            detailMovie.value = api.detailmovie(id, "d7a0c27757e49ea16fd7d78f18e896a5")
        }
    }
    fun getSerieWeek() {
        viewModelScope.launch {
            series.value = api.lastseries("d7a0c27757e49ea16fd7d78f18e896a5").results
        }
    }
    fun getDetailSerie(id: Int) {
        viewModelScope.launch {
            detailSerie.value = api.detailserie(id, "d7a0c27757e49ea16fd7d78f18e896a5")
        }
    }
    fun getActors() {
        viewModelScope.launch {
            actors.value = api.acteurs("d7a0c27757e49ea16fd7d78f18e896a5").results
        }
    }
    fun getDetailActor(id: Int) {
        viewModelScope.launch {
            detailActor.value = api.detailactor(id, "d7a0c27757e49ea16fd7d78f18e896a5")
        }
    }
}