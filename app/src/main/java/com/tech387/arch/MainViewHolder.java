package com.tech387.arch;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class MainViewHolder extends RecyclerView.ViewHolder {

    private TextView mTextView;

    public MainViewHolder(@NonNull View itemView) {
        super(itemView);

        mTextView = itemView.findViewById(R.id.tv_name);
    }

    public void setup(String s) {
        mTextView.setText(s);
    }

}
