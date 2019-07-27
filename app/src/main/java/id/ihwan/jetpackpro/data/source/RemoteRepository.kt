package id.ihwan.jetpackpro.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import id.ihwan.jetpackpro.network.TMDBApi
import id.ihwan.jetpackpro.network.response.ResponseDetailMovie
import id.ihwan.jetpackpro.network.response.ResultsMovie
import id.ihwan.jetpackpro.network.response.ResultsTvShow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class RemoteRepository {

    private var job = Job()

    private val coroutineScope = CoroutineScope(job + Dispatchers.Main)

    fun getMovieFromApi(): LiveData<List<ResultsMovie>> {

        val data = MutableLiveData<List<ResultsMovie>>()

        coroutineScope.launch {

            val getMoviesDeferred = TMDBApi.retrofitService.getPopularMovies()
            try {
                val listResult = getMoviesDeferred.await()
                data.postValue(listResult.results)
            } catch (e: Exception) {
                data.value = ArrayList()
            }
        }

        return data
    }

    fun getTvShowFromApi(): LiveData<List<ResultsTvShow>> {
        val data = MutableLiveData<List<ResultsTvShow>>()

        coroutineScope.launch {

            val getTvShowDeferred = TMDBApi.retrofitService.getPopularTvShow()
            try {

                val listResult = getTvShowDeferred.await()
                data.postValue(listResult.results)
            } catch (e: Exception) {
                data.value = ArrayList()
            }
        }
        return data
    }

    fun getDetailMovieFromApi(id: Int): LiveData<ResponseDetailMovie> {

        val data = MutableLiveData<ResponseDetailMovie>()

        coroutineScope.launch {

            val getMoviesDeferred = TMDBApi.retrofitService.getDetailMovie(id)
            try {
                val listResult = getMoviesDeferred.await()
                data.postValue(listResult)
            } catch (e: Exception) {

            }
        }

        return data
    }

}