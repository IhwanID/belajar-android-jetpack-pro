package id.ihwan.jetpackpro.tvshow.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ihwan.jetpackpro.databinding.ListItemTvshowBinding
import id.ihwan.jetpackpro.network.response.ResultsTvShow

class TvShowAdapter(val onClick: (ResultsTvShow) -> Unit) : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {


    private var items: List<ResultsTvShow> = emptyList()

    fun loadData(items: List<ResultsTvShow>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemTvshowBinding.inflate(inflater, parent, false)
        return TvShowViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class TvShowViewHolder(private val binding: ListItemTvshowBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(items: ResultsTvShow) {
            binding.apply {
                model= items
                executePendingBindings()
            }
        }

    }
}