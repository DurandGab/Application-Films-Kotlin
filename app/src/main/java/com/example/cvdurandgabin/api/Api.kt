package com.example.cvdurandgabin.api

import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("trending/movie/week")
    suspend fun lastmovies(@Query("d7a0c27757e49ea16fd7d78f18e896a5") api_key: String): TmdbMovieResult
}deeeeee