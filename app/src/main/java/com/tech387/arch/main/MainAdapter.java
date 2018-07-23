package com.tech387.arch.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.tech387.arch.data.Movie;
import com.tech387.arch.databinding.MainRowBinding;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter {

    private LayoutInflater mInflater;

    private MainClickListener mListener;

    private List<Movie> mMovies = new ArrayList<>();

    public MainAdapter(Context context, MainClickListener listener) {
        mInflater = LayoutInflater.from(context);
        mListener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MainViewHolder(
                MainRowBinding.inflate(mInflater, viewGroup, false),
                mListener
        );
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((MainViewHolder) viewHolder).setup(mMovies.get(i));
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public void setMovies(List<Movie> movies) {
        mMovies.clear();
        mMovies.addAll(movies);
        notifyDataSetChanged();
    }
}
