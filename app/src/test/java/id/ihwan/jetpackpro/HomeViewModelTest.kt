package id.ihwan.jetpackpro

import org.junit.Assert.*
import org.junit.After
import org.junit.Before
import org.junit.Test


class HomeViewModelTest{
    private var viewModel: HomeViewModel? = null

    @Before
    fun setUp() {
        viewModel = HomeViewModel()
    }

    @After
    fun tearDown() {
    }

    @Test
    fun movies() {
        assertEquals(16, viewModel?.movies?.size)
    }
}