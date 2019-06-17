package id.ihwan.jetpackpro

import id.ihwan.jetpackpro.movies.Movies
import id.ihwan.jetpackpro.tvshow.TvShow

object DataDummy {

    fun generateDummyMovies(): List<Movies> {

        val listMovies = listOf(
            Movies("Alita", "lorem ipsum", R.drawable.poster_a_start_is_born, "17 Agustus 1945", "9.5"),
            Movies("Aquaman", "lorem ipsum", R.drawable.poster_a_start_is_born, "17 Agustus 1945", "9.5"),
            Movies("bohemian", "lorem ipsum", R.drawable.poster_a_start_is_born, "17 Agustus 1945", "9.5"),
            Movies("creed", "lorem ipsum", R.drawable.poster_a_start_is_born, "17 Agustus 1945", "9.5")
        )

        return listMovies
    }

    fun generateDummyTvShow(): List<TvShow> {

        val listTvShow = listOf(
            TvShow("Alita", "lorem ipsum", R.drawable.poster_a_start_is_born, "17 Agustus 1945", "9.5"),
            TvShow("Aquaman", "lorem ipsum", R.drawable.poster_a_start_is_born, "17 Agustus 1945", "9.5"),
            TvShow("bohemian", "lorem ipsum", R.drawable.poster_a_start_is_born, "17 Agustus 1945", "9.5"),
            TvShow("creed", "lorem ipsum", R.drawable.poster_a_start_is_born, "17 Agustus 1945", "9.5")
        )

        return listTvShow
    }

}