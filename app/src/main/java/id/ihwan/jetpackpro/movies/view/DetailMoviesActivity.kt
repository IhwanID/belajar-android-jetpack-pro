package id.ihwan.jetpackpro.movies.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import id.ihwan.jetpackpro.R
import id.ihwan.jetpackpro.databinding.ActivityDetailMovieBinding

class DetailMoviesActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_movie)

        binding.model = intent.getParcelableExtra("data")
    }

}
