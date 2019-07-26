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
import com.b.moviecataloguemvvm.model.repository.remote.CrewList
import com.b.moviecataloguemvvm.viewmodel.MovieViewModel
import com.b.moviecataloguemvvm.viewmodel.TvShowViewModel
import com.b.moviecataloguemvvm.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_crew.*


class CrewFragment : Fragment() {

    private var featuredCrewList = listOf<CrewList>()

    private val movieViewModel by lazy {
        val viewModelFactory= activity?.application?.let { ViewModelFactory.getInstance() }
        ViewModelProviders.of(this,viewModelFactory).get(MovieViewModel::class.java)
    }
    private val tvShowViewModel by lazy {
        val viewModelFactory= activity?.application?.let { ViewModelFactory.getInstance() }
        ViewModelProviders.of(this,viewModelFactory).get(TvShowViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_crew, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val crewAdapter = FeaturedCrewAdapter(context)

        if (activity?.intent?.getStringExtra("movie") != null){
            loadDataMovie(activity?.intent?.getStringExtra("movie")!!,crewAdapter)
        } else{
            activity?.intent?.getStringExtra("tvShow")?.let { loadDataTvShow(it,crewAdapter) }
        }

    }

    private fun loadDataMovie(movieId:String,crewAdapter: FeaturedCrewAdapter){
        movieViewModel.getMovieCrew(movieId).observe(viewLifecycleOwner, Observer {
            featuredCrewList = it
            crewAdapter.addList(featuredCrewList)
        })
            initRecyclerview(crewAdapter)
    }

    private fun loadDataTvShow(tvId: String,crewAdapter: FeaturedCrewAdapter){
        tvShowViewModel.getTvShowCrew(tvId).observe(viewLifecycleOwner, Observer {
            featuredCrewList = it
            crewAdapter.addList(featuredCrewList)
        })
        initRecyclerview(crewAdapter)

    }

    private fun initRecyclerview(crewAdapter: FeaturedCrewAdapter){

        rv_feature_crew.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = crewAdapter
        }


    }

}
