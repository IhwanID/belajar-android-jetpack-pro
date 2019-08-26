package id.ihwan.jetpackpro.data.source.remote

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import id.ihwan.jetpackpro.data.source.remote.network.TMDBApiService
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData

class TvShowDataSourceFactory(private val service: TMDBApiService) :
    DataSource.Factory<Int, ResultsData>() {

    private val dataSourceLiveData = MutableLiveData<TvShowDataSource>()

    override fun create(): DataSource<Int, ResultsData> {
        val tvShowDataSource = TvShowDataSource(service)
        dataSourceLiveData.postValue(tvShowDataSource)
        return tvShowDataSource
    }

}