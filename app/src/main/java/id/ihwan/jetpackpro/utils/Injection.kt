package id.ihwan.jetpackpro.utils

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import id.ihwan.jetpackpro.data.source.MovieRepository
import id.ihwan.jetpackpro.data.source.local.FavoriteDatabase
import id.ihwan.jetpackpro.data.source.local.LocalRepository
import id.ihwan.jetpackpro.data.source.remote.RemoteRepository
import id.ihwan.jetpackpro.data.source.remote.network.TMDBApiService
import java.util.concurrent.Executors

object Injection {

    private fun provideCache(context: Context): LocalRepository {
        val database = FavoriteDatabase.getDatabase(context)
        return LocalRepository(database.favoriteDao, Executors.newSingleThreadExecutor())
    }

    private fun provideRemote(): RemoteRepository{
        return RemoteRepository(TMDBApiService.create())
    }

    private fun provideTMDBRepository(context: Context): MovieRepository {
        return MovieRepository(provideCache(context), provideRemote())
    }

    fun provideViewModelFactory(context: Context): ViewModelProvider.Factory {
        return ViewModelFactory(provideTMDBRepository(context))
    }
}