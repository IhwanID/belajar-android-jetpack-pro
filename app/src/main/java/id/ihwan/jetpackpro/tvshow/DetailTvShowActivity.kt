package id.ihwan.jetpackpro.tvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.squareup.picasso.Picasso
import id.ihwan.jetpackpro.R
import kotlinx.android.synthetic.main.activity_detail_tv_show.*

class DetailTvShowActivity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProviders.of(this).get(DetailTvShowViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tv_show)

        val id = intent.getIntExtra("detail", 0)
        initView(viewModel.detailTvShow(id))
    }

    fun initView(tvShow: TvShow?){
        tvShow?.image.let {
            Picasso.get().load(it as Int).into(imageDetail)
        }

        titleDetail.text = tvShow?.title
        descriptionDetail.text = tvShow?.description
    }
}
