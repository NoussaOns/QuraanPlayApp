package com.example.android.quraanplayapp;
import android.os.Parcelable;
import android.os.Parcel;

public class Suraa implements Parcelable {
    private String mNameEnglish, mNameArabic, mPlace;
    private int mPage, mNumberOfVerses;

    // After implementing the `Parcelable` interface, we need to create the
    // `Parcelable.Creator<MyParcelable> CREATOR` constant for our class;
    // Notice how it has our class specified as its type.
    public static final Parcelable.Creator<Suraa> CREATOR
            = new Parcelable.Creator<Suraa>() {

        // This simply calls our new constructor (typically private) and
        // passes along the unmarshalled `Parcel`, and then returns the new object!
        @Override
        public Suraa createFromParcel(Parcel in) {
            return new Suraa(in);
        }

        // We just need to copy this and change the type to match our class.
        @Override
        public Suraa[] newArray(int size) {
            return new Suraa[size];
        }
     };

    public Suraa(String nameEnglish, String nameArabic, String place, int page, int numberOfVerses) {
        mNameEnglish = nameEnglish;
        mNameArabic = nameArabic;
        mPlace = place;
        mPage = page;
        mNumberOfVerses = numberOfVerses;

    }

    // This is where you write the values you want to save to the `Parcel`.
    // The `Parcel` class has methods defined to help you save all of your values.
    // Note that there are only methods defined for simple values, lists, and other Parcelable objects.
    // You may need to make several classes Parcelable to send the data you want.

    private Suraa(Parcel in){
        mNameEnglish = in.readString();
        mNameArabic = in.readString();
        mPlace = in.readString();
        mPage = in.readInt();
        mNumberOfVerses = in.readInt();
    }

    //Note: The items should be in the same order with the constructor
    @Override
    public void writeToParcel(Parcel out,int flags){
        out.writeString(mNameEnglish);
        out.writeString(mNameArabic);
        out.writeString(mPlace);
        out.writeInt(mPage);
        out.writeInt(mNumberOfVerses);

    }

    // In the vast majority of cases you can simply return 0 for this.
    // There are cases where you need to use the constant `CONTENTS_FILE_DESCRIPTOR`
    // But this is out of scope of this tutorial
    @Override
    public int describeContents() {
        return 0;
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
