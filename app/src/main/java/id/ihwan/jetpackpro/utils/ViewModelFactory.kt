package id.ihwan.jetpackpro.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.ihwan.jetpackpro.data.source.MovieRepository
import id.ihwan.jetpackpro.detail.DetailViewModel
import id.ihwan.jetpackpro.favorite.FavoriteViewModel
import id.ihwan.jetpackpro.home.HomeViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(private val repository: MovieRepository) : ViewModelProvider.Factory {
   override fun <T : ViewModel> create(modelClass: Class<T>) =
       with(modelClass) {
           when {
               isAssignableFrom(HomeViewModel::class.java) ->
                   HomeViewModel(repository)
               isAssignableFrom(DetailViewModel::class.java) ->
                   DetailViewModel(repository)
               isAssignableFrom(FavoriteViewModel::class.java) ->
                   FavoriteViewModel(repository)
               else ->
                   throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
           }
       } as T
}
