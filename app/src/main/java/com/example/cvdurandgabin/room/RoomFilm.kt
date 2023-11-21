package com.example.cvdurandgabin.room

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.ProvidedTypeConverter
import androidx.room.Query
import androidx.room.TypeConverter
import com.example.cvdurandgabin.models.TmdbActor
import com.example.cvdurandgabin.models.TmdbMovie
import com.example.cvdurandgabin.models.TmdbSerie
import com.squareup.moshi.Moshi

@Entity
data class FilmEntity(val fiche: TmdbMovie, @PrimaryKey val id: Int)
/*data class SerieEntity(val fiche: TmdbSerie, @PrimaryKey val id: Int)
data class ActorEntity(val fiche: TmdbActor, @PrimaryKey val id: Int)*/

@ProvidedTypeConverter
class Converters(moshi: Moshi) {
    val filmJsonadapter = moshi.adapter(TmdbMovie::class.java)

    @TypeConverter
    fun StringToTmdbMovie(value: String): TmdbMovie? {
        return filmJsonadapter.fromJson(value)
    }

    @TypeConverter
    fun TmdbMovieToString(film: TmdbMovie): String {
        return filmJsonadapter.toJson(film)
    }
}

@Dao
interface FilmDao {
    @Query("SELECT * FROM filmentity")
    suspend fun getFavFilms(): List<FilmEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFilm(film: FilmEntity)

    @Query("DELETE FROM filmentity WHERE id = :id")
    suspend fun deleteFilm(id: String)
}


