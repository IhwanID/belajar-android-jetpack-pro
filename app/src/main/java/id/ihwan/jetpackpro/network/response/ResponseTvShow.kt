package id.ihwan.jetpackpro.network.response

data class ResponseTvShow(
    val results: List<ResultsTvShow>? = emptyList()
)

data class ResultsTvShow(
    val id: Int? = 0 ,
    val name: String? = "",
    val popularity: String? = "",
    val poster_path: String? = "",
    val backdrop_path: String? = "",
    val overview: String? = "",
    val first_air_date: String? = ""
)

