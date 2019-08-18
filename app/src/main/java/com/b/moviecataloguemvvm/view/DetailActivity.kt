package com.b.moviecataloguemvvm.view

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.b.moviecataloguemvvm.R
import com.b.moviecataloguemvvm.adapter.DetailViewPager
import com.b.moviecataloguemvvm.model.local.entity.MovieModel
import com.b.moviecataloguemvvm.model.local.entity.TvShowModel
import com.b.moviecataloguemvvm.viewmodel.MovieViewModel
import com.b.moviecataloguemvvm.viewmodel.TvShowViewModel
import com.b.moviecataloguemvvm.viewmodel.ViewModelFactory
import com.b.moviecataloguemvvm.vo.Resource
import com.b.moviecataloguemvvm.vo.Status.*
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
    private var menu: Menu? = null


    private val movieDetailViewModel by lazy {
        val viewModelFactory= ViewModelFactory.getInstance(application)
        ViewModelProviders.of(this,viewModelFactory).get(MovieViewModel::class.java)
    }

    private val tvShowDetailViewModel by lazy {
        val viewModelFactory= ViewModelFactory.getInstance(application)
        ViewModelProviders.of(this,viewModelFactory).get(TvShowViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
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


        Log.d("data", "${intent.getIntExtra("movieId",0)}")

        if (intent.getIntExtra("movieId",0) != 0){
            movieDetailViewModel.movieDetail(intent.getIntExtra("movieId",0)).observe(this, Observer {
                initLoading()
                loadDataMovie(it)
                movieDetailViewModel.setMovieId(intent.getIntExtra("movieId",0))
            })
        }else{
            tvShowDetailViewModel.tvShowDetail(intent.getIntExtra("tvShowId",0)).observe(this, Observer {
                initLoading()
                loadDataTvShow(it)
                tvShowDetailViewModel.tvShowId.value =intent.getIntExtra("tvShowId",0)
            })
        }

        initViewPager()
    }

    private fun initViewPager(){
        itemViewPager = detail_view_pager
        itemViewPager.adapter = DetailViewPager(supportFragmentManager)
        detail_tabLayout.setupWithViewPager(itemViewPager)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.favorite_menu, menu)
        this.menu = menu
        if (intent.getIntExtra("movieId",0) != 0) {
            movieDetailViewModel.getMovie.observe(this, Observer<Resource<MovieModel>> { response ->
                response?.let {
                    when (response.status) {
                        LOADING -> {

                        }
                        SUCCESS -> {
                        initLoading()

                            response.data?.let {
                                val state = it.favorite
                                setFavoriteState(state)
                            }
                        }
                        ERROR -> {
                        initLoading()
                            Toast.makeText(applicationContext, getString(R.string.error), Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }

            })
        }else{
            tvShowDetailViewModel.getTvShow.observe(this, Observer { response ->
                response?.let {
                    when (response.status) {
                        LOADING -> {

                        }
                        SUCCESS -> {
                            initLoading()

                            response.data?.let {
                                val state = it.favorite
                                setFavoriteState(state)
                            }
                        }
                        ERROR -> {
                            initLoading()
                            Toast.makeText(
                                applicationContext,
                                getString(R.string.error),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }

            })
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.favorite_menu) {
            if (intent.getIntExtra("movieId",0) != 0) {
                movieDetailViewModel.setFavoriteMovie()
            }else{
                tvShowDetailViewModel.setFavoriteTvShow()
            }
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setFavoriteState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.favorite_menu)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_star_24dp)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_star_border_24dp)
        }
    }
    private fun loadDataMovie(movie : MovieModel?){
        collapsingToolbar.title = movie?.movieTitle
        Glide.with(this).load(resources
            .getIdentifier(movie?.moviePoster, "drawable", packageName)).into(iv_poster_background)
        Glide.with(this).load(resources
            .getIdentifier(movie?.moviePoster, "drawable", packageName)).transform(RoundedCorners(15)).into(iv_poster)
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
        Glide.with(this).load(resources
            .getIdentifier(tvShow?.tvShowPoster, "drawable", packageName)).into(iv_poster_background)
        Glide.with(this).load(resources
            .getIdentifier(tvShow?.tvShowPoster, "drawable", packageName)).transform(RoundedCorners(15)).into(iv_poster)
        tv_rating_item.text = tvShow?.tvShowRating
        tv_release_date.text = tvShow?.tvShowRelease
        tv_title.text = tvShow?.tvShowTitle
        btn_trailer.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(tvShow?.tvShowTrailer))
            startActivity(intent)
        }
    }

    private fun initLoading(){
        detail_progress_bar.visibility = View.GONE
        coordinatorLayout.visibility = View.VISIBLE
        tv_loading.visibility = View.GONE
    }

}
