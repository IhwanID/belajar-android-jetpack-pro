package id.ihwan.jetpackpro.tvshow

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import id.ihwan.jetpackpro.R
import org.junit.After
import org.junit.Before
import org.junit.Test
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule

import id.ihwan.jetpackpro.SingleFragmentActivity
import id.ihwan.jetpackpro.tvshow.view.TvShowFragment
import org.junit.Rule


class TvShowFragmentTest {

    @Rule @JvmField
    val activityRule = ActivityTestRule(SingleFragmentActivity::class.java)
    private val tvShowFragment = TvShowFragment()

    @Before
    fun setUp() {
        activityRule.activity.setFragment(tvShowFragment)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getData() {
        onView(withId(R.id.tvShowRecyclerView)).check(matches(isDisplayed()))
    }
}