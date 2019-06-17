package id.ihwan.jetpackpro.utils

import id.ihwan.jetpackpro.R
import id.ihwan.jetpackpro.movies.Movies
import id.ihwan.jetpackpro.tvshow.TvShow



object DataDummy {

    fun generateDummyMovies(): List<Movies> {

        return listOf(
                Movies(1,"A Start Is Born", "lorem ipsum", R.drawable.poster_a_start_is_born, "17 Agustus 1945", "9.5"),
                Movies(2,"Alita : Battle Angel", "lorem ipsum", R.drawable.poster_alita, "17 Agustus 1945", "9.5"),
                Movies(3,"Aquaman", "lorem ipsum", R.drawable.poster_aquaman, "17 Agustus 1945", "9.5"),
                Movies(4,"Bohemian Rhapsody", "lorem ipsum", R.drawable.poster_bohemian, "17 Agustus 1945", "9.5"),
                Movies(5,"Cold Persuit", "lorem ipsum", R.drawable.poster_cold_persuit, "17 Agustus 1945", "9.5"),
                Movies(6,"Creed II", "lorem ipsum", R.drawable.poster_creed, "17 Agustus 1945", "9.5"),
                Movies(7,"The Crimes Of Grindelwald", "lorem ipsum", R.drawable.poster_crimes, "17 Agustus 1945", "9.5"),
                Movies(8,"Glass", "lorem ipsum", R.drawable.poster_glass, "17 Agustus 1945", "9.5"),
                Movies(9,"How To Train Your Dragon : The Hidden World", "lorem ipsum", R.drawable.poster_how_to_train, "17 Agustus 1945", "9.5"),
                Movies(10,"Avengers : Infinity War", "lorem ipsum", R.drawable.poster_infinity_war, "17 Agustus 1945", "9.5"),
                Movies(11,"Marry Queen of Scots", "lorem ipsum", R.drawable.poster_marry_queen, "17 Agustus 1945", "9.5"),
                Movies(12,"Master Z", "lorem ipsum", R.drawable.poster_master_z, "17 Agustus 1945", "9.5"),
                Movies(13,"Mortal Engines", "lorem ipsum", R.drawable.poster_mortal_engines, "17 Agustus 1945", "9.5"),
                Movies(14,"Overlord", "lorem ipsum", R.drawable.poster_overlord, "17 Agustus 1945", "9.5"),
                Movies(15,"Ralph Breaks The Internet", "lorem ipsum", R.drawable.poster_ralph, "17 Agustus 1945", "9.5"),
                Movies(16,"Robin Hood", "lorem ipsum", R.drawable.poster_robin_hood, "17 Agustus 1945", "9.5"),
                Movies(17,"Serenity", "lorem ipsum", R.drawable.poster_serenity, "17 Agustus 1945", "9.5"),
                Movies(18,"Spider-Man : Into The Spider-Verse", "lorem ipsum", R.drawable.poster_spiderman, "17 Agustus 1945", "9.5"),
                Movies(19,"T34", "lorem ipsum", R.drawable.poster_t34, "17 Agustus 1945", "9.5")
                )
    }

    fun generateDummyTvShow(): List<TvShow> {

        return listOf(
                TvShow("Alita", "lorem ipsum", R.drawable.poster_a_start_is_born, "17 Agustus 1945", "9.5"),
                TvShow("Aquaman", "lorem ipsum", R.drawable.poster_a_start_is_born, "17 Agustus 1945", "9.5"),
                TvShow("bohemian", "lorem ipsum", R.drawable.poster_a_start_is_born, "17 Agustus 1945", "9.5"),
                TvShow("creed", "lorem ipsum", R.drawable.poster_a_start_is_born, "17 Agustus 1945", "9.5")
        )
    }

    fun getMoviesById(id : Int) : Movies? {

        for (i in 0 until generateDummyMovies().size) {
            var movies : Movies = generateDummyMovies()[i]
            if (movies.id == id) {
                return movies
            }
        }
        return null
    }

}