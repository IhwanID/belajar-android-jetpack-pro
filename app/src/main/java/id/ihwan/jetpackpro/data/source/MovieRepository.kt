package id.ihwan.jetpackpro.data.source

import id.ihwan.jetpackpro.data.source.remote.network.ClientService

class MovieRepository() {
    private val clientService = ClientService()


    suspend fun getMovie() = clientService.getMovies()
    suspend fun getTvShow() = clientService.getTvShows()

}