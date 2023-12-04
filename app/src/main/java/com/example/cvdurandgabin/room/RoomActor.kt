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
data class ActorEntity(val fiche: TmdbActor, @PrimaryKey val id: Int)

@ProvidedTypeConverter
class ConvertersActor(moshi: Moshi) {
    val actorJsonadapter = moshi.adapter(TmdbActor::class.java)

    @TypeConverter
    fun StringToTmdbActor(value: String): TmdbActor? {
        return actorJsonadapter.fromJson(value)
    }

    @TypeConverter
    fun TmdbActorToString(actor: TmdbActor): String {
        return actorJsonadapter.toJson(actor)
    }
}

@Dao
interface ActorDao {
    @Query("SELECT * FROM actorentity")
    suspend fun getFavActor(): List<ActorEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertActor(actor: TmdbActor)

    @Query("DELETE FROM actorentity WHERE id = :id")
    suspend fun deleteActor(id: String)
}

@Database(entities = [ActorEntity::class], version = 4)
abstract class AppDatabaseActor : RoomDatabase() {
    abstract fun actorDao(): ActorDao
}
