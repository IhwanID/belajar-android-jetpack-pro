package id.ihwan.jetpackpro.home

import androidx.lifecycle.*
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import id.ihwan.jetpackpro.data.source.MovieRepository
import id.ihwan.jetpackpro.data.source.remote.MoviesDataSourceFactory
import id.ihwan.jetpackpro.data.source.remote.TvShowDataSourceFactory
import id.ihwan.jetpackpro.data.source.remote.network.TMDBApiService
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData

class HomeViewModel(repository: MovieRepository) : ViewModel() {

    private val service = TMDBApiService.create()

    var movieList : LiveData<PagedList<ResultsData>>
    var tvShowList : LiveData<PagedList<ResultsData>>

    private val pageSize = 5
    private val moviesDataSourceFactory: MoviesDataSourceFactory
    private val tvShowDataSourceFactory: TvShowDataSourceFactory

    init {
        moviesDataSourceFactory = MoviesDataSourceFactory(service)
        tvShowDataSourceFactory = TvShowDataSourceFactory(service)

        val config = PagedList.Config.Builder()
            .setPageSize(pageSize)
            .setInitialLoadSizeHint(pageSize * 2)
            .setEnablePlaceholders(false)
            .build()

        movieList = LivePagedListBuilder(moviesDataSourceFactory, config).build()
        tvShowList = LivePagedListBuilder(tvShowDataSourceFactory, config).build()
    }


}