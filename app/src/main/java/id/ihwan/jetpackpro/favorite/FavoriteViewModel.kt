package id.ihwan.jetpackpro.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import id.ihwan.jetpackpro.data.source.MovieRepository
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData

class FavoriteViewModel(private val repository: MovieRepository) : ViewModel() {

    //movies favorite
    val dataMV = repository.getFavoriteMovies()
    val data = LivePagedListBuilder(dataMV, 10).build()

    //tvShow Favorite
    val dataTS = repository.getFavoriteTvShow()
    val tvShowLiveData = LivePagedListBuilder(dataTS, 10).build()

    val favMovies: LiveData<PagedList<ResultsData>> get() = data
    val favTvShow: LiveData<PagedList<ResultsData>> get() = tvShowLiveData



}