package com.tech387.arch.data;

public class Movie {

    private String mTitle;

    private String mDes;

    private String mImage;

    public Movie(String title, String des, String image) {
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

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }
}
