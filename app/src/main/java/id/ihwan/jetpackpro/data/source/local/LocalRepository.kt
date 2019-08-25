package id.ihwan.jetpackpro.data.source.local

import androidx.paging.DataSource
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData
import java.util.concurrent.Executor

class LocalRepository(
    private val favoriteDao: FavoriteDao,
    private val ioExecutor: Executor
) {

    fun getMoviesFavorite(): DataSource.Factory<Int, ResultsData>{
        return favoriteDao.getAllFavoriteMovie("")
    }

    fun getTvShowFavorite(): DataSource.Factory<Int, ResultsData>{
        return favoriteDao.getAllFavoriteTvShow("")
    }

    fun addToFavorite(data: ResultsData){
        ioExecutor.execute {
            favoriteDao.insert(data)
        }
    }

    fun deleteFromFavorite(data: ResultsData){
        ioExecutor.execute {
            favoriteDao.delete(data)
        }
    }
}