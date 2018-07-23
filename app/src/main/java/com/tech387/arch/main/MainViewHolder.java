package com.tech387.arch.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.tech387.arch.data.Movie;
import com.tech387.arch.databinding.MainRowBinding;

public class MainViewHolder extends RecyclerView.ViewHolder {

    private MainRowBinding mBinding;

    public MainViewHolder(@NonNull MainRowBinding binding, MainClickListener listener) {
        super(binding.getRoot());

        mBinding = binding;
        mBinding.setListener(listener);
    }

    public void setup(Movie movie) {
        mBinding.setMovie(movie);
    }
}
