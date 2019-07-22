package id.ihwan.jetpackpro.network.response

data class ResponseMovie(
    val total_pages: Int? = 0,
    val results: List<ResultsMovie>? = emptyList()
)

data class ResultsMovie(
    val title: String? = "",
    //val vote_average: Int? = 0,
    val popularity: String? = "",
    val poster_path: String? = "",
    val backdrop_path: String? = "",
    val overview: String? = "",
    val release_date: String? = ""
)