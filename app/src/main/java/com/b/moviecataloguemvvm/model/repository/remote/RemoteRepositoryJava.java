package com.b.moviecataloguemvvm.model.repository.remote;

import android.util.Log;
import com.b.moviecataloguemvvm.BuildConfig;
import com.b.moviecataloguemvvm.helper.ApiClient;
import com.b.moviecataloguemvvm.utils.EspressoIdlingResourceJava;

import java.util.List;

import android.os.Handler;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteRepositoryJava {

    private static RemoteRepositoryJava INSTANCE;
    private final long SERVICE_LATENCY_IN_MILLIS = 2000;
    private String API_KEY = BuildConfig.MOVIE_API;
    private ApiClient apiClient;
    private Handler responseHandler = new Handler();

    public RemoteRepositoryJava(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public static RemoteRepositoryJava getInstance(ApiClient apiClient) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteRepositoryJava(apiClient);
        }
        return INSTANCE;
    }

    public interface GetMovieCallback {
        void onResponse(List<ItemList> movieResponse);

        void onErrorResponse();
    }

    public interface GetMovieDetailCallback {
        void onResponse(ItemList movieResponse);

        void onErrorResponse();
    }

    public interface GetTvShowsCallback {
        void onResponse(List<ItemList> tvShowsResponse);

        void onErrorResponse();
    }

    public interface GetTvShowDetailCallback {
        void onResponse(TvShowsDetail tvShowsResponse);

        void onErrorResponse();
    }

    public interface GetMovieCrewCallback {
        void onResponse(List<CrewList> movieResponse);

        void onErrorResponse();
    }

    public interface GetTvShowCrewCallback {
        void onResponse(List<CrewList> tvShowsResponse);

        void onErrorResponse();
    }

    public void getMovie(final GetMovieCallback getMovieListCallback) {
        EspressoIdlingResourceJava.increment();
        responseHandler.postDelayed(() -> {
                    apiClient.create().getMovie(API_KEY).enqueue(new Callback<ItemResponse>() {
                        @Override
                        public void onResponse(Call<ItemResponse> call, Response<ItemResponse> response) {
                            getMovieListCallback.onResponse(response.body().getResults());
                            EspressoIdlingResourceJava.decrement();
                        }

                        @Override
                        public void onFailure(Call<ItemResponse> call, Throwable t) {
                            Log.d("error", t.toString());
                        }
                    });

                }
                , SERVICE_LATENCY_IN_MILLIS);
    }

    public void getMovieDetail(String movieId, GetMovieDetailCallback getMovieDetailCallback) {
        EspressoIdlingResourceJava.increment();
        responseHandler.postDelayed(() -> {
            apiClient.create().getMovieDetails(movieId, API_KEY).enqueue(new Callback<ItemList>() {
                @Override
                public void onResponse(Call<ItemList> call, Response<ItemList> response) {
                    getMovieDetailCallback.onResponse(response.body());
                    EspressoIdlingResourceJava.decrement();
                }

                @Override
                public void onFailure(Call<ItemList> call, Throwable t) {
                    Log.d("error", t.toString());
                }
            });

        }, SERVICE_LATENCY_IN_MILLIS);
    }

    public void getTvShowsList(GetTvShowsCallback getTvShowsCallback) {
        EspressoIdlingResourceJava.increment();
        responseHandler.postDelayed(() -> {
            apiClient.create().getTvShows(API_KEY).enqueue(new Callback<ItemResponse>() {
                @Override
                public void onResponse(Call<ItemResponse> call, Response<ItemResponse> response) {
                    getTvShowsCallback.onResponse(response.body().getResults());
                    EspressoIdlingResourceJava.decrement();
                }

                @Override
                public void onFailure(Call<ItemResponse> call, Throwable t) {
                    Log.d("error", t.toString());
                }
            });

        }, SERVICE_LATENCY_IN_MILLIS);
    }

    public void getTvShowDetail(String tvId, GetTvShowDetailCallback getTvShowDetailCallback) {
        EspressoIdlingResourceJava.increment();
        responseHandler.postDelayed(() -> {
            apiClient.create().getTvShowDetails(tvId, API_KEY).enqueue(new Callback<TvShowsDetail>() {
                @Override
                public void onResponse(Call<TvShowsDetail> call, Response<TvShowsDetail> response) {
                    getTvShowDetailCallback.onResponse(response.body());
                    EspressoIdlingResourceJava.decrement();
                }

                @Override
                public void onFailure(Call<TvShowsDetail> call, Throwable t) {
                    Log.d("error", t.toString());
                }
            });

        }, SERVICE_LATENCY_IN_MILLIS);
    }

    public void getMovieCrew(String movieId, GetMovieCrewCallback getMovieCrewCallback) {
        EspressoIdlingResourceJava.increment();
        responseHandler.postDelayed(() -> {
            apiClient.create().getMovieCrew(movieId, API_KEY).enqueue(new Callback<CrewResponse>() {
                @Override
                public void onResponse(Call<CrewResponse> call, Response<CrewResponse> response) {
                    getMovieCrewCallback.onResponse(response.body().getCrew());
                    EspressoIdlingResourceJava.decrement();
                }

                @Override
                public void onFailure(Call<CrewResponse> call, Throwable t) {
                    Log.d("error", t.toString());
                }
            });

        }, SERVICE_LATENCY_IN_MILLIS);
    }

    public void getTvShowCrew(String tvId, GetTvShowCrewCallback getTvShowCrewCallback) {
        EspressoIdlingResourceJava.increment();
        responseHandler.postDelayed(() -> {
            apiClient.create().getTvShowCrew(tvId, API_KEY).enqueue(new Callback<CrewResponse>() {
                @Override
                public void onResponse(Call<CrewResponse> call, Response<CrewResponse> response) {
                    getTvShowCrewCallback.onResponse(response.body().getCrew());
                    EspressoIdlingResourceJava.decrement();
                }

                @Override
                public void onFailure(Call<CrewResponse> call, Throwable t) {
                    Log.d("error", t.toString());
                }
            });

        }, SERVICE_LATENCY_IN_MILLIS);
    }

}
