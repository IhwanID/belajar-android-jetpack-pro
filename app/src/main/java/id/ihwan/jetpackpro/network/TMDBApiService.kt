package id.ihwan.jetpackpro.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import id.ihwan.jetpackpro.movies.model.Movies
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
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
    fun getPopularMoviews(@Query("api_key") apiKey: String): Deferred<List<Movies>>


}

object TMDBApi{
    val retrofitService : TMDBApiService by lazy { retrofit.create(TMDBApiService::class.java) }
}
