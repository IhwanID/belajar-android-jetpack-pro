package id.ihwan.jetpackpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import id.ihwan.jetpackpro.movies.MoviesFragment
import id.ihwan.jetpackpro.tvshow.TvShowFragment
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {

    private lateinit  var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initViewPager()
    }

    private fun initViewPager() {
        viewPager = homeViewPager
        viewPager.adapter = HomePagerAdapter(supportFragmentManager)
        homeTabLayout.setupWithViewPager(viewPager)

    }



    inner class HomePagerAdapter( manager: FragmentManager) : FragmentStatePagerAdapter(manager) {
        private var moviesFragment: MoviesFragment = MoviesFragment.newInstance()
        private var tvShowFragment: TvShowFragment = TvShowFragment.newInstance()

        override fun getCount(): Int {
            return 2
        }

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> moviesFragment
                else -> tvShowFragment

            }
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return  when(position){
                0 -> "MOVIES"
                else -> "TV SHOW"
            }

        }

    }

}
