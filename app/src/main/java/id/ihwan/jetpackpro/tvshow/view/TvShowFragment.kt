package id.ihwan.jetpackpro.tvshow.view


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
import id.ihwan.jetpackpro.R
import id.ihwan.jetpackpro.databinding.FragmentTvShowBinding
import id.ihwan.jetpackpro.home.HomeViewModel
import id.ihwan.jetpackpro.tvshow.model.TvShow
import id.ihwan.jetpackpro.tvshow.adapter.TvShowAdapter

class TvShowFragment : Fragment() {


    private val viewModel by lazy {
        ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }

    private val tvShowAdapter: TvShowAdapter by lazy {
        TvShowAdapter{Log.d("", it.overview)}
    }

    lateinit var data: List<TvShow>
    lateinit var binding: FragmentTvShowBinding

    companion object {
        fun newInstance(): TvShowFragment {
            return TvShowFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movies, container, false)
        binding.lifecycleOwner = this@TvShowFragment

        binding.tvShowRecyclerView.apply {
            adapter = tvShowAdapter
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
        }

        viewModel.getMovies()
        viewModel.tvShow.observe(this, Observer {
            tvShowAdapter.loadData(it)
        })

        return binding.root
    }

}
