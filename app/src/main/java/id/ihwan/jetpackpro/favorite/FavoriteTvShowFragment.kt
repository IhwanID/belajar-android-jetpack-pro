package id.ihwan.jetpackpro.favorite


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import id.ihwan.jetpackpro.R

class FavoriteTvShowFragment : Fragment() {

    companion object {
        fun newInstance(): FavoriteTvShowFragment {
            return FavoriteTvShowFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_favorite_tv_show, container, false)
    }


}
