package id.ihwan.jetpackpro.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData
import id.ihwan.jetpackpro.databinding.ListItemMoviesBinding

class MoviesPagedListAdapter(val onClick: (ResultsData) -> Unit): PagedListAdapter<ResultsData,MoviesPagedListAdapter.MoviesViewHolder >(DIFF_CALLBACK){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemMoviesBinding.inflate(inflater, parent, false)
        return MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = getItem(position)
        holder.apply {
            movie?.let {data ->
                bind(data)
                itemView.setOnClickListener { onClick(data) }
            }
        }
    }

    companion object{
        private val DIFF_CALLBACK = object: DiffUtil.ItemCallback<ResultsData>(){
            override fun areContentsTheSame(oldItem: ResultsData, newItem: ResultsData): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areItemsTheSame(oldItem: ResultsData, newItem: ResultsData): Boolean {
                return oldItem == newItem
            }
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