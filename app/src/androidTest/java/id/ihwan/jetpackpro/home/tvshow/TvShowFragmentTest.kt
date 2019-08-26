package id.ihwan.jetpackpro.home.tvshow

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import id.ihwan.jetpackpro.R
import org.junit.After
import org.junit.Before
import org.junit.Test
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import id.ihwan.jetpackpro.SingleFragmentActivity
import id.ihwan.jetpackpro.home.tvshow.view.TvShowFragment
import id.ihwan.jetpackpro.utils.EspressoIdlingResource
import org.junit.Rule


class TvShowFragmentTest {

    @Rule
    @JvmField
    val activityRule: ActivityTestRule<SingleFragmentActivity> = ActivityTestRule(SingleFragmentActivity::class.java)
    private val tvShowFragment = TvShowFragment()

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoIdlingResource)
        activityRule.activity.setFragment(tvShowFragment)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoIdlingResource)
    }

    @Test
    fun getData() {
        onView(withId(R.id.tvShowRecyclerView)).check(matches(isDisplayed()))
        onView(withId(R.id.tvShowRecyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.favorite_button)).check(matches(isDisplayed()))
        onView(withId(R.id.favorite_button)).perform(click())
    }
}