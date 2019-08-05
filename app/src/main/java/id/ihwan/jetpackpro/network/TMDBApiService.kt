package id.ihwan.jetpackpro.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import id.ihwan.jetpackpro.network.response.ResponseDetailMovie
import id.ihwan.jetpackpro.network.response.ResponseMovie
import id.ihwan.jetpackpro.network.response.ResponseTvShow
import id.ihwan.jetpackpro.network.response.ResponseTvShowDetail
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "https://api.themoviedb.org/3/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface TMDBApiService {

    @GET("movie/popular")
    fun getPopularMovies(@Query("api_key") apiKey: String? = "78adf61cd991fec888c055105c148a44"): Deferred<ResponseMovie>

    @GET("tv/popular")
    fun getPopularTvShow(@Query("api_key") apiKey: String? = "78adf61cd991fec888c055105c148a44"): Deferred<ResponseTvShow>

    @GET("movie/{id}")
    fun getDetailMovie(@Path("id") id: Int,
                       @Query("api_key") apiKey: String? = "78adf61cd991fec888c055105c148a44"): Deferred<ResponseDetailMovie>

    @GET("tv/{id}")
    fun getDetailTvShow(@Path("id") id: Int,
                        @Query("api_key") apiKey: String? = "78adf61cd991fec888c055105c148a44"): Deferred<ResponseTvShowDetail>

}

object TMDBApi{
    val retrofitService : TMDBApiService by lazy { retrofit.create(TMDBApiService::class.java) }
}
