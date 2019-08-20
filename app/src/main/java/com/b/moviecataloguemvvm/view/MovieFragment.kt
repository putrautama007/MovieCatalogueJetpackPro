package com.b.moviecataloguemvvm.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager

import com.b.moviecataloguemvvm.R
import com.b.moviecataloguemvvm.adapter.MovieAdapter
import com.b.moviecataloguemvvm.model.local.entity.MovieModel
import com.b.moviecataloguemvvm.viewmodel.MovieViewModel
import com.b.moviecataloguemvvm.viewmodel.ViewModelFactory
import com.b.moviecataloguemvvm.vo.Status.*
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment() {

    private var movieList : List<MovieModel> = listOf()

    private val movieViewModel by lazy {
        val viewModelFactory= activity?.application?.let { ViewModelFactory.getInstance(it) }
        ViewModelProviders.of(this,viewModelFactory).get(MovieViewModel::class.java)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val movieAdapter = MovieAdapter(context)
        movieViewModel.movies.observe(viewLifecycleOwner, Observer {
            movie_progress_bar.visibility = View.GONE
            movieList= it
            movieAdapter.getList(movieList)

            getMovies()
        })

        rv_movie.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = movieAdapter
        }

    }

    private fun getMovies() {
        movieViewModel.getMovies.observe(viewLifecycleOwner, Observer {

            when (it.status) {
                SUCCESS -> {
                    movie_progress_bar.visibility = View.GONE
                    if (it.data.isNullOrEmpty()) {
                        movieViewModel.insertMovies(movieList)
                    }
                }
                ERROR -> {
                    movie_progress_bar.visibility = View.GONE
                }
                LOADING -> {
                }
            }
        })
    }
}
