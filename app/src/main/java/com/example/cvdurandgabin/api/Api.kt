package com.example.cvdurandgabin.api

import com.example.cvdurandgabin.models.TmdbMovie
import com.example.cvdurandgabin.models.TmdbMovieResult
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("trending/movie/week")
    suspend fun lastmovies(@Query("api_key") api_key: String): TmdbMovieResult
}

