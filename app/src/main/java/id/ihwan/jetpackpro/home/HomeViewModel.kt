package id.ihwan.jetpackpro.home

import androidx.lifecycle.*
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import id.ihwan.jetpackpro.data.source.MovieRepository
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData

class HomeViewModel(repository: MovieRepository) : ViewModel() {

    val movieList = repository.getAllMovies()
    val tvShowList = repository.getAllTvShow()

}