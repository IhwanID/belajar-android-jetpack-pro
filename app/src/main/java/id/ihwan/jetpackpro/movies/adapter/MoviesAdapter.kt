package id.ihwan.jetpackpro.movies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ihwan.jetpackpro.databinding.ListItemMoviesBinding
import id.ihwan.jetpackpro.network.response.ResultsMovie


class MoviesAdapter(val onClick: (ResultsMovie) -> Unit) : RecyclerView.Adapter<MoviesAdapter.MoviesViedHolder>() {

    private var items: List<ResultsMovie> = emptyList()

    fun loadData(items: List<ResultsMovie>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViedHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemMoviesBinding.inflate(inflater, parent, false)
        return MoviesViedHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MoviesViedHolder, position: Int) {
        holder.bind(items[position])
    }


    class MoviesViedHolder(private val binding: ListItemMoviesBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(items: ResultsMovie) {
            binding.apply {
                model= items
                executePendingBindings()
            }
        }

    }
}
