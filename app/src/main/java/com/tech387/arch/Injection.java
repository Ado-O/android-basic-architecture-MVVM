package com.tech387.arch;

import com.tech387.arch.data.storage.MovieRepository;

public class Injection {

    public static MovieRepository getMovieRepository(){
        return MovieRepository.getInstance();
    }

}
