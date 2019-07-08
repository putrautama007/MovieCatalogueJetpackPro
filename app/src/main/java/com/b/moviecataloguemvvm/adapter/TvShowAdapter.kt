package com.b.moviecataloguemvvm.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.b.moviecataloguemvvm.R
import com.b.moviecataloguemvvm.model.TvShowModel
import com.b.moviecataloguemvvm.view.DetailActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.row_item.view.*

class TvShowAdapter(private val context: Context?, private val listTvShows : List<TvShowModel>) : RecyclerView.Adapter<TvShowAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_item, parent,false))
    }

    override fun getItemCount(): Int {
        return listTvShows.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewHolder(listTvShows[position])
        context?.let { Glide.with(it).load(listTvShows[position].tvShowPoster).into(holder.poster) }
        holder.cardItem.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("tvShowId", listTvShows[position].tvShowId)
            context?.startActivity(intent)
        }
    }

    class ViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView) {
        val poster = itemView.iv_poster
        val cardItem = itemView.cv_item
        fun bindViewHolder(listMovies : TvShowModel){
            itemView.tv_title.text = listMovies.tvShowTitle
        }
    }
}