package id.ihwan.jetpackpro.data.source.local

import android.util.Log
import androidx.paging.DataSource
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.concurrent.Executor

class TMDBLocalCache(
    private val favoriteDao: FavoriteDao,
    private val ioExecutor: Executor
) {

    fun insert(repos: List<ResultsData>, insertFinished: () -> Unit) {
        ioExecutor.execute {
            Log.d("GithubLocalCache", "inserting ${repos.size} repos")
            GlobalScope.launch {
                favoriteDao.insert(repos)
            }
            insertFinished()
        }
    }

    fun getAllData(): DataSource.Factory<Int, ResultsData>{
     return favoriteDao.getAllFavorite()
    }
}