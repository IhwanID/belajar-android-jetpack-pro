package id.ihwan.jetpackpro.data.source.local

import androidx.paging.DataSource
import androidx.room.*
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData

/**
 * Data Access Object for the favorite table.
 */
@Dao
interface FavoriteDao {

    /**
     * Insert a movie / tvShow in the database. If the task already exists, replace it.
     *
     * @param data the movie / tvShow to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: ResultsData)

    /**
     * Delete a movie / tvShow in the database.
     *
     * @param data the movie / tvShow to be deleted.
     */
    @Delete
    fun delete(data: ResultsData)

    /**
     * get liveDataMovies favorite movie / tvShow in the database as paging.
     */
    @Query("select * from favorite_table where name = :title")
    fun getAllFavoriteMovie(title: String): DataSource.Factory<Int, ResultsData>

    @Query("select * from favorite_table where title = :title")
    fun getAllFavoriteTvShow(title: String): DataSource.Factory<Int, ResultsData>

}