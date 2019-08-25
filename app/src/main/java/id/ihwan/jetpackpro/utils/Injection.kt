package id.ihwan.jetpackpro.utils

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import id.ihwan.jetpackpro.data.source.MovieRepository
import id.ihwan.jetpackpro.data.source.local.FavoriteDatabase
import id.ihwan.jetpackpro.data.source.local.LocalRepository
import java.util.concurrent.Executors

object Injection {

    private fun provideCache(context: Context): LocalRepository {
        val database = FavoriteDatabase.getDatabase(context)
        return LocalRepository(database.favoriteDao, Executors.newSingleThreadExecutor())
    }

    private fun provideTMDBRepository(context: Context): MovieRepository {
        return MovieRepository(provideCache(context))
    }

    fun provideViewModelFactory(context: Context): ViewModelProvider.Factory {
        return ViewModelFactory(provideTMDBRepository(context))
    }
}