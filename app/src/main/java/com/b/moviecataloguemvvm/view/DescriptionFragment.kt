package com.b.moviecataloguemvvm.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager

import com.b.moviecataloguemvvm.R
import com.b.moviecataloguemvvm.model.MovieModel
import com.b.moviecataloguemvvm.model.TvShowModel
import com.b.moviecataloguemvvm.viewmodel.MovieViewModel
import com.b.moviecataloguemvvm.viewmodel.TvShowViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.fragment_description.*

class DescriptionFragment : Fragment() {

    private val movieViewModel by lazy {
        ViewModelProviders.of(this).get(MovieViewModel::class.java)
    }

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

        if (activity?.intent?.getIntExtra("movieId",0) != 0){
            loadDataMovie(activity?.intent?.getIntExtra("movieId",0)?.let { movieViewModel.movieDetail(it) })
        }else{
            loadDataTvShow(tvShowViewModel.tvShowDetail(activity?.intent?.getIntExtra("tvShowId",0)!!))
        }

    }

    private fun loadDataMovie(movie : MovieModel?){
       tv_description.text = movie?.movieDescription
    }

    private fun loadDataTvShow(tvShow: TvShowModel?){
        tv_description.text = tvShow?.tvShowDescription
    }

}
