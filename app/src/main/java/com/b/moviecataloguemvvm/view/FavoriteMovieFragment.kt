package com.b.moviecataloguemvvm.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.b.moviecataloguemvvm.R
import com.b.moviecataloguemvvm.adapter.FavoriteMovieAdapter
import com.b.moviecataloguemvvm.viewmodel.MovieViewModel
import com.b.moviecataloguemvvm.viewmodel.ViewModelFactory
import com.b.moviecataloguemvvm.vo.Status.*
import kotlinx.android.synthetic.main.fragment_favorite_movie.*


class FavoriteMovieFragment : Fragment() {

    private val movieViewModel by lazy {
        val viewModelFactory= activity?.application?.let { ViewModelFactory.getInstance(it) }
        ViewModelProviders.of(this,viewModelFactory).get(MovieViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val movieAdapter = FavoriteMovieAdapter(context)
        movieViewModel.getMoviesPaged.observe(viewLifecycleOwner, Observer { response ->

            if (response != null) {
                when (response.status) {
                    LOADING -> {

                    }
                    SUCCESS -> {
                        favorite_movie_progress_bar.visibility = View.GONE
                        movieAdapter.submitList(response.data)
                        movieAdapter.notifyDataSetChanged()
                    }
                    ERROR -> {
                        favorite_movie_progress_bar.visibility = View.GONE
                        Toast.makeText(context, getString(R.string.error), Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

        rv_favorite_movie.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = movieAdapter
        }
    }

}
