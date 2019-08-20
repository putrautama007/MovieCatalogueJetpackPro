package com.b.moviecataloguemvvm.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.b.moviecataloguemvvm.R
import com.b.moviecataloguemvvm.adapter.FavoriteTvShowAdapter
import com.b.moviecataloguemvvm.viewmodel.TvShowViewModel
import com.b.moviecataloguemvvm.viewmodel.ViewModelFactory
import com.b.moviecataloguemvvm.vo.Status.*
import kotlinx.android.synthetic.main.fragment_favorite_tv_show.*

class FavoriteTvShowFragment : Fragment() {

    private val tvShowViewModel by lazy {
        val viewModelFactory= activity?.application?.let { ViewModelFactory.getInstance(it) }
        ViewModelProviders.of(this,viewModelFactory).get(TvShowViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_tv_show, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val tvShowsAdapter = FavoriteTvShowAdapter(context)
        tvShowViewModel.getTvShowPaged.observe(viewLifecycleOwner, Observer { response ->

            if (response != null) {
                when (response.status) {
                    LOADING -> {

                    }
                    SUCCESS -> {
                        favorite_tv_progress_bar.visibility = View.GONE
                        tvShowsAdapter.submitList(response.data)
                    }
                    ERROR -> {
                        favorite_tv_progress_bar.visibility = View.GONE
                        Toast.makeText(context, getString(R.string.error), Toast.LENGTH_SHORT).show()
                    }
                }
            }

        })

        rv_favorite_tv_show.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = tvShowsAdapter
        }
    }


}
