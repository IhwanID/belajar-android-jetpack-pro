package id.ihwan.jetpackpro.data.source.remote

import androidx.paging.PageKeyedDataSource
import id.ihwan.jetpackpro.data.source.remote.network.TMDBApiService
import id.ihwan.jetpackpro.data.source.remote.network.response.ResponseData
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData
import id.ihwan.jetpackpro.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDataSource(private val service: TMDBApiService) :
    PageKeyedDataSource<Int, ResultsData>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, ResultsData>
    ) {
        EspressoIdlingResource.increment()
        service.getPopularMovies(page = 1).enqueue(
            object : Callback<ResponseData> {
                override fun onFailure(call: Call<ResponseData>?, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<ResponseData>?,
                    response: Response<ResponseData>
                ) {
                    EspressoIdlingResource.decrement()
                    if (response.isSuccessful) {
                        val data = response.body()?.results ?: emptyList()
                        callback.onResult(data, null, 2)

                    } else {

                    }
                }
            }
        )
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, ResultsData>) {
        EspressoIdlingResource.increment()
        service.getPopularMovies(page = params.key).enqueue(
            object : Callback<ResponseData> {
                override fun onFailure(call: Call<ResponseData>?, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<ResponseData>?,
                    response: Response<ResponseData>
                ) {
                    EspressoIdlingResource.decrement()
                    if (response.isSuccessful) {
                        val data = response.body()?.results ?: emptyList()
                        callback.onResult(data, params.key + 1)
                    } else {

                    }
                }
            }
        )
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, ResultsData>) {

    }

}