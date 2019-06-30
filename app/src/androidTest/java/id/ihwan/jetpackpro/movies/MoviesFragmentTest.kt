package id.ihwan.jetpackpro.movies

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.rule.ActivityTestRule
import id.ihwan.jetpackpro.R
import id.ihwan.jetpackpro.RecyclerViewItemCountAssertion
import id.ihwan.jetpackpro.SingleFragmentActivity
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Rule

class MoviesFragmentTest {

    @Rule @JvmField
    val activityRule: ActivityTestRule<SingleFragmentActivity> = ActivityTestRule(SingleFragmentActivity::class.java)
    private val moviesFragment = MoviesFragment()

    @Before
    fun setUp() {
        activityRule.activity.setFragment(moviesFragment)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getData() {
        onView(ViewMatchers.withId(R.id.moviesRecyclerView)).check(matches(isDisplayed()))
        onView(ViewMatchers.withId(R.id.moviesRecyclerView)).check(RecyclerViewItemCountAssertion(16))
    }
}