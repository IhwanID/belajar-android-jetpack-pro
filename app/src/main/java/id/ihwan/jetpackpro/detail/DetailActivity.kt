package id.ihwan.jetpackpro.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import id.ihwan.jetpackpro.R
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData
import id.ihwan.jetpackpro.databinding.ActivityDetailBinding
import id.ihwan.jetpackpro.utils.Injection

class DetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailBinding

    private val viewModel by lazy {
         ViewModelProviders.of(this, Injection.provideViewModelFactory(this)).get(DetailViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        val data = intent.getParcelableExtra<ResultsData>("liveDataMovies")
        val isFavorite = intent.getBooleanExtra("isFromFavorite", false)

        supportActionBar?.title = data.getRealName()

        viewModel._detail.postValue(data)
        
        viewModel.detail.observe(this, Observer {
            binding.model = it
        })

        binding.favoriteButton.apply {
            when(isFavorite){
                true -> {
                    text = context.getString(R.string.unfavorite)
                    setOnClickListener { viewModel.deleteFromFavorite(data) }
                }
                false -> {
                    text = context.getString(R.string.add_to_favorite)
                    setOnClickListener { viewModel.addToFavorite(data) }
                }
            }
        }
    }
}
