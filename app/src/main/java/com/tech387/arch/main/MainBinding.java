package com.tech387.arch.main;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.tech387.arch.data.Movie;

import java.util.List;

public class MainBinding {


    @SuppressWarnings("unchecked")
    @BindingAdapter("app:movies")
    public static void setMovies(RecyclerView recyclerView, List items) {
        MainAdapter adapter = (MainAdapter) recyclerView.getAdapter();
        if (adapter != null && items != null) {
            adapter.setMovies(items);
        }
    }

    @SuppressWarnings("unchecked")
    @BindingAdapter("app:loadImage")
    public static void setImage(ImageView imageView, Movie movies) {
        Glide.with(imageView.getContext()).load(movies.getImage()).into(imageView);
    }

}
