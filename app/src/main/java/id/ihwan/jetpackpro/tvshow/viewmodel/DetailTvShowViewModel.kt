package id.ihwan.jetpackpro.tvshow.viewmodel

import androidx.lifecycle.ViewModel
import id.ihwan.jetpackpro.tvshow.model.TvShow
import id.ihwan.jetpackpro.utils.DataDummy

class DetailTvShowViewModel : ViewModel() {

    fun detailTvShow(id: Int): TvShow? = DataDummy.getTvShowById(id)
}