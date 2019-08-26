package id.ihwan.jetpackpro.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import id.ihwan.jetpackpro.R
import kotlinx.android.synthetic.main.activity_favorite.*

class FavoriteActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        supportActionBar?.title = "Favorite Movie"

        initViewPager()
    }

    private fun initViewPager() {
        viewPager = favoriteHomeViewPager
        viewPager.adapter = HomePagerAdapter(supportFragmentManager)
        homeTabLayout.setupWithViewPager(viewPager)
    }


    inner class HomePagerAdapter(manager: FragmentManager) : FragmentStatePagerAdapter(manager) {
        private var favoriteMoviesFragment: FavoriteMoviesFragment = FavoriteMoviesFragment.newInstance()
        private var favoriteTvShowFragment: FavoriteTvShowFragment = FavoriteTvShowFragment.newInstance()

        override fun getCount(): Int = 2

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> favoriteMoviesFragment
                else -> favoriteTvShowFragment
            }
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return when (position) {
                0 -> "MOVIES"
                else -> "TV SHOW"
            }
        }
    }
}
