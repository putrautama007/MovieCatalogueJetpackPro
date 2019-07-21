package com.b.moviecataloguemvvm.model.repository.remote

import android.app.Application
import android.util.Log
import com.b.moviecataloguemvvm.model.FeaturedCrew
import com.b.moviecataloguemvvm.model.MovieModel
import com.b.moviecataloguemvvm.model.TvShowModel
import com.google.gson.Gson
import org.json.JSONObject
import java.io.IOException

class Helper(private val application: Application) {

    private fun toString(fileName: String): String? {
        return try {
            val assets = application.assets.open(fileName)
            val stringBuffer = ByteArray(assets.available())
            assets.read(stringBuffer)
            assets.close()
            String(stringBuffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovieData(): List<MovieModel> {
        val movieList = ArrayList<MovieModel>()

        try {
            val response = JSONObject(toString("movies.json"))
            val movieListResult = response.getJSONArray("result")
            for (list in 0 until movieListResult.length()) {
                val movieItem = movieListResult.getJSONObject(list)
                Log.d("movieItem", movieItem.toString())
                val movieId = movieItem.getInt("movieId")
                val movieTitle = movieItem.getString("movieTitle")
                val movieDescription = movieItem.getString("movieDescription")
                val moviePoster = movieItem.getString("moviePoster")
                val movieRelease = movieItem.getString("movieRelease")
                val movieRating = movieItem.getString("movieRating")
                val movieTrailer = movieItem.getString("movieTrailer")
                val featuredCrew = movieItem.getString("featuredCrew")
                val featuredCrewList = Gson().fromJson(featuredCrew,Array<FeaturedCrew>::class.java).toList()
                val movieObject = MovieModel(
                    movieId, movieTitle, movieDescription, moviePoster
                    , movieRelease, movieRating, movieTrailer, featuredCrewList
                )
                movieList.add(movieObject)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return movieList
    }

    fun loadTvShowsData(): List<TvShowModel> {
        val tvShowsList = ArrayList<TvShowModel>()

        try {
            val response = JSONObject(toString("tvshows.json"))
            val tvShowsListResult = response.getJSONArray("result")
            for (list in 0 until tvShowsListResult.length()) {
                val tvShowsItem = tvShowsListResult.getJSONObject(list)
                val tvShowsId = tvShowsItem.getInt("tvShowId")
                val tvShowsTitle = tvShowsItem.getString("tvShowTitle")
                val tvShowsDescription = tvShowsItem.getString("tvShowDescription")
                val tvShowsPoster = tvShowsItem.getString("tvShowPoster")
                val tvShowsRelease = tvShowsItem.getString("tvShowRelease")
                val tvShowsRating = tvShowsItem.getString("tvShowRating")
                val tvShowsTrailer = tvShowsItem.getString("tvShowTrailer")
                val featuredCrew = tvShowsItem.getString("featuredCrew")
                val featuredCrewList = Gson().fromJson(featuredCrew,Array<FeaturedCrew>::class.java).toList()
                val tvShowsObject = TvShowModel(
                    tvShowsId, tvShowsTitle, tvShowsDescription, tvShowsPoster
                    , tvShowsRelease, tvShowsRating, tvShowsTrailer, featuredCrewList
                )
                tvShowsList.add(tvShowsObject)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return tvShowsList
    }
}