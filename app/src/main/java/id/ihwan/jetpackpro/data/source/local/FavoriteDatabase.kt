package id.ihwan.jetpackpro.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData

@Database(entities = [ResultsData::class], version = 1)
abstract class FavoriteDatabase: RoomDatabase() {
    abstract val favoriteDao: FavoriteDao
}

private lateinit var INSTANCE: FavoriteDatabase

fun getDatabase(context: Context): FavoriteDatabase {
    synchronized(FavoriteDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,
                FavoriteDatabase::class.java,
                "favorite.db").build()
        }
    }
    return INSTANCE
}
