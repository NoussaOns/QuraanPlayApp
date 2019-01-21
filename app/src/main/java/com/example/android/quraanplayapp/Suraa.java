package com.example.android.quraanplayapp;

public class Suraa {
    private String mName, mPlace;
    private int mPage, mNumberOfVerses;

    public Suraa(String name, String place, int page, int numberOfVerses){
        mName = name;
        mPage = page;
        mNumberOfVerses = numberOfVerses;
        mPlace = place;
    }

    public String getName() {
        return mName;
    }

    public int getNumberOfVerses() {
        return mNumberOfVerses;
    }

    public int getPage() {
        return mPage;
    }

    public String getPlace() {
        return mPlace;
    }
}
