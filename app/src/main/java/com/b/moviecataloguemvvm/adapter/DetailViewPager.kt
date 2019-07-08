package com.b.moviecataloguemvvm.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.b.moviecataloguemvvm.view.CrewFragment
import com.b.moviecataloguemvvm.view.DescriptionFragment

class DetailViewPager(viewPagerManager: FragmentManager) : FragmentStatePagerAdapter(viewPagerManager){

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> DescriptionFragment()
            else -> CrewFragment()
        }
    }

    override fun getCount(): Int = 2

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Description"
            else -> "Crew"
        }
    }
}