package id.ihwan.jetpackpro.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import id.ihwan.jetpackpro.data.source.MovieRepository
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData

class FavoriteViewModel(private val repository: MovieRepository) : ViewModel() {

    val favMovies: LiveData<PagedList<ResultsData>> = repository.getMoviesFromFavorite().data
    val favTvShow: LiveData<PagedList<ResultsData>> = repository.getTvShowFromFavorite().data
}