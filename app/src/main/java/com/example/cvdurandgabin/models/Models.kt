package com.example.cvdurandgabin.models
class TmdbMovieResult(
    var page: Int = 0,
    val results: List<TmdbMovie> = listOf())

class TmdbMovie(
    var overview: String = "",
    val release_date: String = "",
    val id: String = "",
    val title: String = "",
    val original_title: String = "",
    val backdrop_path: String? = "",
    val genre_ids: List<Int> = listOf(),
    val poster_path: String? = "")

class TmdbSerieResult(
    var page: Int = 0,
    val results: List<TmdbSerie> = listOf())

class TmdbSerie(
    var overview: String = "",
    val release_date: String = "",
    val id: String = "",
    val name: String = "",
    val original_name: String = "",
    val backdrop_path: String? = "",
    val genre_ids: List<Int> = listOf(),
    val poster_path: String? = "")

class TmdbActorResult(
    var page: Int = 0,
    val results: List<TmdbActor> = listOf())

class TmdbActor(
    var overview: String = "",
    val release_date: String = "",
    val id: String = "",
    val name: String = "",
    val original_name: String = "",
    val backdrop_path: String? = "",
    val genre_ids: List<Int> = listOf(),
    val profile_path: String? = "")