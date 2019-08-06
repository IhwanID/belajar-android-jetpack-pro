package id.ihwan.jetpackpro.tvshow.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import id.ihwan.jetpackpro.R
import id.ihwan.jetpackpro.databinding.ActivityDetailTvShowBinding
import id.ihwan.jetpackpro.tvshow.viewmodel.DetailTvShowViewModel

class DetailTvShowActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailTvShowBinding

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(DetailTvShowViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_tv_show)
        val id = intent.getIntExtra("id", 0)
        viewModel.getDetail(id)
        viewModel.detailTvShow.observe(this, Observer {
            binding.model = it
        })

    }


}
