package id.ihwan.jetpackpro.tvshow.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import id.ihwan.jetpackpro.data.source.MovieRepository
import id.ihwan.jetpackpro.util.LiveDataTestUtil
import kotlinx.coroutines.*
import kotlinx.coroutines.test.setMain
import org.junit.*

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import java.io.IOException

@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class DetailTvShowViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")
    private lateinit var detailTvShowViewModel: DetailTvShowViewModel
    private lateinit var repository: MovieRepository

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
        detailTvShowViewModel = DetailTvShowViewModel()
        repository = MovieRepository()
    }

    @After
    @Throws(IOException::class)
    fun tearDown() {
    }

    @Test
    @Throws(Exception::class)
    fun getDetail() = runBlocking {
        val data = repository.getDetailTvShow(60735)
        detailTvShowViewModel.getDetail(60735)
        val liveData = detailTvShowViewModel.detailTvShow
        assertNotNull(data)
        assertNotNull(LiveDataTestUtil.getValue(liveData))
        assertEquals(data, LiveDataTestUtil.getValue(liveData))
    }
}