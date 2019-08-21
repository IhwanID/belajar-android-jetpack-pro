package id.ihwan.jetpackpro.data.source.remote.network

import id.ihwan.jetpackpro.BuildConfig.BASE_URL


class ClientService {

    private val retrofitService = RetrofitBuilder.getInstance(BASE_URL).create(TMDBApiService::class.java)

}