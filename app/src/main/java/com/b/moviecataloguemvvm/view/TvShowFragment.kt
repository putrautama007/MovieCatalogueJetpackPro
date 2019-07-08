package com.b.moviecataloguemvvm.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager

import com.b.moviecataloguemvvm.R
import com.b.moviecataloguemvvm.adapter.TvShowAdapter
import com.b.moviecataloguemvvm.model.TvShowModel
import com.b.moviecataloguemvvm.viewmodel.TvShowViewModel
import kotlinx.android.synthetic.main.fragment_tv_show.*

class TvShowFragment : Fragment() {

    lateinit var tvShowList : List<TvShowModel>

    private val tvShowViewModel by lazy {
        ViewModelProviders.of(this).get(TvShowViewModel::class.java)
    }

    private val tvShowAdapter by lazy {
        TvShowAdapter(context,tvShowList)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        tvShowList = tvShowViewModel.tvShow
        rv_tv_show.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = this@TvShowFragment.tvShowAdapter
        }
    }
}
