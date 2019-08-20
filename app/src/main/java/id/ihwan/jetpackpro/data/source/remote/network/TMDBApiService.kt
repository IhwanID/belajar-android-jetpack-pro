package id.ihwan.jetpackpro.data.source.remote.network

import android.util.Log
import id.ihwan.jetpackpro.BuildConfig.API_KEY
import id.ihwan.jetpackpro.data.source.remote.network.response.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//TODO : Call in BoundaryCallback
fun getDataMV(
    service: TMDBApiService,
    page: Int,
    onSuccess: (repos: List<ResultsData>) -> Unit,
    onError: (error: String) -> Unit
) {
    //Log.d(TAG, "query: $query, page: $page, itemsPerPage: $itemsPerPage")

    //val apiQuery = query + IN_QUALIFIER

    service.getPopularMV(API_KEY,page).enqueue(
        object : Callback<ResponseData> {
            override fun onFailure(call: Call<ResponseData>?, t: Throwable) {
                //Log.d(TAG, "fail to get data")
                onError(t.message ?: "unknown error")
            }

            override fun onResponse(
                call: Call<ResponseData>?,
                response: Response<ResponseData>
            ) {
               // Log.d(TAG, "got a response $response")
                if (response.isSuccessful) {
                    val repos = response.body()?.results ?: emptyList()
                    onSuccess(repos)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error")
                }
            }
        }
    )
}

interface TMDBApiService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String? = API_KEY,
                                 @Query("page") page: Int= 0): ResponseData

    @GET("tv/popular")
    suspend fun getPopularTvShow(@Query("api_key") apiKey: String? = API_KEY,
                                 @Query("page") page: Int = 0): ResponseData

    @GET("movie/popular")
    fun getPopularMV(@Query("api_key") apiKey: String? = API_KEY,
                         @Query("page") page: Int= 0): Call<ResponseData>

    companion object {
        private const val BASE_URL = "https://api.themoviedb.org/3/"

        fun create(): TMDBApiService {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BASIC

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TMDBApiService::class.java)
        }
    }
}