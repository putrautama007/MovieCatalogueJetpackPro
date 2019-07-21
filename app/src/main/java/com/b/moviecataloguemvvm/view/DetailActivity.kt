package com.b.moviecataloguemvvm.view

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.viewpager.widget.ViewPager
import com.b.moviecataloguemvvm.R
import com.b.moviecataloguemvvm.adapter.DetailViewPager
import com.b.moviecataloguemvvm.model.MovieModel
import com.b.moviecataloguemvvm.model.TvShowModel
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import kotlinx.android.synthetic.main.activity_detail.*
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.gson.Gson


class DetailActivity : AppCompatActivity() {

    private lateinit var itemViewPager: ViewPager
    private lateinit var toolbar: Toolbar
    private lateinit var collapsingToolbar: CollapsingToolbarLayout
    private lateinit var appBar: AppBarLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        toolbar = findViewById(R.id.toolbar)
        collapsingToolbar = findViewById(R.id.toolbar_layout)
        appBar = findViewById(R.id.app_bar)
        appBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            if (collapsingToolbar.height + verticalOffset < 2 * ViewCompat.getMinimumHeight(collapsingToolbar)) {
                toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
                collapsingToolbar.setCollapsedTitleTextColor(Color.WHITE)
            } else {
                toolbar.setNavigationIcon(R.drawable.ic_left_arrow)
                collapsingToolbar.setExpandedTitleColor(Color.TRANSPARENT)
            }
        })

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }


        if (intent.getStringExtra("movie") != null){
            loadDataMovie(Gson().fromJson(intent.getStringExtra("movie"),
                MovieModel::class.java))
            Log.d("data intent", intent.getStringExtra("movie").toString())
        }else{
            loadDataTvShow(Gson().fromJson(intent.getStringExtra("tvShow"),
                TvShowModel::class.java))
        }

        initViewPager()
    }

    private fun initViewPager(){
        itemViewPager = detail_view_pager
        itemViewPager.adapter = DetailViewPager(supportFragmentManager)
        detail_tabLayout.setupWithViewPager(itemViewPager)
    }

    private fun loadDataMovie(movie : MovieModel?){
        collapsingToolbar.title = movie?.movieTitle
        val imageID = resources?.getIdentifier(movie?.moviePoster,"drawable", packageName)
        Glide.with(this).load(imageID).into(iv_poster_background)
        Glide.with(this).load(imageID).transform(RoundedCorners(15)).into(iv_poster)
        tv_rating_item.text = movie?.movieRating
        tv_release_date.text = movie?.movieRelease
        tv_title.text = movie?.movieTitle
        btn_trailer.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(movie?.movieTrailer))
            startActivity(intent)
        }
    }

    private fun loadDataTvShow(tvShow: TvShowModel?){
        collapsingToolbar.title = tvShow?.tvShowTitle
        val imageID = resources?.getIdentifier(tvShow?.tvShowPoster,"drawable", packageName)
        Glide.with(this).load(imageID).into(iv_poster_background)
        Glide.with(this).load(imageID).transform(RoundedCorners(15)).into(iv_poster)
        tv_rating_item.text = tvShow?.tvShowRating
        tv_release_date.text = tvShow?.tvShowRelease
        tv_title.text = tvShow?.tvShowTitle
        btn_trailer.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(tvShow?.tvShowTrailer))
            startActivity(intent)
        }
    }


}
