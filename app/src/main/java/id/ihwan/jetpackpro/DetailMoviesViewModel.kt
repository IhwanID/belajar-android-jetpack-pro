package id.ihwan.jetpackpro

import androidx.lifecycle.ViewModel
import id.ihwan.jetpackpro.movies.Movies
import id.ihwan.jetpackpro.utils.DataDummy

class DetailMoviesViewModel: ViewModel(){

    fun detailMovies(id: Int) : Movies? = DataDummy.getMoviesById(id)

}