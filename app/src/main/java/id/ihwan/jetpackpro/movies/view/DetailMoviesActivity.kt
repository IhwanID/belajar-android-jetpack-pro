package id.ihwan.jetpackpro.movies.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import id.ihwan.jetpackpro.R
import id.ihwan.jetpackpro.movies.viewmodel.DetailMoviesViewModel

class DetailMoviesActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(DetailMoviesViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        val id = intent.getIntExtra("detail", 0)

    }

}
