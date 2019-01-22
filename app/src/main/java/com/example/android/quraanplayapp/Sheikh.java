package com.example.android.quraanplayapp;

public class Sheikh {

    private String mName;
    private int mImageResourceId;

    public Sheikh(String name, int imageResourceId) {
        mName = name;
        mImageResourceId = imageResourceId;
    }

    public String getName() {
        return mName;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }
}
