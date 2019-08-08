package id.ihwan.jetpackpro.data.source.remote.network

import id.ihwan.jetpackpro.BuildConfig.API_KEY
import id.ihwan.jetpackpro.data.source.remote.network.response.ResponseDetailMovie
import id.ihwan.jetpackpro.data.source.remote.network.response.ResponseMovie
import id.ihwan.jetpackpro.data.source.remote.network.response.ResponseTvShow
import id.ihwan.jetpackpro.data.source.remote.network.response.ResponseTvShowDetail
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TMDBApiService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String? = API_KEY): ResponseMovie

    @GET("tv/popular")
    suspend fun getPopularTvShow(@Query("api_key") apiKey: String? = API_KEY): ResponseTvShow

    @GET("movie/{id}")
    suspend fun getDetailMovie(@Path("id") id: Int,
                       @Query("api_key") apiKey: String? = API_KEY
    ): ResponseDetailMovie

    @GET("tv/{id}")
    suspend fun getDetailTvShow(@Path("id") id: Int,
                        @Query("api_key") apiKey: String? = API_KEY
    ): ResponseTvShowDetail

}