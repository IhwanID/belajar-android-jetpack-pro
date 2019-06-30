package id.ihwan.jetpackpro.home

import androidx.lifecycle.ViewModel
import id.ihwan.jetpackpro.movies.model.Movies
import id.ihwan.jetpackpro.tvshow.model.TvShow
import id.ihwan.jetpackpro.utils.DataDummy

class HomeViewModel : ViewModel() {

    val movies : List<Movies> = DataDummy.generateDummyMovies()
    val tvShow : List<TvShow> = DataDummy.generateDummyTvShow()

}