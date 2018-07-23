package com.tech387.arch.data.storage;

import com.tech387.arch.data.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository {

    private static MovieRepository sMovieRepository = null;

    public MovieRepository() {

    }

    public static MovieRepository getInstance() {
        if (sMovieRepository == null) {
            sMovieRepository = new MovieRepository();
        }
        return sMovieRepository;
    }

    public void getMovies(GetMoviesCallback callback) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Titanic", "Best Movie", "https://i.ytimg.com/vi/FSGeskFzE0s/maxresdefault.jpg"));
        movies.add(new Movie("Avengers", "Great Movie", "http://www.joblo.com/newsimages1/avengers-infinity-war-main.jpg"));
        movies.add(new Movie("Incredibles", "Ok", "https://upload.wikimedia.org/wikipedia/en/thumb/8/88/IncredibleFamily.jpg/250px-IncredibleFamily.jpg"));

        if (movies != null) {
            callback.onSuccess(movies);
        } else {
            callback.onError();
        }
    }

    public interface GetMoviesCallback {
        void onSuccess(List<Movie> movies);

        void onError();
    }

}
