package id.ihwan.jetpackpro.data.source.local

import androidx.paging.DataSource
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData
import java.util.concurrent.Executor

class LocalDataSource(
    private val favoriteDao: FavoriteDao,
    private val ioExecutor: Executor
) {

    fun insert(data: List<ResultsData>, insertFinished: () -> Unit) {
        ioExecutor.execute {
            favoriteDao.insert(data)
            insertFinished()
        }
    }

    fun getAllMoviesData(): DataSource.Factory<Int, ResultsData>{
     return favoriteDao.getAllMovie("")
    }

    fun getAllTvShowData(): DataSource.Factory<Int, ResultsData>{
        return favoriteDao.getAllTvShow("")
    }

    fun getMoviesFavorite(): DataSource.Factory<Int, ResultsData>{
        return favoriteDao.getAllFavoriteMovie("")
    }

    fun getTvShowFavorite(): DataSource.Factory<Int, ResultsData>{
        return favoriteDao.getAllFavoriteTvShow("")
    }

    fun addToFavorite(id: Int){
        ioExecutor.execute {
            favoriteDao.favoriteMovie(id)
        }
    }

    fun deleteFromFavorite(id: Int){
        ioExecutor.execute {
            favoriteDao.unFavoriteMovie(id)
        }
    }
}