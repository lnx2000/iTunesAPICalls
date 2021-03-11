package com.app.itunes.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.app.itunes.data.entities.Song

@Database(
    entities = [Song::class],
    version = 1
)
abstract class SongDatabase : RoomDatabase() {


    abstract fun getSongDao(): SongDao

    companion object {
        @Volatile
        private var instance: SongDatabase? = null
        private val lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(lock) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            SongDatabase::class.java,
            "Songs"
        ).allowMainThreadQueries().build()
    }
}