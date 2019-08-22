package id.ihwan.jetpackpro.home

import androidx.lifecycle.*
import androidx.paging.PagedList
import id.ihwan.jetpackpro.data.source.MovieRepository
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData

class HomeViewModel(repository: MovieRepository) : ViewModel() {

    val dataMovies: LiveData<PagedList<ResultsData>> = repository.getDataMovies().data
    val networkErrors: LiveData<String> = repository.getDataMovies().networkErrors

    val dataTvShow: LiveData<PagedList<ResultsData>> = repository.getDataTvShow().data
    val networkErrorsTvShow: LiveData<String> = repository.getDataTvShow().networkErrors

}