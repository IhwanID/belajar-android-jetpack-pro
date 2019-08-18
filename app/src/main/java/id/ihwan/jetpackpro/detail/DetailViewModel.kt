package id.ihwan.jetpackpro.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.ihwan.jetpackpro.data.source.MovieRepository
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {

    val repository = MovieRepository()

    var _detail = MutableLiveData<ResultsData>()

    val detail: LiveData<ResultsData>
        get() = _detail

    fun insert(data: ResultsData) = viewModelScope.launch {
        //insert data to room here
    }
}