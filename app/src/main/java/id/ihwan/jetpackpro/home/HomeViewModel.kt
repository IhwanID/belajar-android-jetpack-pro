package id.ihwan.jetpackpro.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ihwan.jetpackpro.network.TMDBApi
import id.ihwan.jetpackpro.network.response.ResultsMovie
import id.ihwan.jetpackpro.network.response.ResultsTvShow
import id.ihwan.jetpackpro.tvshow.model.TvShow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

enum class Status { LOADING, ERROR, DONE }

class HomeViewModel : ViewModel() {

    private val _status = MutableLiveData<Status>()

    val status: LiveData<Status>
        get() = _status

    private val _movies = MutableLiveData<List<ResultsMovie>>()

    val movies: LiveData<List<ResultsMovie>>
        get() = _movies

    private val _tvShow = MutableLiveData<List<ResultsTvShow>>()

    val tvShow: LiveData<List<ResultsTvShow>>
        get() = _tvShow

    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    fun getMovies() {
        coroutineScope.launch {

            val getMoviesDeferred = TMDBApi.retrofitService.getPopularMovies()
            try {
                _status.value = Status.LOADING

                val listResult = getMoviesDeferred.await()
                _status.value = Status.DONE
                _movies.postValue(listResult.results)
                Log.d("listResult", listResult.toString())
            } catch (e: Exception) {
                _status.value = Status.ERROR
                _movies.value = ArrayList()
                Log.d("listResult", "gagal $e")
            }
        }
    }

    fun getTvShow(){
        coroutineScope.launch {

            val getTvShowDeferred = TMDBApi.retrofitService.getPopularTvShow()
            try {
                _status.value = Status.LOADING

                val listResult = getTvShowDeferred.await()
                _status.value = Status.DONE
                _tvShow.postValue(listResult.results)
                Log.d("listResult", listResult.toString())
            } catch (e: Exception) {
                _status.value = Status.ERROR
                _movies.value = ArrayList()
                Log.d("listResult", "gagal $e")
            }
        }
    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}