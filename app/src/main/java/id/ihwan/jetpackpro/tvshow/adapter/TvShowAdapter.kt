package id.ihwan.jetpackpro.tvshow.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import id.ihwan.jetpackpro.R
import id.ihwan.jetpackpro.tvshow.model.TvShow
import id.ihwan.jetpackpro.tvshow.view.DetailTvShowActivity
import kotlinx.android.synthetic.main.list_item_tvshow.view.*

class TvShowAdapter(private val context: Context?) : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {


    private var items: List<TvShow> = emptyList()

    fun loadData(items: List<TvShow>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        return TvShowViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.list_item_tvshow,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.apply {
            bind(items[position])
            itemView.detailButton.setOnClickListener {
                val intent = Intent(context, DetailTvShowActivity::class.java)
                intent.putExtra("detail", items[position].id)
                context?.startActivity(intent)
            }
        }
    }

    class TvShowViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(items: TvShow) {
            items.image.let {
                Picasso.get().load(it).into(itemView.imageTvShow)
            }
            itemView.titleTvShow.text = items.title
        }

    }
}