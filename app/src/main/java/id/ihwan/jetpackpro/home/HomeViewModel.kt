package id.ihwan.jetpackpro.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ihwan.jetpackpro.movies.model.Movies
import id.ihwan.jetpackpro.network.TMDBApi
import id.ihwan.jetpackpro.tvshow.model.TvShow
import id.ihwan.jetpackpro.utils.DataDummy
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

enum class Status { LOADING, ERROR, DONE }

class HomeViewModel : ViewModel() {

    val movies : List<Movies> = DataDummy.generateDummyMovies()
    val tvShow : List<TvShow> = DataDummy.generateDummyTvShow()

    private val _status = MutableLiveData<Status>()

    val status: LiveData<Status>
        get() = _status

    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    fun getMovies() {
        coroutineScope.launch {

            var getMoviesDeferred = TMDBApi.retrofitService.getPopularMoviews()
            try {
                _status.value = Status.LOADING

                val listResult = getMoviesDeferred.await()
                _status.value = Status.DONE
                Log.d("listResult", listResult.toString())
            } catch (e: Exception) {
                _status.value = Status.ERROR
                Log.d("listResult", "gagal $e")
            }
        }
    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}