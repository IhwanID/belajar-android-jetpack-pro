package id.ihwan.jetpackpro.home.movies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ihwan.jetpackpro.databinding.ListItemMoviesBinding
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData


class MoviesAdapter(val onClick: (ResultsData) -> Unit) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    private var items: List<ResultsData> = emptyList()

    fun loadData(items: List<ResultsData>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemMoviesBinding.inflate(inflater, parent, false)
        return MoviesViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = items[position]
        holder.apply {
            bind(movie)
            itemView.setOnClickListener { onClick(movie) }
        }

    }


    class MoviesViewHolder(private val binding: ListItemMoviesBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(items: ResultsData) {
            binding.apply {
                model= items
                executePendingBindings()
            }
        }

    }
}
