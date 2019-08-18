package com.b.moviecataloguemvvm.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.b.moviecataloguemvvm.R
import com.b.moviecataloguemvvm.adapter.FeaturedCrewAdapter
import com.b.moviecataloguemvvm.model.local.entity.FeaturedCrew
import com.b.moviecataloguemvvm.model.local.entity.MovieModel
import com.b.moviecataloguemvvm.model.local.entity.TvShowModel
import com.b.moviecataloguemvvm.viewmodel.MovieViewModel
import com.b.moviecataloguemvvm.viewmodel.TvShowViewModel
import com.b.moviecataloguemvvm.viewmodel.ViewModelFactory
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_crew.*


class CrewFragment : Fragment() {

    lateinit var featuredCrewList : List<FeaturedCrew>

    private val movieDetailViewModel by lazy {
        val viewModelFactory= activity?.application?.let { ViewModelFactory.getInstance(it) }
        ViewModelProviders.of(this,viewModelFactory).get(MovieViewModel::class.java)
    }

    private val tvShowDetailViewModel by lazy {
        val viewModelFactory= activity?.application?.let { ViewModelFactory.getInstance(it) }
        ViewModelProviders.of(this,viewModelFactory).get(TvShowViewModel::class.java)
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
        val listFeaturedCrewResponse = Gson().fromJson(movie?.featuredCrew, Array<FeaturedCrew>::class.java).asList()
        movie?.featuredCrew?.let { iniRecyclerview(listFeaturedCrewResponse) }
    }

    private fun loadDataTvShow(tvShow: TvShowModel?){
        val listFeaturedCrewResponse = Gson().fromJson(tvShow?.featuredCrew, Array<FeaturedCrew>::class.java).asList()
        tvShow?.featuredCrew?.let { iniRecyclerview(listFeaturedCrewResponse) }
    }

    private fun iniRecyclerview(featuredCrew: List<FeaturedCrew>){

        featuredCrewList = featuredCrew
        rv_feature_crew.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@CrewFragment.featuredCrewAdapter
        }

    }

}
