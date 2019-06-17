package id.ihwan.jetpackpro.tvshow


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import id.ihwan.jetpackpro.HomeViewModel
import id.ihwan.jetpackpro.R
import kotlinx.android.synthetic.main.fragment_tv_show.*


class TvShowFragment : Fragment() {


    private val viewModel by lazy { ViewModelProviders.of(this).get(HomeViewModel::class.java) }

    private val adapter: TvShowAdapter by lazy { TvShowAdapter(context) }

    lateinit var data: List<TvShow>

    companion object {
        fun newInstance(): TvShowFragment {
            return TvShowFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        data = viewModel.tvShow

        tvShowRecyclerView.apply {
            layoutManager = GridLayoutManager(context,2)
            adapter = this@TvShowFragment.adapter
            setHasFixedSize(true)
        }

        adapter.loadData(data)

    }


}
