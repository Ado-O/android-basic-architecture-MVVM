package com.tech387.arch.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tech387.arch.R;
import com.tech387.arch.ViewModelFactory;
import com.tech387.arch.data.Movie;
import com.tech387.arch.databinding.MainFragBinding;

public class MainFragment extends Fragment implements MainClickListener {

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    private MainFragBinding mBinding;

    private MainViewModel mViewModel;

    private MainAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = MainFragBinding.inflate(inflater, container, false);

        mViewModel = ViewModelFactory.obtainViewModel(getActivity(), MainViewModel.class);
        mViewModel.start();

        mBinding.setViewModel(mViewModel);

        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupAdapter();
    }

    private void setupAdapter() {
        mAdapter = new MainAdapter(getContext(), this);
        mBinding.list.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.list.setAdapter(mAdapter);
    }

    @Override
    public void onMovieClick(View view, Movie movie) {
        mViewModel.getOpenMovieEvent().setValue(movie);
    }
}
