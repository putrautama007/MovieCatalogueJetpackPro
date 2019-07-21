package com.b.moviecataloguemvvm.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders

import com.b.moviecataloguemvvm.R
import com.b.moviecataloguemvvm.model.MovieModel
import com.b.moviecataloguemvvm.model.TvShowModel
import com.b.moviecataloguemvvm.viewmodel.TvShowViewModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_description.*

class DescriptionFragment : Fragment() {

    private val tvShowViewModel by lazy {
        ViewModelProviders.of(this).get(TvShowViewModel::class.java)
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
            loadDataMovie(Gson().fromJson(activity?.intent?.getStringExtra("movie"),
                MovieModel::class.java))
        }else{
            loadDataTvShow(Gson().fromJson(activity?.intent?.getStringExtra("tvShow"),
                TvShowModel::class.java))
        }

    }

    private fun loadDataMovie(movie : MovieModel?){
       tv_description.text = movie?.movieDescription
    }

    private fun loadDataTvShow(tvShow: TvShowModel?){
        tv_description.text = tvShow?.tvShowDescription
    }

}
