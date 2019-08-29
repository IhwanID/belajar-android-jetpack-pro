package id.ihwan.jetpackpro.data.source

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.PagedList
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData


interface TMDBDataSource {

    fun getAllMovies(): LiveData<PagedList<ResultsData>>

    fun getAllTvShow(): LiveData<PagedList<ResultsData>>

    fun getFavoriteMovies(): DataSource.Factory<Int, ResultsData>

    fun getFavoriteTvShow(): DataSource.Factory<Int, ResultsData>

    fun unFavorite(data: ResultsData)

    fun addToFavorite(data: ResultsData)
}