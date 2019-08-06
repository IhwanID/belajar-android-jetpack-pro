package id.ihwan.jetpackpro.movies.view

import android.content.Intent
import android.os.Bundle
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
import id.ihwan.jetpackpro.network.response.ResultsMovie
import id.ihwan.jetpackpro.utils.Status

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
        MoviesAdapter{ goToDetailMovies(it) }
    }

    lateinit var binding: FragmentMoviesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movies, container, false)
        binding.lifecycleOwner = this@MoviesFragment

        binding.moviesRecyclerView.apply {
            adapter = moviesAdapter
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
        }

        viewModel.movies.observe(this, Observer {
            moviesAdapter.loadData(it)
        })

        viewModel.status.observe(this, Observer {
            when(it){
                Status.LOADING -> {
                    binding.moviesRecyclerView.visibility = View.INVISIBLE
                    binding.progressBar.visibility = View.VISIBLE
                }
                Status.DONE -> {
                    binding.moviesRecyclerView.visibility = View.VISIBLE
                    binding.progressBar.visibility = View.INVISIBLE
                }
                else -> {

                }
            }
        })
        return binding.root

    }

    private fun goToDetailMovies(movies: ResultsMovie){
        val i = Intent(activity, DetailMoviesActivity::class.java)
        i.putExtra("id", movies.id)
        startActivity(i)
    }

}
