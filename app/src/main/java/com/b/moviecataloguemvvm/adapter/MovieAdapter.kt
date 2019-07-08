package com.b.moviecataloguemvvm.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.b.moviecataloguemvvm.R
import com.b.moviecataloguemvvm.model.MovieModel
import com.b.moviecataloguemvvm.view.DetailActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.row_item.view.*

class MovieAdapter(private val context: Context?, private val listMovies : List<MovieModel> ) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_item, parent,false))
    }

    override fun getItemCount(): Int {
       return listMovies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewHolder(listMovies[position])
        context?.let { Glide.with(it).load(listMovies[position].moviePoster).into(holder.poster) }
        holder.cardItem.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("movieId", listMovies[position].movieId)
            context?.startActivity(intent)
        }
    }

    class ViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView) {
        val poster = itemView.iv_poster
        val cardItem = itemView.cv_item
        fun bindViewHolder(listMovies : MovieModel){
            itemView.tv_title.text = listMovies.movieTitle
        }
    }
}