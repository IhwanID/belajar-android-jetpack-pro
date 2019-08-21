package id.ihwan.jetpackpro.data.source

import android.util.Log
import androidx.paging.LivePagedListBuilder
import id.ihwan.jetpackpro.data.MovieBoundaryCallback
import id.ihwan.jetpackpro.data.source.local.TMDBLocalCache
import id.ihwan.jetpackpro.data.source.remote.network.ClientService
import id.ihwan.jetpackpro.data.source.remote.network.TMDBApiService
import id.ihwan.jetpackpro.data.source.remote.network.response.ResponseDataResult


class MovieRepository(
    private val service: TMDBApiService,
    private val cache: TMDBLocalCache
) {
    private val clientService = ClientService()



    suspend fun getMovie() = clientService.getMovies()
    suspend fun getTvShow() = clientService.getTvShows()

    fun search(): ResponseDataResult {

        // Get data source factory from the local cache
        val dataSourceFactory = cache.getAllData()

        // every new query creates a new BoundaryCallback
        // The BoundaryCallback will observe when the user reaches to the edges of
        // the list and update the database with extra data
        val boundaryCallback = MovieBoundaryCallback(service, cache)
        val networkErrors = boundaryCallback.networkErrors

        // Get the paged list
        val data = LivePagedListBuilder(dataSourceFactory, DATABASE_PAGE_SIZE)
            .setBoundaryCallback(boundaryCallback)
            .build()

        // Get the network errors exposed by the boundary callback
        return ResponseDataResult(data, networkErrors)
    }

    companion object {
        private const val DATABASE_PAGE_SIZE = 20
    }
}