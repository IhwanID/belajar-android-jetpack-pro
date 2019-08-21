package id.ihwan.jetpackpro.home

import androidx.lifecycle.*
import androidx.paging.PagedList
import id.ihwan.jetpackpro.data.source.MovieRepository
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData
import id.ihwan.jetpackpro.utils.Status
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: MovieRepository) : ViewModel() {

    val repos: LiveData<PagedList<ResultsData>> = repository.getDataMovies().data
    val networkErrors: LiveData<String> = repository.getDataMovies().networkErrors

    val dataTvShow: LiveData<PagedList<ResultsData>> = repository.getDataTvShow().data
    val networkErrorsTvShow: LiveData<String> = repository.getDataTvShow().networkErrors

    //----new code-----//

    private val _movie =  MutableLiveData<List<ResultsData>>()

    val movies: LiveData<List<ResultsData>>
        get() = _movie

    private val _tvShow = MutableLiveData<List<ResultsData>>()

    val tvShow: LiveData<List<ResultsData>>
        get() = _tvShow

    private val _status = MutableLiveData<Status>()

    val status : LiveData<Status>
        get() = _status

    init {
       // getData()
    }

//    private fun getData(){
//        EspressoIdlingResource.increment()
//        viewModelScope.launch {
//                _status.value = Status.LOADING
//                _movie.value = repository.getMovie()
//                _tvShow.value = repository.getTvShow()
//                _status.value = Status.DONE
//            EspressoIdlingResource.decrement()
//        }
//    }

    fun insert(data: List<ResultsData>){
        viewModelScope.launch {
            //favoriteDao.insert(data)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }


}