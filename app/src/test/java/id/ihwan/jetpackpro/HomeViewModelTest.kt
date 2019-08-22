package id.ihwan.jetpackpro

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import id.ihwan.jetpackpro.data.source.MovieRepository
import id.ihwan.jetpackpro.home.HomeViewModel
import id.ihwan.jetpackpro.util.LiveDataTestUtil
import kotlinx.coroutines.*
import kotlinx.coroutines.test.setMain
import org.junit.*
import org.junit.Assert
import org.junit.Assert.*
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
    }


    @After
    @Throws(IOException::class)
    fun tearDown() {
    }

    @Test
    @Throws(Exception::class)
    fun getData() = runBlocking {

    }
}