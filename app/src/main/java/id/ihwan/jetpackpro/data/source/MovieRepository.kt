package id.ihwan.jetpackpro.data.source

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.PagedList
import id.ihwan.jetpackpro.data.source.local.LocalRepository
import id.ihwan.jetpackpro.data.source.remote.RemoteRepository
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData

class MovieRepository(
    private val localRepository: LocalRepository,
    private val remoteRepository: RemoteRepository
) : TMDBDataSource {

    override fun getAllMovies(): LiveData<PagedList<ResultsData>> {
        return remoteRepository.getAllMovieFromApi()
    }

    override fun getAllTvShow(): LiveData<PagedList<ResultsData>> {
        return remoteRepository.getAllTvShowFromApi()
    }

    override fun getFavoriteMovies(): DataSource.Factory<Int, ResultsData> {
        return localRepository.getMoviesFavorite()
    }

    override fun getFavoriteTvShow(): DataSource.Factory<Int, ResultsData> {
        return localRepository.getTvShowFavorite()
    }

    override fun unFavorite(data: ResultsData) {
        localRepository.deleteFromFavorite(data)
    }

    override fun addToFavorite(data: ResultsData) {
        localRepository.addToFavorite(data)
    }

}
