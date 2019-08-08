package id.ihwan.jetpackpro.tvshow.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ihwan.jetpackpro.data.source.MovieRepository
import id.ihwan.jetpackpro.data.source.remote.network.response.ResponseTvShowDetail
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class DetailTvShowViewModel: ViewModel() {
    private val viewModelJob = SupervisorJob()

    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    val repository = MovieRepository()

    private val _detailTvShow = MutableLiveData<ResponseTvShowDetail>()

    val detailTvShow: LiveData<ResponseTvShowDetail>
        get() = _detailTvShow

    fun getDetail(id: Int){
        viewModelScope.launch {
            _detailTvShow.value = repository.getDetailTvShow(id)
        }
    }
}