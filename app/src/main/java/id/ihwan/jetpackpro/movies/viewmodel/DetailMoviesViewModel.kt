package id.ihwan.jetpackpro.movies.viewmodel

import androidx.lifecycle.ViewModel
import id.ihwan.jetpackpro.movies.model.Movies

class DetailMoviesViewModel: ViewModel(){

    fun detailMovies(id: Int) : Movies? = DataDummy.getMoviesById(id)

}