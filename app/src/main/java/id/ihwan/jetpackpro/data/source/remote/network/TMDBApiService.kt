package id.ihwan.jetpackpro.data.source.remote.network

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

fun getDataFromApi(
    service: TMDBApiService,
    page: Int,
    onSuccess: (data: List<ResultsData>) -> Unit,
    onError: (error: String) -> Unit
) {
    service.getPopularMovies(page = page).enqueue(
        object : Callback<ResponseData> {
            override fun onFailure(call: Call<ResponseData>?, t: Throwable) {
                onError(t.message ?: "unknown error")
            }

            override fun onResponse(
                call: Call<ResponseData>?,
                response: Response<ResponseData>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()?.results ?: emptyList()
                    onSuccess(data)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error")
                }
            }
        }
    )
}

fun getDataTvShowFromApi(
    service: TMDBApiService,
    page: Int,
    onSuccess: (data: List<ResultsData>) -> Unit,
    onError: (error: String) -> Unit
) {
    service.getPopularTvShow(page = page).enqueue(
        object : Callback<ResponseData> {
            override fun onFailure(call: Call<ResponseData>?, t: Throwable) {
                onError(t.message ?: "unknown error")
            }

            override fun onResponse(
                call: Call<ResponseData>?,
                response: Response<ResponseData>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()?.results ?: emptyList()
                    onSuccess(data)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error")
                }
            }
        }
    )
}

interface TMDBApiService {

    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String? = API_KEY,
        @Query("page") page: Int = 0
    ): Call<ResponseData>

    @GET("tv/popular")
    fun getPopularTvShow(
        @Query("api_key") apiKey: String? = API_KEY,
        @Query("page") page: Int = 0
    ): Call <ResponseData>

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