package com.example.cvdurandgabin.api


import com.example.cvdurandgabin.models.Credits
import com.example.cvdurandgabin.models.CreditsSerie
import com.example.cvdurandgabin.models.TmdbActorDetail
import com.example.cvdurandgabin.models.TmdbActorResult
import com.example.cvdurandgabin.models.TmdbMovieDetail
import com.example.cvdurandgabin.models.TmdbMovieResult
import com.example.cvdurandgabin.models.TmdbSerieDetail

import com.example.cvdurandgabin.models.TmdbSerieResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("trending/movie/week")
    suspend fun lastmovies(@Query("api_key") api_key: String): TmdbMovieResult

    @GET("movie/{movie_id}&append_to_response=credits")
    suspend fun detailmovie(
        @Path("movie_id") movieId: Int,
        @Query("api_key") api_key: String): TmdbMovieDetail

    @GET("movie/{movie_id}/credits")
    suspend fun creditsmovie(
        @Path("movie_id") movieId: Int,
        @Query("api_key") api_key: String): Credits

    @GET("trending/tv/week")
    suspend fun lastseries(@Query("api_key") api_key: String): TmdbSerieResult
    @GET("tv/{series_id}&append_to_response=credits")
    suspend fun detailserie(
        @Path("series_id") serieId: Int,
        @Query("api_key") api_key: String): TmdbSerieDetail

    @GET("tv/{series_id}/credits")
    suspend fun creditstv(
        @Path("series_id") serieId: Int,
        @Query("api_key") api_key: String): CreditsSerie


    @GET("person/popular")
    suspend fun acteurs(@Query("api_key") api_key: String): TmdbActorResult

   @GET("person/{person_id}&append_to_response=credits")
    suspend fun detailactor(
        @Path("person_id") actorId: Int,
        @Query("api_key") api_key: String): TmdbActorDetail
    @GET("search/movie")
    suspend fun searchMovies(
        @Query("api_key") apiKey: String,
        @Query("query") query: String
    ): TmdbMovieResult
    @GET("search/tv")
    suspend fun searchSerie(
        @Query("api_key") apiKey: String,
        @Query("query") query: String
    ): TmdbSerieResult

    @GET("search/person")
    suspend fun searchActor(
        @Query("api_key") apiKey: String,
        @Query("query") query: String
    ): TmdbActorResult
}

