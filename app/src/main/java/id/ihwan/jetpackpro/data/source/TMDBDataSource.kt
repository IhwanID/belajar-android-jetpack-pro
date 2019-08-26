package id.ihwan.jetpackpro.data.source

import androidx.paging.DataSource
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData


interface TMDBDataSource {

    fun getFavoriteMovies(): DataSource.Factory<Int, ResultsData>

    fun getFavoriteTvShow(): DataSource.Factory<Int, ResultsData>

    fun unFavorite(data: ResultsData)

    fun addToFavorite(data: ResultsData)
}