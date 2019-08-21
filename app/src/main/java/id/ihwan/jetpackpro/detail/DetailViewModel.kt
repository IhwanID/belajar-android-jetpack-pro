package id.ihwan.jetpackpro.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ihwan.jetpackpro.data.source.MovieRepository
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData

class DetailViewModel(private val repository: MovieRepository) : ViewModel() {

    var _detail = MutableLiveData<ResultsData>()

    val detail: LiveData<ResultsData>
        get() = _detail


    fun addToFavorite(id: Int){
        repository.addToFavorite(id)
    }

    fun deteleFromFavorite(){

    }

}