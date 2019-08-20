package id.ihwan.jetpackpro.data.source.local

import androidx.paging.DataSource
import androidx.room.*
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData

@Dao
interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: List<ResultsData>)

    @Query("select * from favorite_table")
    fun getAllFavorite(): DataSource.Factory<Int, ResultsData>

    @Delete
    fun delete(data: ResultsData)

}