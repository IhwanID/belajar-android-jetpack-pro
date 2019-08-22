package id.ihwan.jetpackpro.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import id.ihwan.jetpackpro.data.source.MovieRepository
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class HomeViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var movieRepository: MovieRepository

    private var viewModel: HomeViewModel? = null

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = HomeViewModel(movieRepository)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getDataMovies() {
        
    }
}