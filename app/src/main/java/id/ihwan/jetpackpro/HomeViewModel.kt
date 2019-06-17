package id.ihwan.jetpackpro

import androidx.lifecycle.ViewModel
import id.ihwan.jetpackpro.movies.Movies
import id.ihwan.jetpackpro.tvshow.TvShow
import id.ihwan.jetpackpro.utils.DataDummy

class HomeViewModel : ViewModel() {

    val movies : List<Movies> = DataDummy.generateDummyMovies()
    val tvShow : List<TvShow> = DataDummy.generateDummyTvShow()

}