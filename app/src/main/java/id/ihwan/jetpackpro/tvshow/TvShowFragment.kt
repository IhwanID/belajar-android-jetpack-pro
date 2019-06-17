package id.ihwan.jetpackpro.tvshow


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import id.ihwan.jetpackpro.R
import id.ihwan.jetpackpro.movies.MoviesFragment


class TvShowFragment : Fragment() {

    companion object {
        fun newInstance(): TvShowFragment {
            return TvShowFragment()
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }


}
