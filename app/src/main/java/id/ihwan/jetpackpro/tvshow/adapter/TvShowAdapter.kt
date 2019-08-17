package id.ihwan.jetpackpro.tvshow.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ihwan.jetpackpro.databinding.ListItemTvshowBinding
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData

class TvShowAdapter(val onClick: (ResultsData) -> Unit) : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {

    private var items: List<ResultsData> = emptyList()

    fun loadData(items: List<ResultsData>) {
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
        val tvShow = items[position]
        holder.apply {
            bind(tvShow)
            itemView.setOnClickListener { onClick(tvShow) }
        }

    }

    class TvShowViewHolder(private val binding: ListItemTvshowBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(items: ResultsData) {
            binding.apply {
                model= items
                executePendingBindings()
            }
        }

    }
}