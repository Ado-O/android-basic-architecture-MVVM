package com.tech387.arch;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tech387.arch.data.Movie;

public class MainViewHolder extends RecyclerView.ViewHolder {

    private ImageView mIvImage;

    private TextView mTvTitle;

    private TextView mTvDes;

    public MainViewHolder(@NonNull View itemView) {
        super(itemView);

        mIvImage = itemView.findViewById(R.id.iv_image);
        mTvTitle = itemView.findViewById(R.id.tv_title);
        mTvDes = itemView.findViewById(R.id.tv_des);

    }

    public void setup(Movie movie) {
        Glide.with(itemView.getContext())
                .load(movie.getImage())
                .into(mIvImage);
        mTvTitle.setText(movie.getTitle());
        mTvDes.setText(movie.getDes());
    }

}
