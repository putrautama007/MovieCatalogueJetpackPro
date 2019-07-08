package com.b.moviecataloguemvvm.viewmodel.movies

import com.b.moviecataloguemvvm.R
import com.b.moviecataloguemvvm.model.FeaturedCrew
import com.b.moviecataloguemvvm.model.MovieModel
import com.b.moviecataloguemvvm.viewmodel.MovieViewModel
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test


class MovieViewModelTest{
    private var viemModel: MovieViewModel? = null
    private var data : MovieModel? = null

    @Before
    fun setUp() {
        viemModel = MovieViewModel()
        data = MovieModel(
            1,
            "A Star Is Born",
            "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
            R.drawable.movie_a_start_is_born,
            "October 3, 2018",
            "75",
            "https://youtu.be/nSbzyEJ8X9E",
            listOf(
                FeaturedCrew(
                    "Bradley Cooper",
                    "Director, Screenplay"
                ),
                FeaturedCrew(
                    "Will Fetters",
                    "Screenplay"
                ),
                FeaturedCrew(
                    "Eric Roth",
                    "Screenplay"
                ),
                FeaturedCrew(
                    "Robert Carson",
                    "Story"
                ),
                FeaturedCrew(
                    "William A. Wellman",
                    "Story"
                )
            )
        )
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getResult() {
        assertEquals(19, viemModel?.movies?.size)
        assertEquals(data?.movieId, viemModel?.movieDetail(1)?.movieId)
        assertEquals(data?.movieTitle, viemModel?.movieDetail(1)?.movieTitle)
        assertEquals(data?.movieDescription, viemModel?.movieDetail(1)?.movieDescription)
        assertEquals(data?.moviePoster, viemModel?.movieDetail(1)?.moviePoster)
        assertEquals(data?.movieRating, viemModel?.movieDetail(1)?.movieRating)
        assertEquals(data?.movieRelease, viemModel?.movieDetail(1)?.movieRelease)
        assertEquals(data?.featuredCrew, viemModel?.movieDetail(1)?.featuredCrew)
    }
}