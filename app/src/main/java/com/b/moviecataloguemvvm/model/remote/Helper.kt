package com.b.moviecataloguemvvm.model.remote

import android.app.Application
import com.b.moviecataloguemvvm.model.remote.response.MovieModelResponse
import com.b.moviecataloguemvvm.model.remote.response.TvShowModelResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class Helper(private val application: Application) {
    private fun parsingDataToString(data: String): String? {
        return try {
            val `is` = application.assets.open(data)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }

    }

    fun getMovieList(): List<MovieModelResponse> {
        val listMovies = ArrayList<MovieModelResponse>()

        try {
            val responseObject = JSONObject(parsingDataToString("movies.json"))
            val listArray = responseObject.getJSONArray("result")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val movieId = movie.getInt("movieId")
                val movieTitle = movie.getString("movieTitle")
                val movieDescription = movie.getString("movieDescription")
                val moviePoster = movie.getString("moviePoster")
                val movieRelease = movie.getString("movieRelease")
                val movieRating = movie.getString("movieRating")
                val movieTrailer = movie.getString("movieTrailer")
                val featuredCrew = movie.getString("featuredCrew")

                val movieResponse = MovieModelResponse(
                    movieId = movieId,
                    movieTitle = movieTitle,
                    movieDescription = movieDescription,
                    moviePoster = moviePoster,
                    movieRelease = movieRelease,
                    movieRating = movieRating,
                    movieTrailer = movieTrailer,
                    featuredCrew = featuredCrew
                )
                listMovies.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return listMovies
    }

    fun getMovieById(id: Int): MovieModelResponse {
        val movieData = String.format("movie_%s.json", id)
        var movie = MovieModelResponse()
        try {

            val result = parsingDataToString(movieData)
            if (result != null) {
                val responseObject = JSONObject(result)
                val movieId = responseObject.getInt("movieId")
                val movieTitle = responseObject.getString("movieTitle")
                val movieDescription = responseObject.getString("movieDescription")
                val moviePoster = responseObject.getString("moviePoster")
                val movieRelease = responseObject.getString("movieRelease")
                val movieRating = responseObject.getString("movieRating")
                val movieTrailer = responseObject.getString("movieTrailer")
                val featuredCrew = responseObject.getString("featuredCrew")
                movie = MovieModelResponse(
                    movieId = movieId,
                    movieTitle = movieTitle,
                    movieDescription = movieDescription,
                    moviePoster = moviePoster,
                    movieRelease = movieRelease,
                    movieRating = movieRating,
                    movieTrailer = movieTrailer,
                    featuredCrew = featuredCrew
                )
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return movie
    }

    fun getTvShowList():List<TvShowModelResponse>{
        val listTvShow = ArrayList<TvShowModelResponse>()

        try {
            val responseObject = JSONObject(parsingDataToString("tvshows.json"))
            val listArray = responseObject.getJSONArray("result")
            for (i in 0 until listArray.length()) {
                val tvShows = listArray.getJSONObject(i)

                val tvShowId = tvShows.getInt("tvShowId")
                val tvShowTitle = tvShows.getString("tvShowTitle")
                val tvShowDescription = tvShows.getString("tvShowDescription")
                val tvShowPoster = tvShows.getString("tvShowPoster")
                val tvShowRelease = tvShows.getString("tvShowRelease")
                val tvShowRating = tvShows.getString("tvShowRating")
                val tvShowTrailer = tvShows.getString("tvShowTrailer")
                val featuredCrew = tvShows.getString("featuredCrew")
                val courseResponse = TvShowModelResponse(
                    tvShowId = tvShowId,
                    tvShowTitle = tvShowTitle,
                    tvShowDescription = tvShowDescription,
                    tvShowPoster = tvShowPoster,
                    tvShowRelease = tvShowRelease,
                    tvShowRating = tvShowRating,
                    tvShowTrailer = tvShowTrailer,
                    featuredCrew = featuredCrew
                )
                listTvShow.add(courseResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return listTvShow
    }

    fun getTvShowById(id: Int): TvShowModelResponse {
        val tvShowData = String.format("tvshow_%s.json", id)
        var tvShow = TvShowModelResponse()
        try {

            val result = parsingDataToString(tvShowData)
            if (result != null) {
                val responseObject = JSONObject(result)
                val tvShowId = responseObject.getInt("tvShowId")
                val tvShowTitle = responseObject.getString("tvShowTitle")
                val tvShowDescription = responseObject.getString("tvShowDescription")
                val tvShowPoster = responseObject.getString("tvShowPoster")
                val tvShowRelease = responseObject.getString("tvShowRelease")
                val tvShowRating = responseObject.getString("tvShowRating")
                val tvShowTrailer = responseObject.getString("tvShowTrailer")
                val featuredCrew = responseObject.getString("featuredCrew")
                tvShow = TvShowModelResponse(
                    tvShowId = tvShowId,
                    tvShowTitle = tvShowTitle,
                    tvShowDescription = tvShowDescription,
                    tvShowPoster = tvShowPoster,
                    tvShowRelease = tvShowRelease,
                    tvShowRating = tvShowRating,
                    tvShowTrailer = tvShowTrailer,
                    featuredCrew = featuredCrew
                )
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return tvShow
    }
}