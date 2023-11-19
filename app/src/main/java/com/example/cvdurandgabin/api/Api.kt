package com.example.cvdurandgabin.api

import com.example.cvdurandgabin.models.TmdbActorResult
import com.example.cvdurandgabin.models.TmdbMovieResult
import com.example.cvdurandgabin.models.TmdbSerieResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("trending/movie/week")
    suspend fun lastmovies(@Query("api_key") api_key: String): TmdbMovieResult

    @GET("movie/{movie_id}")
    suspend fun detailmovie(
        @Path("movie_id") movieId: Int,
        @Query("api_key") api_key: String): TmdbMovieResult


    @GET("trending/tv/week")
    suspend fun lastseries(@Query("api_key") api_key: String): TmdbSerieResult
    @GET("tv/{series_id}")
    suspend fun detailserie(
        @Path("series_id") serieId: Int,
        @Query("api_key") api_key: String): TmdbSerieResult


    @GET("person/popular")
    suspend fun acteurs(@Query("api_key") api_key: String): TmdbActorResult

    @GET("person/{person_id}")
    suspend fun detailactor(
        @Path("person_id") actorId: Int,
        @Query("api_key") api_key: String): TmdbActorResult
}

