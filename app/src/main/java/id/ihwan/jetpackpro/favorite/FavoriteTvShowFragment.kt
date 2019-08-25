package id.ihwan.jetpackpro.favorite


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import id.ihwan.jetpackpro.detail.DetailActivity
import id.ihwan.jetpackpro.R
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData
import id.ihwan.jetpackpro.databinding.FragmentFavoriteTvShowBinding
import id.ihwan.jetpackpro.adapter.MoviesPagedListAdapter
import id.ihwan.jetpackpro.utils.Injection

class FavoriteTvShowFragment : Fragment() {

    companion object {
        fun newInstance(): FavoriteTvShowFragment {
            return FavoriteTvShowFragment()
        }
    }

    private val adapterList: MoviesPagedListAdapter by lazy {
        MoviesPagedListAdapter{ goToDetailMovies(it) }
    }

    private lateinit var viewModel: FavoriteViewModel


    lateinit var binding: FragmentFavoriteTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorite_tv_show, container, false)
        binding.lifecycleOwner = this@FavoriteTvShowFragment

        viewModel = ViewModelProviders.of(this, Injection.provideViewModelFactory(requireContext()))
            .get(FavoriteViewModel::class.java)

        binding.favMoviesRV.apply {
            adapter = adapterList
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
        }

        viewModel.favTvShow.observe(this, Observer<PagedList<ResultsData>> {
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
