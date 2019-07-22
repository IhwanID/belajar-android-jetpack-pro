package id.ihwan.jetpackpro.movies.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import id.ihwan.jetpackpro.R
import id.ihwan.jetpackpro.home.HomeViewModel
import id.ihwan.jetpackpro.movies.model.Movies
import id.ihwan.jetpackpro.databinding.FragmentMoviesBinding
import id.ihwan.jetpackpro.movies.adapter.MoviesAdapter
import kotlinx.android.synthetic.main.fragment_movies.*

class MoviesFragment : Fragment() {

    companion object {
        fun newInstance(): MoviesFragment {
            return MoviesFragment()
        }
    }

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentMoviesBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root

    }

}
