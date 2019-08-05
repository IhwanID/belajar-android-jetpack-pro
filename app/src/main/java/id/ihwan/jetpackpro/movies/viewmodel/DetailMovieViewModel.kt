package id.ihwan.jetpackpro.movies.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import id.ihwan.jetpackpro.data.source.MovieRepository
import id.ihwan.jetpackpro.network.response.ResponseDetailMovie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class DetailMovieViewModel: ViewModel(){

    private val viewModelJob = SupervisorJob()

    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    val repository = MovieRepository()

    private val _detailmovie : LiveData<ResponseDetailMovie> = repository.detailMovies

    val detailMovie: LiveData<ResponseDetailMovie>
        get() = _detailmovie

    fun getDetail(id: Int){
        viewModelScope.launch {
            repository.getDetailShow(id)
        }
    }


}