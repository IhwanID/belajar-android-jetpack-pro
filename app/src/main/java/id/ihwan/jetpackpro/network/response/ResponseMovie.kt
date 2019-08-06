package id.ihwan.jetpackpro.network.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class ResponseMovie(
    val total_pages: Int? = 0,
    val results: List<ResultsMovie>? = emptyList()
)

@Parcelize
data class ResultsMovie(
    val id: Int? = 0 ,
    val title: String? = "",
    val vote_average: String? = "",
    val popularity: String? = "",
    val poster_path: String? = "",
    val backdrop_path: String? = "",
    val overview: String? = "",
    val release_date: String? = ""
): Parcelable