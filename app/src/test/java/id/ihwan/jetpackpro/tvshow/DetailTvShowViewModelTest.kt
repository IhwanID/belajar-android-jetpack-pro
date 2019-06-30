package id.ihwan.jetpackpro.tvshow

import id.ihwan.jetpackpro.R
import id.ihwan.jetpackpro.tvshow.model.TvShow
import id.ihwan.jetpackpro.tvshow.viewmodel.DetailTvShowViewModel
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class DetailTvShowViewModelTest {

    private var viewModel: DetailTvShowViewModel? = null
    private var dataDummy: TvShow? = null

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel()
        dataDummy = TvShow(
            1,
            "Arrow",
            "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
            R.drawable.poster_arrow,
            "2012",
            "58"
        )
    }

    @After
    fun tearDown() {
    }

    @Test
    fun detailTvShow() {
        Assert.assertEquals(dataDummy?.id, viewModel?.detailTvShow(1)?.id)
        Assert.assertEquals(dataDummy?.title, viewModel?.detailTvShow(1)?.title)
        Assert.assertEquals(dataDummy?.description, viewModel?.detailTvShow(1)?.description)
        Assert.assertEquals(dataDummy?.image, viewModel?.detailTvShow(1)?.image)
        Assert.assertEquals(dataDummy?.date, viewModel?.detailTvShow(1)?.date)
    }
}