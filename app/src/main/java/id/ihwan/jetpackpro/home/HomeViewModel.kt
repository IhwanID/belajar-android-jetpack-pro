package id.ihwan.jetpackpro.home

import androidx.lifecycle.*
import androidx.paging.PagedList
import id.ihwan.jetpackpro.data.source.MovieRepository
import id.ihwan.jetpackpro.data.source.remote.network.response.ResponseDataResult
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData

class HomeViewModel(repository: MovieRepository) : ViewModel() {

    private val queryLiveData = MutableLiveData<String>()

    private val movieResult: LiveData<ResponseDataResult> = Transformations.map(queryLiveData) {
        repository.getDataMovies()
    }

    val dataMovies: LiveData<PagedList<ResultsData>> = Transformations.switchMap(movieResult) { it.data }
    val networkErrors: LiveData<String> = Transformations.switchMap(movieResult) { it.networkErrors }

    val dataTvShow: LiveData<PagedList<ResultsData>> = repository.getDataTvShow().data
    val networkErrorsTvShow: LiveData<String> = repository.getDataTvShow().networkErrors

    init {
        getData()
    }
    fun getData(){
        queryLiveData.postValue("")
    }
}