package com.b.moviecataloguemvvm.model.remote;

import android.os.Handler;
import com.b.moviecataloguemvvm.model.remote.response.MovieModelResponse;
import com.b.moviecataloguemvvm.model.remote.response.TvShowModelResponse;
import com.b.moviecataloguemvvm.utils.EspressoIdlingResource;

import java.util.List;

public class RemoteRepositoryJava {

    private static RemoteRepositoryJava INSTANCE;
    private final long SERVICE_LATENCY_IN_MILLIS = 2000;
    private Helper helper;

    private RemoteRepositoryJava(Helper helper){
        this.helper = helper;
    }

    public static RemoteRepositoryJava getInstance(Helper helper) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteRepositoryJava(helper);
        }
        return INSTANCE;
    }

    public void getMovieList(GetMovieListCallback callback) {
        EspressoIdlingResource.increment();
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            callback.onMoviesReceived(helper.getMovieList());
            EspressoIdlingResource.decrement();
        }, SERVICE_LATENCY_IN_MILLIS);
    }

    public void getMovieById(int movieId, GetMovieByIdCallback callback) {
        EspressoIdlingResource.increment();
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            callback.onMovieReceived(helper.getMovieById(movieId));
            EspressoIdlingResource.decrement();
        }, SERVICE_LATENCY_IN_MILLIS);
    }


    public void getTvShowList(GetTvShowListCallback callback) {
        EspressoIdlingResource.increment();
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            callback.onTvShowsReceived(helper.getTvShowList());
            EspressoIdlingResource.decrement();
        }, SERVICE_LATENCY_IN_MILLIS);
    }

    public void getTvShowById(int tvShowId, GetTvShowByIdCallback callback) {
        EspressoIdlingResource.increment();
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            callback.onTvShowReceived(helper.getTvShowById(tvShowId));
            EspressoIdlingResource.decrement();
        }, SERVICE_LATENCY_IN_MILLIS);
    }


    public interface GetMovieListCallback {
        void onMoviesReceived(List<MovieModelResponse> movieModelResponseList);

        void onDataNotAvailable();
    }

    public interface GetMovieByIdCallback {
        void onMovieReceived(MovieModelResponse movieModelResponse);

        void onDataNotAvailable();
    }

    public interface GetTvShowListCallback {
        void onTvShowsReceived(List<TvShowModelResponse> tvShowModelResponseList);

        void onDataNotAvailable();
    }

    public interface GetTvShowByIdCallback {
        void onTvShowReceived(TvShowModelResponse tvShowModelResponse);

        void onDataNotAvailable();
    }


}
