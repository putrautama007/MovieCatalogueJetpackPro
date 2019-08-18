package com.b.moviecataloguemvvm.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.b.moviecataloguemvvm.R
import com.b.moviecataloguemvvm.adapter.FavoriteViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_favorite.*


class FavoriteFragment : Fragment() {

    private lateinit var viewPagerAdapter: FavoriteViewPagerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewPagerAdapter = FavoriteViewPagerAdapter(childFragmentManager)
        viewPagerAdapter.addFragment(FavoriteMovieFragment(),getString(R.string.movie))
        viewPagerAdapter.addFragment(FavoriteTvShowFragment(), getString(R.string.tv_show))

        favorite_view_pager.adapter = viewPagerAdapter
        tab_layout.setupWithViewPager(favorite_view_pager)
    }

}
