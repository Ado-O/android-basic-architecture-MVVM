package com.tech387.arch.data;

public class Movie {

    private String mTitle;

    private String mDes;

    private int mImage;

    public Movie(String title, String des, int image) {
        mTitle = title;
        mDes = des;
        mImage = image;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDes() {
        return mDes;
    }

    public void setDes(String des) {
        mDes = des;
    }

    public int getImage() {
        return mImage;
    }

    public void setImage(int image) {
        mImage = image;
    }
}
