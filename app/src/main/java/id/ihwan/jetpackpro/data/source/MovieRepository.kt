package id.ihwan.jetpackpro.data.source

import androidx.paging.LivePagedListBuilder
import id.ihwan.jetpackpro.data.MovieBoundaryCallback
import id.ihwan.jetpackpro.data.TvShowBoundaryCallback
import id.ihwan.jetpackpro.data.source.local.TMDBLocalCache
import id.ihwan.jetpackpro.data.source.remote.network.ClientService
import id.ihwan.jetpackpro.data.source.remote.network.TMDBApiService
import id.ihwan.jetpackpro.data.source.remote.network.response.ResponseDataResult


class MovieRepository(
    private val service: TMDBApiService,
    private val cache: TMDBLocalCache
) {
    private val clientService = ClientService()



    fun getDataMovies(): ResponseDataResult {

        val dataSourceFactory = cache.getAllMoviesData()

        val boundaryCallback = MovieBoundaryCallback(service, cache)
        val networkErrors = boundaryCallback.networkErrors

        val data = LivePagedListBuilder(dataSourceFactory, DATABASE_PAGE_SIZE)
            .setBoundaryCallback(boundaryCallback)
            .build()

        return ResponseDataResult(data, networkErrors)
    }

    fun getDataTvShow(): ResponseDataResult {

        val dataSourceFactory = cache.getAllTvShowData()

        val boundaryCallback = TvShowBoundaryCallback(service, cache)
        val networkErrors = boundaryCallback.networkErrors

        val data = LivePagedListBuilder(dataSourceFactory, DATABASE_PAGE_SIZE)
            .setBoundaryCallback(boundaryCallback)
            .build()

        return ResponseDataResult(data, networkErrors)
    }

    companion object {
        private const val DATABASE_PAGE_SIZE = 10
    }
}