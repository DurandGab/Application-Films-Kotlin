package com.example.cvdurandgabin.api

import com.example.cvdurandgabin.models.TmdbActorResult
import com.example.cvdurandgabin.models.TmdbMovie
import com.example.cvdurandgabin.models.TmdbMovieResult
import com.example.cvdurandgabin.models.TmdbSerieResult
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("trending/movie/week")
    suspend fun lastmovies(@Query("api_key") api_key: String): TmdbMovieResult
    @GET("trending/tv/week")
    suspend fun lastseries(@Query("api_key") api_key: String): TmdbSerieResult

    @GET("person/popular")
    suspend fun acteurs(@Query("api_key") api_key: String): TmdbActorResult
}

