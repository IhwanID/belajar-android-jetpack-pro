package id.ihwan.jetpackpro.tvshow

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import id.ihwan.jetpackpro.R
import kotlinx.android.synthetic.main.list_item_tvshow.view.*

class TvShowAdapter(private val context: Context?)
    : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {


    private var items: List<TvShow> = emptyList()

    fun loadData(items: List<TvShow>){
        this.items =items
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        return TvShowViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_tvshow, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class TvShowViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(items: TvShow){
            items.image.let {
                Picasso.get().load(it).into(itemView.imageTvShow)
            }
            itemView.titleTvShow.text = items.title
        }

    }
}