package id.ihwan.jetpackpro

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import id.ihwan.jetpackpro.data.source.MovieRepository
import id.ihwan.jetpackpro.home.HomeViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.test.setMain
import org.junit.*
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import java.io.IOException

@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest{

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var repository: MovieRepository


    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
        repository = MovieRepository()
        homeViewModel = HomeViewModel()
    }


    @After
    @Throws(IOException::class)
    fun tearDown() {
    }

    @Test
    @Throws(Exception::class)
    fun getData() = runBlocking {
        val movies = repository.getMovie()
        Assert.assertNotNull(movies?.size)
        Assert.assertEquals(20, movies?.size)
    }
}