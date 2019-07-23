package id.ihwan.jetpackpro.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

    @BindingAdapter("imageUrl")
    fun bindImage(imgView: ImageView, imgUrl: String?) {
        imgUrl?.let {
            Picasso.get()
                .load("https://image.tmdb.org/t/p/w500/$imgUrl")
                .into(imgView)
        }
    }
