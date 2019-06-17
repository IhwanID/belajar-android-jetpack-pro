package id.ihwan.jetpackpro.movies


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import id.ihwan.jetpackpro.HomeViewModel
import id.ihwan.jetpackpro.R
import kotlinx.android.synthetic.main.fragment_movies.*


class MoviesFragment : Fragment() {

    companion object {
        fun newInstance(): MoviesFragment {
            return MoviesFragment()
        }
    }

    lateinit var data: List<Movies>

    private val viewModel by lazy { ViewModelProviders.of(this).get(HomeViewModel::class.java) }

    private val adapter: MoviesAdapter by lazy { MoviesAdapter(context) }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        data = viewModel.movies

        moviesRecyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = this@MoviesFragment.adapter
            setHasFixedSize(true)
        }

        adapter.loadData(data)
    }
}
