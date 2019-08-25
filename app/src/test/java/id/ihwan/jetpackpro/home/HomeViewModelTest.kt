package id.ihwan.jetpackpro.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import id.ihwan.jetpackpro.data.source.MovieRepository
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.mock


@RunWith(JUnit4::class)
class HomeViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val repository = mock(MovieRepository::class.java)
    private var viewModel: HomeViewModel? = null

    @Before
    fun setUp() {
        viewModel = HomeViewModel(repository)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getDataMovies() {

    }
}