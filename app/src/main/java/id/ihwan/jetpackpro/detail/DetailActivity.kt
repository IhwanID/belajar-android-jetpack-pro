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
         ViewModelProviders.of(this, Injection.provideViewModelFactory(this))
            .get(DetailViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        val id = intent.getParcelableExtra<ResultsData>("id")

        viewModel._detail.postValue(id)
        viewModel.detail.observe(this, Observer {
            binding.model = it
        })

//        binding.favoriteButton.apply {
//            when(id.isFavorite == 0){
//                true -> {
//                    text = "Add to Favorite"
//                    setOnClickListener {
//                        id.id?.let { it1 -> viewModel.addToFavorite(it1) }
//                    }
//
//                }
//                false -> {
//                    text = "UnFavorite"
//                    setOnClickListener {
//                        id.id?.let { it1 -> viewModel.deteleFromFavorite(it1) }
//                    }
//
//                }
//            }
//
//        }
    }
}
