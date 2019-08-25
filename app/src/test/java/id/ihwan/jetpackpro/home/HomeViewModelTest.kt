package id.ihwan.jetpackpro.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import id.ihwan.jetpackpro.data.source.MovieRepository
import id.ihwan.jetpackpro.data.source.remote.MoviesDataSourceFactory
import id.ihwan.jetpackpro.data.source.remote.TvShowDataSourceFactory
import id.ihwan.jetpackpro.data.source.remote.network.TMDBApiService
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData
import org.junit.*
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

    var movieList : LiveData<PagedList<ResultsData>>
    var tvShowList : LiveData<PagedList<ResultsData>>

    private val moviesDataSourceFactory: MoviesDataSourceFactory
    private val tvShowDataSourceFactory: TvShowDataSourceFactory

    private val service = TMDBApiService.create()

    val config = PagedList.Config.Builder()
        .setPageSize(5)
        .setInitialLoadSizeHint(5 * 2)
        .setEnablePlaceholders(false)
        .build()

    init {
        moviesDataSourceFactory = MoviesDataSourceFactory(service)
        tvShowDataSourceFactory = TvShowDataSourceFactory(service)

        movieList = LivePagedListBuilder(moviesDataSourceFactory, config).build()
        tvShowList = LivePagedListBuilder(tvShowDataSourceFactory, config).build()
    }

    @Before
    fun setUp() {
        viewModel = HomeViewModel(repository)

    }

    @After
    fun tearDown() {

    }

    @Test
    fun getData() {
        Assert.assertNotNull(movieList)
        Assert.assertNotNull(tvShowList)
    }

}