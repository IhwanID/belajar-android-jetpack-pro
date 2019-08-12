package id.ihwan.jetpackpro.movies.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import id.ihwan.jetpackpro.data.source.MovieRepository
import id.ihwan.jetpackpro.util.LiveDataTestUtil
import kotlinx.coroutines.*
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import java.io.IOException

@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")
    private lateinit var detailMovieViewModel: DetailMovieViewModel
    private lateinit var repository: MovieRepository

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
        detailMovieViewModel = DetailMovieViewModel()
        repository = MovieRepository()
    }

    @After
    @Throws(IOException::class)
    fun tearDown() {
    }

    @Test
    @Throws(Exception::class)
    fun getDetail() = runBlocking {
        val data = repository.getDetailMovie(550)
        detailMovieViewModel.getDetail(550)
        val liveData = detailMovieViewModel.detailMovie
        assertNotNull(data)
        assertNotNull(LiveDataTestUtil.getValue(liveData))
        assertEquals(data, LiveDataTestUtil.getValue(liveData))
    }
}