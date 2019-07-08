package com.b.moviecataloguemvvm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.b.moviecataloguemvvm.R
import com.b.moviecataloguemvvm.model.FeaturedCrew
import kotlinx.android.synthetic.main.row_featured_crew.view.*

class FeaturedCrewAdapter(private  val context: Context?, private val listMovies : List<FeaturedCrew>): RecyclerView.Adapter<FeaturedCrewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_featured_crew, parent,false))

    }

    override fun getItemCount(): Int {
        return  listMovies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewHolder(listMovies[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindViewHolder(listFeaturedCrew: FeaturedCrew){
            itemView.tv_crew_name.text = listFeaturedCrew.crewName
            itemView.tv_crew_position.text = listFeaturedCrew.crewPosition
        }
    }
}