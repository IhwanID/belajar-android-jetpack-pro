package id.ihwan.jetpackpro.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import id.ihwan.jetpackpro.data.source.MovieRepository
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData
import id.ihwan.jetpackpro.home.HomeViewModel
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class DetailViewModelTest{

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private var viewModel: DetailViewModel? = null
    private val repository = Mockito.mock(MovieRepository::class.java)

    @Before
    fun setUp() {
        viewModel = DetailViewModel(repository)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun addToFavorite(){
        val data = ResultsData(
            1, "Iron Man"
        )
        repository.addToFavorite(data)
    }

    @Test
    fun deleteFromFavorite(){
        val data = ResultsData(
            1, "Iron Man"
        )
        repository.unfavorite(data)
    }

}