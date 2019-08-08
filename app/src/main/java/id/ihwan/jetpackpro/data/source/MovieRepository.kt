package id.ihwan.jetpackpro.data.source

import androidx.lifecycle.MutableLiveData
import id.ihwan.jetpackpro.data.source.remote.network.ClientService
import id.ihwan.jetpackpro.data.source.remote.network.response.ResponseDetailMovie
import id.ihwan.jetpackpro.data.source.remote.network.response.ResponseTvShowDetail
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsMovie
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsTvShow
import id.ihwan.jetpackpro.utils.EspressoIdlingResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepository {
    private val clientService = ClientService()

    suspend fun getMovie() = clientService.getMovies()
    suspend fun getTvShow() = clientService.getTvShows()

    val movies = MutableLiveData<List<ResultsMovie>>()
    val tvShows = MutableLiveData<List<ResultsTvShow>>()
    val detailMovies = MutableLiveData<ResponseDetailMovie>()
    val detailTvShow = MutableLiveData<ResponseTvShowDetail>()
    /*
    suspend fun getMovie(){
        EspressoIdlingResource.increment()
        withContext(Dispatchers.IO) {
            val data = TMDBApi.retrofitService.getPopularMovies().await()
            movies.postValue(data.results)
            EspressoIdlingResource.decrement()
        }

    }

    suspend fun getTvShow(){
        EspressoIdlingResource.increment()
        withContext(Dispatchers.IO) {
            val data = TMDBApi.retrofitService.getPopularTvShow().await()
            tvShows.postValue(data.results)
            EspressoIdlingResource.decrement()
        }

    }*/

    suspend fun getDetailMovie(id: Int){
        EspressoIdlingResource.increment()
        withContext(Dispatchers.IO) {
            /*val data = .retrofitService.getDetailMovie(id).await()
            detailMovies.postValue(data)*/
            EspressoIdlingResource.decrement()
        }

    }

    suspend fun getDetailTvShow(id: Int){
        EspressoIdlingResource.increment()
        withContext(Dispatchers.IO) {
           /* val data = TMDBApi.retrofitService.getDetailTvShow(id).await()
            detailTvShow.postValue(data)*/
            EspressoIdlingResource.decrement()
        }

    }


}