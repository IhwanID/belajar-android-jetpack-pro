package id.ihwan.jetpackpro.data.source.local

import androidx.paging.DataSource
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData
import java.util.concurrent.Executor

class TMDBLocalCache(
    private val favoriteDao: FavoriteDao,
    private val ioExecutor: Executor
) {

    fun insert(repos: List<ResultsData>, insertFinished: () -> Unit) {
        ioExecutor.execute {
            favoriteDao.insert(repos)
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
    fun addToFavorite(id: Int){
        ioExecutor.execute {
            favoriteDao.favoriteMovie(id)
        }
    }
}