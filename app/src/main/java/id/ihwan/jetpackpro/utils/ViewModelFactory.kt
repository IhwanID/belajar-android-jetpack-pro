package id.ihwan.jetpackpro.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.ihwan.jetpackpro.data.source.MovieRepository
import id.ihwan.jetpackpro.detail.DetailViewModel
import id.ihwan.jetpackpro.favorite.FavoriteViewModel
import id.ihwan.jetpackpro.home.HomeViewModel

class ViewModelFactory(private val repository: MovieRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(repository) as T
        }else if(modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DetailViewModel(repository) as T
        }else if(modelClass.isAssignableFrom(FavoriteViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FavoriteViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
