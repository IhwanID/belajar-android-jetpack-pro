package id.ihwan.jetpackpro.movies.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import id.ihwan.jetpackpro.R
import id.ihwan.jetpackpro.movies.model.Movies
import id.ihwan.jetpackpro.movies.view.DetailMoviesActivity
import kotlinx.android.synthetic.main.list_item_movies.view.*


class MoviesAdapter(private val context: Context?) : RecyclerView.Adapter<MoviesAdapter.MoviesViedHolder>() {

    private var items: List<Movies> = emptyList()

    fun loadData(items: List<Movies>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViedHolder {
        return MoviesViedHolder(
            LayoutInflater.from(context).inflate(
                R.layout.list_item_movies,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MoviesViedHolder, position: Int) {
        holder.bind(items[position])
        holder.itemView.detailButton.setOnClickListener {
            val intent = Intent(context, DetailMoviesActivity::class.java)
            intent.putExtra("detail", items[position].id)
            context?.startActivity(intent)
        }
    }


    class MoviesViedHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(items: Movies) {
            items.image.let {
                Picasso.get().load(it).into(itemView.imageMovies)
            }
            itemView.titleMovies.text = items.title
        }

    }
}
