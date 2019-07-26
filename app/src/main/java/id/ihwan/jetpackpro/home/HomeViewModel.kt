package id.ihwan.jetpackpro.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import id.ihwan.jetpackpro.data.source.MovieRepository
import id.ihwan.jetpackpro.network.response.ResultsMovie
import id.ihwan.jetpackpro.network.response.ResultsTvShow

class HomeViewModel : ViewModel() {

    val repo = MovieRepository()

    private val _movie :  LiveData<List<ResultsMovie>> = repo.getMovie()

    val movies: LiveData<List<ResultsMovie>>
        get() = _movie

    private val _tvShow : LiveData<List<ResultsTvShow>> = repo.getTvShow()

    val tvShow: LiveData<List<ResultsTvShow>>
        get() = _tvShow


}