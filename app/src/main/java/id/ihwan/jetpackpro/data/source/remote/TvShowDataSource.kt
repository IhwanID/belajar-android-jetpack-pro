package id.ihwan.jetpackpro.data.source.remote

import androidx.paging.PageKeyedDataSource
import id.ihwan.jetpackpro.data.source.remote.network.TMDBApiService
import id.ihwan.jetpackpro.data.source.remote.network.response.ResponseData
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TvShowDataSource(private val service: TMDBApiService) :
    PageKeyedDataSource<Int, ResultsData>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, ResultsData>
    ) {
        service.getPopularTvShow(page = 1).enqueue(
            object : Callback<ResponseData> {
                override fun onFailure(call: Call<ResponseData>?, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<ResponseData>?,
                    response: Response<ResponseData>
                ) {
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
        service.getPopularTvShow(page = params.key).enqueue(
            object : Callback<ResponseData> {
                override fun onFailure(call: Call<ResponseData>?, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<ResponseData>?,
                    response: Response<ResponseData>
                ) {
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