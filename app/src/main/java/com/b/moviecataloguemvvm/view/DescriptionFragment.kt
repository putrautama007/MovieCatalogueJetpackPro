package com.b.moviecataloguemvvm.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.b.moviecataloguemvvm.R
import com.b.moviecataloguemvvm.model.TvShowModel
import com.b.moviecataloguemvvm.model.repository.remote.ItemList
import com.b.moviecataloguemvvm.model.repository.remote.TvShowsDetail
import com.b.moviecataloguemvvm.viewmodel.MovieViewModel
import com.b.moviecataloguemvvm.viewmodel.TvShowViewModel
import com.b.moviecataloguemvvm.viewmodel.ViewModelFactory
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_description.*

class DescriptionFragment : Fragment() {

    private val movieDescriptionViewModel by lazy {
        val viewModelFactory= activity?.application?.let { ViewModelFactory.getInstance() }
        ViewModelProviders.of(this,viewModelFactory).get(MovieViewModel::class.java)
    }

    private val tvShowDescriptionViewModel by lazy {
        val viewModelFactory= activity?.application?.let { ViewModelFactory.getInstance() }
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

        if (activity?.intent?.getStringExtra("movie") != null){
            movieDescriptionViewModel.getMovieDetail(activity?.intent?.getStringExtra("movie")!!)
                .observe(viewLifecycleOwner, Observer {
                    loadDataMovie(it)
            })
        }else{
            tvShowDescriptionViewModel.getTvShowDetail(activity?.intent?.getStringExtra("tvShow")!!)
                .observe(viewLifecycleOwner, Observer {
                    loadDataTvShow(it)
                })
        }

    }

    private fun loadDataMovie(movie : ItemList?){
       tv_description.text = movie?.overview
    }

    private fun loadDataTvShow(tvShow: TvShowsDetail?){
        tv_description.text = tvShow?.overview
    }

}
