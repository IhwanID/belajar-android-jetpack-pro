package id.ihwan.jetpackpro.utils

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import id.ihwan.jetpackpro.movies.adapter.MoviesAdapter
import id.ihwan.jetpackpro.network.response.ResultsMovie



    @BindingAdapter("imageUrl")
    fun bindImage(imgView: ImageView, imgUrl: String?) {
        imgUrl?.let {
            Picasso.get()
                .load("https://image.tmdb.org/t/p/w500/$imgUrl")
                .into(imgView)
        }
    }

    @BindingAdapter("listData")
    fun bindRecyclerView(recyclerView: RecyclerView, data: List<ResultsMovie>?) {
        val adapter = recyclerView.adapter as MoviesAdapter
        data?.let { adapter.loadData(it) }
    }
