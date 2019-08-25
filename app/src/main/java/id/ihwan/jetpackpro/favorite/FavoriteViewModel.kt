package id.ihwan.jetpackpro.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import id.ihwan.jetpackpro.data.source.MovieRepository
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData

class FavoriteViewModel(private val repository: MovieRepository) : ViewModel() {

    //movies favorite
    val dataMovies = repository.getFavoriteMovies()
    val liveDataMovies = LivePagedListBuilder(dataMovies, 10).build()

    //tvShow Favorite
    val dataTvShow = repository.getFavoriteTvShow()
    val tvShowLiveData = LivePagedListBuilder(dataTvShow, 10).build()

    val favMovies: LiveData<PagedList<ResultsData>> get() = liveDataMovies
    val favTvShow: LiveData<PagedList<ResultsData>> get() = tvShowLiveData

}