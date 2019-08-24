package id.ihwan.jetpackpro.utils

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import id.ihwan.jetpackpro.data.source.MovieRepository
import id.ihwan.jetpackpro.data.source.local.FavoriteDatabase
import id.ihwan.jetpackpro.data.source.local.LocalDataSource
import id.ihwan.jetpackpro.data.source.remote.network.TMDBApiService
import java.util.concurrent.Executors

object Injection {

    private fun provideCache(context: Context): LocalDataSource {
        val database = FavoriteDatabase.getDatabase(context)
        return LocalDataSource(database.favoriteDao, Executors.newSingleThreadExecutor())
    }

    private fun provideTMDBRepository(context: Context): MovieRepository {
        return MovieRepository(TMDBApiService.create(), provideCache(context))
    }

    fun provideViewModelFactory(context: Context): ViewModelProvider.Factory {
        return ViewModelFactory(provideTMDBRepository(context))
    }
}