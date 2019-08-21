package id.ihwan.jetpackpro.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import id.ihwan.jetpackpro.data.source.local.TMDBLocalCache
import id.ihwan.jetpackpro.data.source.remote.network.TMDBApiService
import id.ihwan.jetpackpro.data.source.remote.network.getDataTvShowFromApi
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData

class TvShowBoundaryCallback(
    private val service: TMDBApiService,
    private val cache: TMDBLocalCache
) : PagedList.BoundaryCallback<ResultsData>() {

    private var lastRequestedPage = 1

    private val _networkErrors = MutableLiveData<String>()
    // LiveData of network errors.
    val networkErrors: LiveData<String>
        get() = _networkErrors

    // avoid triggering multiple requests in the same time
    private var isRequestInProgress = false

    override fun onZeroItemsLoaded() {
        requestAndSaveData()
    }

    override fun onItemAtEndLoaded(itemAtEnd: ResultsData) {
        requestAndSaveData()
    }

    private fun requestAndSaveData() {
        if (isRequestInProgress) return

        isRequestInProgress = true
        getDataTvShowFromApi(service, lastRequestedPage, { data ->
            cache.insert(data) {
                lastRequestedPage++
                isRequestInProgress = false
            }
        }, { error ->
            _networkErrors.postValue(error)
            isRequestInProgress = false
        })
    }

}