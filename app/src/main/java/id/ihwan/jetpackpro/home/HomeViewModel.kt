package id.ihwan.jetpackpro.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import id.ihwan.jetpackpro.data.source.MovieRepository
import id.ihwan.jetpackpro.network.response.ResultsMovie
import id.ihwan.jetpackpro.network.response.ResultsTvShow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val viewModelJob = SupervisorJob()

    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        viewModelScope.launch {
            repository.getMovie()
            repository.getTvShow()
        }
    }



    val repository = MovieRepository()

    private val _movie :  LiveData<List<ResultsMovie>> = repository.movies

    val movies: LiveData<List<ResultsMovie>>
        get() = _movie

    private val _tvShow : LiveData<List<ResultsTvShow>> = repository.tvShows

    val tvShow: LiveData<List<ResultsTvShow>>
        get() = _tvShow

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}