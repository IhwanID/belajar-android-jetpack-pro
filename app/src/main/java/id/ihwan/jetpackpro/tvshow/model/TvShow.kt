package id.ihwan.jetpackpro.tvshow.model

import id.ihwan.jetpackpro.R

data class TvShow(
    val id: Int = 0,
    val title: String = "",
    val description: String = "",
    val image: Int = R.color.material_blue_grey_800,
    val date: String = "",
    val rating: String = ""
)