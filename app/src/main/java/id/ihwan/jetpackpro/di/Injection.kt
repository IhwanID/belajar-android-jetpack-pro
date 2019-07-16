package id.ihwan.jetpackpro.di

import android.app.Application
import id.ihwan.jetpackpro.data.source.MovieRepository
import id.ihwan.jetpackpro.data.source.local.LocalRepository
import id.ihwan.jetpackpro.data.source.remote.RemoteRepository

object Injection {
    fun provideRepository(application: Application): MovieRepository {

        val localRepository = LocalRepository()
        val remoteRepository = RemoteRepository()

        return MovieRepository()
    }
}