package id.ihwan.jetpackpro.movies.view


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import id.ihwan.jetpackpro.home.HomeViewModel
import id.ihwan.jetpackpro.databinding.FragmentMoviesBinding
import id.ihwan.jetpackpro.movies.adapter.MoviesAdapter
import id.ihwan.jetpackpro.R

class MoviesFragment : Fragment() {

    companion object {
        fun newInstance(): MoviesFragment {
            return MoviesFragment()
        }
    }

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }

    private val moviesAdapter: MoviesAdapter by lazy {
        MoviesAdapter{ Log.d("", it.overview) }
    }

    lateinit var binding: FragmentMoviesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movies, container, false)
        binding.lifecycleOwner = this@MoviesFragment

        binding.moviesRecyclerView.apply {
            adapter = moviesAdapter
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }

        viewModel.getMovies()
        viewModel.movies.observe(this, Observer {
            moviesAdapter.loadData(it)
        })

        return binding.root

    }

}
