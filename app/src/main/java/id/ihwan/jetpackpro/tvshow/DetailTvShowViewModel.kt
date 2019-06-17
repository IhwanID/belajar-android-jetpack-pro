package id.ihwan.jetpackpro.tvshow

import androidx.lifecycle.ViewModel
import id.ihwan.jetpackpro.utils.DataDummy

class DetailTvShowViewModel: ViewModel() {

    fun detailTvShow(id: Int) : TvShow? = DataDummy.getTvShowById(id)
}