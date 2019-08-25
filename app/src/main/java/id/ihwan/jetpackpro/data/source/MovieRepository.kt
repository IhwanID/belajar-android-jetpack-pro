package id.ihwan.jetpackpro.data.source

import androidx.paging.DataSource
import id.ihwan.jetpackpro.data.source.local.LocalRepository
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData

class MovieRepository(
    private val localRepository: LocalRepository
): TMDBDataSource{

    override fun getFavoriteMovies(): DataSource.Factory<Int, ResultsData> {
        return localRepository.getMoviesFavorite()
    }

    override fun getFavoriteTvShow(): DataSource.Factory<Int, ResultsData> {
        return localRepository.getTvShowFavorite()
    }

    override fun unfavorite(data: ResultsData) {
       localRepository.deleteFromFavorite(data)
    }

    override fun addToFavorite(data: ResultsData) {
       localRepository.addToFavorite(data)
    }

}
