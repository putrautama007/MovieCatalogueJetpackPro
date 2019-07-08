package com.b.moviecataloguemvvm.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager

import com.b.moviecataloguemvvm.R
import com.b.moviecataloguemvvm.adapter.FeaturedCrewAdapter
import com.b.moviecataloguemvvm.adapter.MovieAdapter
import com.b.moviecataloguemvvm.model.FeaturedCrew
import com.b.moviecataloguemvvm.model.MovieModel
import com.b.moviecataloguemvvm.model.TvShowModel
import com.b.moviecataloguemvvm.viewmodel.MovieViewModel
import com.b.moviecataloguemvvm.viewmodel.TvShowViewModel
import kotlinx.android.synthetic.main.fragment_crew.*
import kotlinx.android.synthetic.main.fragment_description.*
import kotlinx.android.synthetic.main.fragment_movie.*


class CrewFragment : Fragment() {

    lateinit var featuredCrewList : List<FeaturedCrew>

    private val movieViewModel by lazy {
        ViewModelProviders.of(this).get(MovieViewModel::class.java)
    }

    private val tvShowViewModel by lazy {
        ViewModelProviders.of(this).get(TvShowViewModel::class.java)
    }

    private val featuredCrewAdapter by lazy {
        FeaturedCrewAdapter(context,featuredCrewList)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_crew, container, false)
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
        movie?.featuredCrew?.let { iniRecyclerview(it) }
    }

    private fun loadDataTvShow(tvShow: TvShowModel?){
        tvShow?.featuredCrew?.let { iniRecyclerview(it) }
    }

    private fun iniRecyclerview(featuredCrew: List<FeaturedCrew>){

        featuredCrewList = featuredCrew
        rv_feature_crew.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@CrewFragment.featuredCrewAdapter
        }

    }

}
