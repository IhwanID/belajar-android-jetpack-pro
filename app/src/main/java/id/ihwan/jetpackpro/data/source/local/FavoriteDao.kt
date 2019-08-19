package id.ihwan.jetpackpro.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.*
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData

@Dao
interface FavoriteDao {

//    @Insert
//    suspend fun insert(data: ResultsData)

    @Query("select * from favorite_table")
    fun getAllFavorite(): LiveData<List<ResultsData>>

    @Delete
    fun delete(data: ResultsData)

}