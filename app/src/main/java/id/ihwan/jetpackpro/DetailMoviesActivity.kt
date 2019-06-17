package id.ihwan.jetpackpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.squareup.picasso.Picasso
import id.ihwan.jetpackpro.movies.Movies
import kotlinx.android.synthetic.main.activity_detail_movie.*

class DetailMoviesActivity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProviders.of(this).get(DetailMoviesViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        val id = intent.getIntExtra("detail", 0)
        initView(viewModel.detailMovies(id))

    }

    fun initView(movie: Movies?){
        movie?.image.let {
            Picasso.get().load(it as Int).into(imageDetail)
        }

        titleDetail.text = movie?.title
        descriptionDetail.text = movie?.description
    }
}
