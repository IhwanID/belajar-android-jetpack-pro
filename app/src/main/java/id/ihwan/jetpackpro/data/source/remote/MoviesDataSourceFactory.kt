package id.ihwan.jetpackpro.data.source.remote

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import id.ihwan.jetpackpro.data.source.remote.network.TMDBApiService
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData

class MoviesDataSourceFactory(private val service: TMDBApiService) :
    DataSource.Factory<Int, ResultsData>() {

    private val dataSourceLiveData = MutableLiveData<MovieDataSource>()

    override fun create(): DataSource<Int, ResultsData> {
        val movieDataSource = MovieDataSource(service)
        dataSourceLiveData.postValue(movieDataSource)
        return movieDataSource
    }

}