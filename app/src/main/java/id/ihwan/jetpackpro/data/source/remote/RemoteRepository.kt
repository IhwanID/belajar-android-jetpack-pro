package id.ihwan.jetpackpro.data.source.remote

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import id.ihwan.jetpackpro.data.source.remote.network.TMDBApiService
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData

class RemoteRepository(private val service: TMDBApiService) {
    private val moviesDataSourceFactory = MoviesDataSourceFactory(service)
    private val tvShowDataSourceFactory = TvShowDataSourceFactory(service)

    private val config = PagedList.Config.Builder()
        .setPageSize(5)
        .setInitialLoadSizeHint(10)
        .setEnablePlaceholders(false)
        .build()

    fun getAllMovieFromApi(): LiveData<PagedList<ResultsData>>{
        return LivePagedListBuilder(moviesDataSourceFactory, config).build()
    }

    fun getAllTvShowFromApi(): LiveData<PagedList<ResultsData>>{
        return LivePagedListBuilder(tvShowDataSourceFactory, config).build()
    }

}