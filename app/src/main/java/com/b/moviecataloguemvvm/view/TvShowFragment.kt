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
import com.b.moviecataloguemvvm.adapter.TvShowAdapter
import com.b.moviecataloguemvvm.model.local.entity.TvShowModel
import com.b.moviecataloguemvvm.viewmodel.TvShowViewModel
import com.b.moviecataloguemvvm.viewmodel.ViewModelFactory
import com.b.moviecataloguemvvm.vo.Status.*
import kotlinx.android.synthetic.main.fragment_tv_show.*

class TvShowFragment : Fragment() {

    private var tvShowList : List<TvShowModel> = listOf()

    private val tvShowViewModel by lazy {
        val viewModelFactory= activity?.application?.let { ViewModelFactory.getInstance(it) }
        ViewModelProviders.of(this,viewModelFactory).get(TvShowViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val tvShowsAdapter = TvShowAdapter(context)
        tvShowViewModel.tvShow.observe(viewLifecycleOwner, Observer {
            tv_progress_bar.visibility = View.GONE
            tvShowList = it
            tvShowsAdapter.getList(tvShowList)
            getTvShows()
        })
        rv_tv_show.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = tvShowsAdapter
        }
    }

    private fun getTvShows() {
        tvShowViewModel.getTvShows.observe(viewLifecycleOwner, Observer {

            when (it.status) {
                SUCCESS -> {
                    tv_progress_bar.visibility = View.GONE
                    if (it.data.isNullOrEmpty()) {
                        tvShowViewModel.insertTvShows(tvShowList)
                    }
                }
                ERROR -> {
                    tv_progress_bar.visibility = View.GONE
                }
                LOADING -> {
                }
            }
        })
    }
}
