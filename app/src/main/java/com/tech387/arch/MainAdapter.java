package com.tech387.arch;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.tech387.arch.data.Movie;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter {

    private LayoutInflater mInflater;
    private ArrayList<Movie> mList;

    MainAdapter(Context context, ArrayList<Movie> list) {
        mInflater = LayoutInflater.from(context);
        mList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MainViewHolder(mInflater.inflate(R.layout.main_row, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((MainViewHolder) viewHolder).setup(mList.get(i));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


}
