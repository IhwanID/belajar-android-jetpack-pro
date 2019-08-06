package id.ihwan.jetpackpro.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ihwan.jetpackpro.data.source.MovieRepository
import id.ihwan.jetpackpro.network.response.ResultsMovie
import id.ihwan.jetpackpro.network.response.ResultsTvShow
import id.ihwan.jetpackpro.utils.EspressoIdlingResource
import id.ihwan.jetpackpro.utils.Status
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val viewModelJob = SupervisorJob()

    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getData()
    }

    val repository = MovieRepository()

    private val _movie :  LiveData<List<ResultsMovie>> = repository.movies

    val movies: LiveData<List<ResultsMovie>>
        get() = _movie

    private val _tvShow : LiveData<List<ResultsTvShow>> = repository.tvShows

    val tvShow: LiveData<List<ResultsTvShow>>
        get() = _tvShow

    private val _status = MutableLiveData<Status>()

    val status : LiveData<Status>
        get() = _status

    private fun getData(){
        EspressoIdlingResource.increment()
        viewModelScope.launch {
            try {
                _status.value = Status.LOADING
                repository.getMovie()
                repository.getTvShow()
                _status.value = Status.DONE
                EspressoIdlingResource.decrement()
            } catch (e: Throwable) {
                EspressoIdlingResource.decrement()
               _status.value = Status.ERROR
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}