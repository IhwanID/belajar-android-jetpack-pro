package id.ihwan.jetpackpro.movies

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ihwan.jetpackpro.R

class MoviesAdapter(
        private val context: Context,
        private val items: List<Movies>,
        private val listener: (Movies) -> Unit
) : RecyclerView.Adapter<MoviesAdapter.MoviesViedHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViedHolder {
        return MoviesViedHolder(LayoutInflater.from(context).inflate(R.layout.list_item_movies, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MoviesViedHolder, position: Int) {
        holder.bind(items[position], listener)
    }


    class MoviesViedHolder(view : View) : RecyclerView.ViewHolder(view) {

        fun bind(items: Movies, listener: (Movies) -> Unit){

        }

    }
}
