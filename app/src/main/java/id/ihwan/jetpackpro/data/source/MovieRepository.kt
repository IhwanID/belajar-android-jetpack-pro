package id.ihwan.jetpackpro.data.source

import id.ihwan.jetpackpro.data.source.remote.network.ClientService
class MovieRepository {
    private val clientService = ClientService()

    suspend fun getMovie() = clientService.getMovies()
    suspend fun getTvShow() = clientService.getTvShows()
    suspend fun getDetailMovie(id: Int)  = clientService.getDetailMovie(id)
    suspend fun getDetailTvShow(id: Int) = clientService.getDetailTvShow(id)



}