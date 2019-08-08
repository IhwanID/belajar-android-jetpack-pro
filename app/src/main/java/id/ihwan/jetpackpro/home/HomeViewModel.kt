package id.ihwan.jetpackpro.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.ihwan.jetpackpro.data.source.MovieRepository
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsMovie
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsTvShow
import id.ihwan.jetpackpro.utils.EspressoIdlingResource
import id.ihwan.jetpackpro.utils.Status
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    val repository = MovieRepository()

    private val _movie =  MutableLiveData<List<ResultsMovie>>()

    val movies: LiveData<List<ResultsMovie>>
        get() = _movie

    private val _tvShow = MutableLiveData<List<ResultsTvShow>>()

    val tvShow: LiveData<List<ResultsTvShow>>
        get() = _tvShow

    private val _status = MutableLiveData<Status>()

    val status : LiveData<Status>
        get() = _status

    init {
        getData()
    }

    private fun getData(){
        EspressoIdlingResource.increment()
        viewModelScope.launch {
                _status.value = Status.LOADING
                _movie.value = repository.getMovie()
                _tvShow.value = repository.getTvShow()
                _status.value = Status.DONE
            EspressoIdlingResource.decrement()
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }


}