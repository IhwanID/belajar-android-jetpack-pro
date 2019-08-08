package id.ihwan.jetpackpro.data.source.remote.network

import id.ihwan.jetpackpro.BuildConfig.BASE_URL


class ClientService {

    private val retrofitService = RetrofitBuilder.getInstance(BASE_URL).create(TMDBApiService::class.java)

    suspend fun getMovies() = retrofitService.getPopularMovies().results
    suspend fun getTvShows() = retrofitService.getPopularTvShow().results
    suspend fun getDetailMovie(id: Int) = retrofitService.getDetailMovie(id)
    suspend fun getDetailTvShow(id: Int) = retrofitService.getDetailTvShow(id)
}