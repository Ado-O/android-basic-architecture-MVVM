package com.tech387.arch.main;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;

import com.tech387.arch.SingleLiveEvent;
import com.tech387.arch.data.Movie;
import com.tech387.arch.data.storage.MovieRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private final MovieRepository mMovieRepository;

    public final ObservableList<Movie> mItems = new ObservableArrayList<>();

    public final ObservableBoolean mError = new ObservableBoolean(false);

    private final SingleLiveEvent<Movie> mOpenMovieEvent = new SingleLiveEvent<>();

    public MainViewModel(@NonNull Application application, MovieRepository movieRepository) {
        super(application);
        mMovieRepository = movieRepository;
    }

    public void start() {
        if (mItems.isEmpty()) {
            getMovies();
        }
    }

    private void getMovies() {
        mMovieRepository.getMovies(new MovieRepository.GetMoviesCallback() {
            @Override
            public void onSuccess(List<Movie> movies) {
                mItems.clear();
                mItems.addAll(movies);
                mError.set(mItems.isEmpty());
            }

            @Override
            public void onError() {
                mError.set(true);
            }
        });
    }

    public SingleLiveEvent<Movie> getOpenMovieEvent() {
        return mOpenMovieEvent;
    }
}
