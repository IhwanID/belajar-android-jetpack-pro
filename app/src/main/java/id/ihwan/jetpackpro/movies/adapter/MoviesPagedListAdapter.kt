package id.ihwan.jetpackpro.movies.adapter

import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData
import id.ihwan.jetpackpro.home.HomeViewModel

class MoviesPagedListAdapter: PagedListAdapter<ResultsData, HomeViewModel>(DIFF_CALLBACK){
    override fun onBindViewHolder(holder: HomeViewModel, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object{
        private val DIFF_CALLBACK = object: DiffUtil.ItemCallback<ResultsData>{
            override fun areContentsTheSame(oldItem: ResultsData, newItem: ResultsData): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun areItemsTheSame(oldItem: ResultsData, newItem: ResultsData): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
    }
}