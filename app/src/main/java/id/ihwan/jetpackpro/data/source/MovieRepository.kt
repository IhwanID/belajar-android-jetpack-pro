package id.ihwan.jetpackpro.data.source

import androidx.paging.LivePagedListBuilder
import id.ihwan.jetpackpro.data.MovieBoundaryCallback
import id.ihwan.jetpackpro.data.TvShowBoundaryCallback
import id.ihwan.jetpackpro.data.source.local.TMDBLocalCache
import id.ihwan.jetpackpro.data.source.remote.network.TMDBApiService
import id.ihwan.jetpackpro.data.source.remote.network.response.ResponseData
import id.ihwan.jetpackpro.data.source.remote.network.response.ResponseDataResult
import id.ihwan.jetpackpro.data.source.remote.network.response.ResponseDataResultLocal
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData


class MovieRepository(
    private val service: TMDBApiService,
    private val cache: TMDBLocalCache
) {
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

    fun getMoviesFromFavorite(): ResponseDataResultLocal{
        val dataSource = cache.getMoviesFavorite()

        val data = LivePagedListBuilder(dataSource, DATABASE_PAGE_SIZE)
            .build()

        return ResponseDataResultLocal(data = data)
    }

    fun addToFavorite(id: Int){
        cache.addToFavorite(id)
    }

    companion object {
        private const val DATABASE_PAGE_SIZE = 10
    }
}