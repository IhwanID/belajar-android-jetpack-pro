package id.ihwan.jetpackpro.data.source.local

import androidx.paging.DataSource
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData
import java.util.concurrent.Executor

class TMDBLocalCache(
    private val favoriteDao: FavoriteDao,
    private val ioExecutor: Executor
) {
    fun getAllData(): DataSource.Factory<Int, ResultsData>{
     return favoriteDao.getAllFavorite()
    }
}