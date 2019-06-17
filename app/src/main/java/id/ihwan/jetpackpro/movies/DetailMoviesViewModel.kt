package id.ihwan.jetpackpro.movies

import androidx.lifecycle.ViewModel
import id.ihwan.jetpackpro.utils.DataDummy

class DetailMoviesViewModel: ViewModel(){

    fun detailMovies(id: Int) : Movies? = DataDummy.getMoviesById(id)

}