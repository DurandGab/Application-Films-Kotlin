package com.example.cvdurandgabin.room

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.ProvidedTypeConverter
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import com.example.cvdurandgabin.models.TmdbActor
import com.example.cvdurandgabin.models.TmdbMovie
import com.example.cvdurandgabin.models.TmdbSerie
import com.squareup.moshi.Moshi

@Entity
data class SerieEntity(val fiche: TmdbSerie, @PrimaryKey val id: Int)

@ProvidedTypeConverter
class ConvertersSerie(moshi: Moshi) {
    val serieJsonadapter = moshi.adapter(TmdbSerie::class.java)

    @TypeConverter
    fun StringToTmdbSerie(value: String): TmdbSerie? {
        return serieJsonadapter.fromJson(value)
    }

    @TypeConverter
    fun TmdbSerieToString(serie: TmdbSerie): String {
        return serieJsonadapter.toJson(serie)
    }
}

@Dao
interface SerieDao {
    @Query("SELECT * FROM serieentity")
    suspend fun getFavSerie(): List<SerieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSerie(serie: TmdbSerie)

    @Query("DELETE FROM serieentity WHERE id = :id")
    suspend fun deleteSerie(id: String)
}

@Database(entities = [SerieEntity::class], version = 4)
abstract class AppDatabaseSerie : RoomDatabase() {
    abstract fun serieDao(): SerieDao
}
