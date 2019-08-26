package id.ihwan.jetpackpro.data.source.remote.network.response

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

class ResponseData (
    val results: List<ResultsData>? = emptyList()
)

@Parcelize
@Entity(tableName = "favorite_table")
data class ResultsData(
    @PrimaryKey
    val id: Int? = 0 ,
    val title: String? = "",
    val name: String? = "",
    val vote_average: String? = "",
    val popularity: String? = "",
    val poster_path: String? = "",
    val backdrop_path: String? = "",
    val overview: String? = "",
    val release_date: String? = ""
): Parcelable{

    fun getRealName(): String?{
        return if(title.isNullOrEmpty()){
            name
        }else{
            title
        }
    }

    fun getRating(): Float{
        return if (!vote_average.isNullOrEmpty()){
            vote_average.toFloat() / 2
        }else{
            0f
        }

    }
}