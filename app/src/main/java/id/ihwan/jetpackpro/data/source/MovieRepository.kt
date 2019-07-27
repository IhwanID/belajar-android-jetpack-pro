package id.ihwan.jetpackpro.data.source

import androidx.lifecycle.LiveData
import id.ihwan.jetpackpro.network.response.ResponseDetailMovie
import id.ihwan.jetpackpro.network.response.ResultsMovie
import id.ihwan.jetpackpro.network.response.ResultsTvShow


class MovieRepository {

    val remote = RemoteRepository()

    fun getMovie(): LiveData<List<ResultsMovie>>{
        return remote.getMovieFromApi()
    }

    fun getTvShow(): LiveData<List<ResultsTvShow>>{
        return remote.getTvShowFromApi()
    }

    fun getMovieDetail(id: Int): LiveData<ResponseDetailMovie>{
        return remote.getDetailMovieFromApi(id)
    }

    fun getTvShowDetail(){

    }

}