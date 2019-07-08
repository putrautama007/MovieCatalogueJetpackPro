package com.b.moviecataloguemvvm.view

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.b.moviecataloguemvvm.R
import com.b.moviecataloguemvvm.adapter.DetailViewPager
import com.b.moviecataloguemvvm.model.MovieModel
import com.b.moviecataloguemvvm.model.TvShowModel
import com.b.moviecataloguemvvm.viewmodel.MovieViewModel
import com.b.moviecataloguemvvm.viewmodel.TvShowViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import kotlinx.android.synthetic.main.activity_detail.*
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout


class DetailActivity : AppCompatActivity() {

    private lateinit var itemViewPager: ViewPager
    private lateinit var toolbar: Toolbar
    private lateinit var collapsingToolbar: CollapsingToolbarLayout
    private lateinit var appBar: AppBarLayout


    private val movieViewModel by lazy {
        ViewModelProviders.of(this).get(MovieViewModel::class.java)
    }

    private val tvShowViewModel by lazy {
        ViewModelProviders.of(this).get(TvShowViewModel::class.java)
    }

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



        if (intent.getIntExtra("movieId",0) != 0){
            loadDataMovie(movieViewModel.movieDetail(intent.getIntExtra("movieId",0)))
        }else{
            loadDataTvShow(tvShowViewModel.tvShowDetail(intent.getIntExtra("tvShowId",0)))
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
        Glide.with(this).load(movie?.moviePoster).into(iv_poster_background)
        Glide.with(this).load(movie?.moviePoster).transform(RoundedCorners(15)).into(iv_poster)
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
        Glide.with(this).load(tvShow?.tvShowPoster).into(iv_poster_background)
        Glide.with(this).load(tvShow?.tvShowPoster).transform(RoundedCorners(15)).into(iv_poster)
        tv_rating_item.text = tvShow?.tvShowRating
        tv_release_date.text = tvShow?.tvShowRelease
        tv_title.text = tvShow?.tvShowTitle
        btn_trailer.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(tvShow?.tvShowTrailer))
            startActivity(intent)
        }
    }


}
