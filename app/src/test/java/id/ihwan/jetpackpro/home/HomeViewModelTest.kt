package id.ihwan.jetpackpro.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import id.ihwan.jetpackpro.data.source.MovieRepository
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations


@RunWith(JUnit4::class)
class HomeViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val repository = mock(MovieRepository::class.java)
    private var viewModel: HomeViewModel? = null

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = HomeViewModel(repository)

    }

    @After
    fun tearDown() {

    }

    @Test
    fun getData() {
        val dummyContent: MutableLiveData<PagedList<ResultsData>> = MutableLiveData()
        val pagedList: PagedList<*> = mock(PagedList::class.java)
        dummyContent.value = pagedList as PagedList<ResultsData>

        `when`(repository.getAllMovies()).thenReturn(dummyContent)
        verify(repository).getAllMovies()

        `when`(repository.getAllTvShow()).thenReturn(dummyContent)
        verify(repository).getAllTvShow()

    }

}