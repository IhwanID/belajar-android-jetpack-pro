package id.ihwan.jetpackpro.data.source.local

import androidx.paging.DataSource
import androidx.room.*
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData

@Dao
interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: List<ResultsData>)

    @Query("select * from favorite_table where name = :name")
    fun getAllMovie(name: String): DataSource.Factory<Int, ResultsData>

    @Query("select * from favorite_table where title = :title")
    fun getAllTvShow(title: String): DataSource.Factory<Int, ResultsData>

    @Query("select * from favorite_table where name = :title and isFavorite = 1")
    fun getAllFavoriteMovie(title: String): DataSource.Factory<Int, ResultsData>

    @Query("select * from favorite_table where title = :title and isFavorite = 1")
    fun getAllFavoriteTvShow(title: String): DataSource.Factory<Int, ResultsData>

    @Query("UPDATE favorite_table SET isFavorite = 1 WHERE id =:id")
    fun favoriteMovie(id: Int)

    @Query("UPDATE favorite_table SET isFavorite = 0 WHERE id =:id")
    fun unFavoriteMovie(id: Int)

}