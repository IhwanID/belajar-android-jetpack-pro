package id.ihwan.jetpackpro.home.movies.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import id.ihwan.jetpackpro.home.HomeViewModel
import id.ihwan.jetpackpro.databinding.FragmentMoviesBinding
import id.ihwan.jetpackpro.R
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData
import id.ihwan.jetpackpro.detail.DetailActivity
import id.ihwan.jetpackpro.adapter.MoviesPagedListAdapter
import id.ihwan.jetpackpro.utils.Injection

class MoviesFragment : Fragment() {

    companion object {
        fun newInstance(): MoviesFragment {
            return MoviesFragment()
        }
    }

    private val adapterList: MoviesPagedListAdapter by lazy {
        MoviesPagedListAdapter{ goToDetailMovies(it) }
    }

    private lateinit var viewModel: HomeViewModel


    lateinit var binding: FragmentMoviesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movies, container, false)
        binding.lifecycleOwner = this@MoviesFragment

        viewModel = ViewModelProviders.of(this, Injection.provideViewModelFactory(requireContext()))
            .get(HomeViewModel::class.java)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.moviesRecyclerView.apply {
            adapter = adapterList
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
        }

        viewModel.movieList.observe(this, Observer<PagedList<ResultsData>> {
            adapterList.submitList(it)
        })

    }

    private fun goToDetailMovies(movies: ResultsData){
        val i = Intent(activity, DetailActivity::class.java)
        i.putExtra("liveDataMovies", movies)
        i.putExtra("isFromFavorite", false)
        startActivity(i)
    }

}
