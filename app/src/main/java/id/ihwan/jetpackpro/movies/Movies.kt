package id.ihwan.jetpackpro.movies

import id.ihwan.jetpackpro.R

data class Movies(
        val id : Int = 0,
        val title : String = "",
        val director: String = "",
        val description : String = "",
        val image : Int = R.color.colorPrimaryDark,
        val date : String = "",
        val rating : String = ""
)