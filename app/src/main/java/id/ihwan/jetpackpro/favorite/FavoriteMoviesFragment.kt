package id.ihwan.jetpackpro.favorite

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
import id.ihwan.jetpackpro.utils.Injection
import id.ihwan.jetpackpro.R
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData
import id.ihwan.jetpackpro.databinding.FragmentFavoriteMoviesBinding
import id.ihwan.jetpackpro.adapter.MoviesPagedListAdapter
import id.ihwan.jetpackpro.detail.DetailActivity

class FavoriteMoviesFragment : Fragment() {

    companion object {
        fun newInstance(): FavoriteMoviesFragment {
            return FavoriteMoviesFragment()
        }
    }

    private val adapterList: MoviesPagedListAdapter by lazy {
        MoviesPagedListAdapter{ goToDetailMovies(it) }
    }

    private lateinit var viewModel: FavoriteViewModel


    lateinit var binding: FragmentFavoriteMoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorite_movies, container, false)
        binding.lifecycleOwner = this@FavoriteMoviesFragment

        viewModel = ViewModelProviders.of(this, Injection.provideViewModelFactory(requireContext()))
            .get(FavoriteViewModel::class.java)

        binding.favMoviesRV.apply {
            adapter = adapterList
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
        }

        viewModel.favMovies.observe(this, Observer<PagedList<ResultsData>> {
            adapterList.submitList(it)
        })

        return binding.root
    }

    private fun goToDetailMovies(movies: ResultsData){
        val i = Intent(activity, DetailActivity::class.java)
        i.putExtra("liveDataMovies", movies)
        i.putExtra("isFromFavorite", true)
        startActivity(i)
    }


}
