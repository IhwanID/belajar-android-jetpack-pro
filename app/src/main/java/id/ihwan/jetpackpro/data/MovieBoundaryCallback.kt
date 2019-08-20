package id.ihwan.jetpackpro.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import id.ihwan.jetpackpro.data.source.local.TMDBLocalCache
import id.ihwan.jetpackpro.data.source.remote.network.TMDBApiService
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData

class MovieBoundaryCallback(
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
        super.onZeroItemsLoaded()
    }

    override fun onItemAtEndLoaded(itemAtEnd: ResultsData) {
        super.onItemAtEndLoaded(itemAtEnd)
    }

    private fun requestAndSaveData() {

    }

    companion object{
        private const val NETWORK_PAGE_SIZE = 50
    }
}