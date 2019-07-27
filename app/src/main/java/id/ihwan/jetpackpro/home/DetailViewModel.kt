package id.ihwan.jetpackpro.home

import androidx.lifecycle.ViewModel
import id.ihwan.jetpackpro.data.source.MovieRepository

class DetailViewModel: ViewModel(){

    val repo = MovieRepository()

    /*private val _detailMovie : LiveData<ResponseDetailMovie> = repo.getMovieDetail(id)

    val detailMovie: LiveData<ResponseDetailMovie>
        get() = _detailMovie*/
}