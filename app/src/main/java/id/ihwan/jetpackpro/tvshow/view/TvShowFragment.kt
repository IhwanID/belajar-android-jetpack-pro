package id.ihwan.jetpackpro.tvshow.view


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
import id.ihwan.jetpackpro.R
import id.ihwan.jetpackpro.databinding.FragmentTvShowBinding
import id.ihwan.jetpackpro.home.HomeViewModel
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData
import id.ihwan.jetpackpro.tvshow.adapter.TvShowAdapter
import id.ihwan.jetpackpro.detail.DetailActivity

class TvShowFragment : Fragment() {


    private val viewModel by lazy {
        ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }

    private val tvShowAdapter: TvShowAdapter by lazy {
        TvShowAdapter{
            goToDetailTvShow(it)
        }
    }

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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tv_show, container, false)
        binding.lifecycleOwner = this@TvShowFragment

        binding.tvShowRecyclerView.apply {
            adapter = tvShowAdapter
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
        }

        viewModel.tvShow.observe(this, Observer {
            tvShowAdapter.loadData(it)
        })

        return binding.root
    }

    private fun goToDetailTvShow(tvShow: ResultsData){
        val i = Intent(activity, DetailActivity::class.java)
        i.putExtra("id", tvShow)
        startActivity(i)
    }
}
