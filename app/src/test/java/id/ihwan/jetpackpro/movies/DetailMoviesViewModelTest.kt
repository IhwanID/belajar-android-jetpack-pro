package id.ihwan.jetpackpro.movies

import id.ihwan.jetpackpro.R
import id.ihwan.jetpackpro.movies.model.Movies
import id.ihwan.jetpackpro.movies.viewmodel.DetailMoviesViewModel
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class DetailMoviesViewModelTest {

    private var viewModel: DetailMoviesViewModel? = null
    private var dataDummy: Movies? = null

    @Before
    fun setUp() {
        viewModel = DetailMoviesViewModel()
        dataDummy = Movies(
            1,
            "Alita : Battle Angel",
            "Robert Rodriguez",
            "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
            R.drawable.poster_alita,
            "2019",
            "67"
        )
    }

    @After
    fun tearDown() {
    }

    @Test
    fun detailMovies() {
        Assert.assertEquals(dataDummy?.id, viewModel?.detailMovies(1)?.id)
        Assert.assertEquals(dataDummy?.title, viewModel?.detailMovies(1)?.title)
        Assert.assertEquals(dataDummy?.director, viewModel?.detailMovies(1)?.director)
        Assert.assertEquals(dataDummy?.description, viewModel?.detailMovies(1)?.description)
        Assert.assertEquals(dataDummy?.image, viewModel?.detailMovies(1)?.image)
        Assert.assertEquals(dataDummy?.date, viewModel?.detailMovies(1)?.date)
    }
}