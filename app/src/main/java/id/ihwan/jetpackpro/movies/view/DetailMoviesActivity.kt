package id.ihwan.jetpackpro.movies.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import id.ihwan.jetpackpro.R
import id.ihwan.jetpackpro.databinding.ActivityDetailMovieBinding
import id.ihwan.jetpackpro.movies.viewmodel.DetailMovieViewModel

class DetailMoviesActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailMovieBinding

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(DetailMovieViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_movie)
        val id = intent.getIntExtra("id", 0)
        viewModel.getDetail(id)
        viewModel.detailMovie.observe(this, Observer {
            binding.model = it
        })

    }

}
