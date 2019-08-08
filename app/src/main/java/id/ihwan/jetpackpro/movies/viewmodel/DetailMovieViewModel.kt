package id.ihwan.jetpackpro.movies.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.ihwan.jetpackpro.data.source.MovieRepository
import id.ihwan.jetpackpro.data.source.remote.network.response.ResponseDetailMovie
import kotlinx.coroutines.launch

class DetailMovieViewModel: ViewModel(){



    val repository = MovieRepository()

    private var _detailMovie = MutableLiveData<ResponseDetailMovie>()

    val detailMovie: LiveData<ResponseDetailMovie>
        get() = _detailMovie

    fun getDetail(id: Int){
        viewModelScope.launch {
            _detailMovie.value = repository.getDetailMovie(id)
        }
    }


}