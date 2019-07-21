package com.b.moviecataloguemvvm.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.b.moviecataloguemvvm.R
import com.b.moviecataloguemvvm.adapter.FeaturedCrewAdapter
import com.b.moviecataloguemvvm.model.FeaturedCrew
import com.b.moviecataloguemvvm.model.MovieModel
import com.b.moviecataloguemvvm.model.TvShowModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_crew.*


class CrewFragment : Fragment() {

    lateinit var featuredCrewList : List<FeaturedCrew>

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

        if (activity?.intent?.getStringExtra("movie") != null){
            loadDataMovie(Gson().fromJson(activity?.intent?.getStringExtra("movie"),
                MovieModel::class.java))
        }else{
            loadDataTvShow(Gson().fromJson(activity?.intent?.getStringExtra("tvShow"),
                TvShowModel::class.java))
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
