package id.ihwan.jetpackpro.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData

@Dao
interface FavoriteDao {

    @Query("select * from resultsdata")
    fun getVideos(): LiveData<List<ResultsData>>


}