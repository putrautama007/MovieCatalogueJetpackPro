package com.b.moviecataloguemvvm.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.b.moviecataloguemvvm.R
import com.b.moviecataloguemvvm.model.local.entity.MovieModel
import com.b.moviecataloguemvvm.model.local.entity.TvShowModel
import com.b.moviecataloguemvvm.viewmodel.MovieViewModel
import com.b.moviecataloguemvvm.viewmodel.TvShowViewModel
import com.b.moviecataloguemvvm.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_description.*

class DescriptionFragment : Fragment() {


    private val movieDetailViewModel by lazy {
        val viewModelFactory= activity?.application?.let { ViewModelFactory.getInstance(it) }
        ViewModelProviders.of(this,viewModelFactory).get(MovieViewModel::class.java)
    }

    private val tvShowDetailViewModel by lazy {
        val viewModelFactory= activity?.application?.let { ViewModelFactory.getInstance(it) }
        ViewModelProviders.of(this,viewModelFactory).get(TvShowViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_description, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity?.intent?.getIntExtra("movieId",0) != 0){
            activity?.intent?.getIntExtra("movieId",0)?.let {
                movieDetailViewModel.movieDetail(it).observe(this, Observer {
                    loadDataMovie(it)

                })
            }
        }else{
            tvShowDetailViewModel.tvShowDetail(activity?.intent?.getIntExtra("tvShowId",0)!!).observe(this, Observer {
                loadDataTvShow(it)
            })
        }

    }

    private fun loadDataMovie(movie : MovieModel?){
       tv_description.text = movie?.movieDescription
    }

    private fun loadDataTvShow(tvShow: TvShowModel?){
        tv_description.text = tvShow?.tvShowDescription
    }

}
