package com.example.android.quraanplayapp;

public class Suraa {
    private String mNameEnglish,mNameArabic, mPlace;
    private int mPage, mNumberOfVerses;

    public Suraa(String nameEnglish,String nameArabic, String place, int page, int numberOfVerses){
        mNameEnglish = nameEnglish;
        mNameArabic=nameArabic;
        mPage = page;
        mNumberOfVerses = numberOfVerses;
        mPlace = place;
    }

    public String getNameEnglish() {
        return mNameEnglish;
    }

    public String getNameArabic() {
        return mNameArabic;
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
