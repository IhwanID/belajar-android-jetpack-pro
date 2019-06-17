package id.ihwan.jetpackpro.tvshow

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ihwan.jetpackpro.R

class TvShowAdapter(private val context: Context,
                    private val items: List<TvShow>,
                    private val listener: (TvShow) -> Unit)
    : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        return TvShowViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_tvshow, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }

    class TvShowViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(items: TvShow, listener: (TvShow) -> Unit){

        }

    }
}