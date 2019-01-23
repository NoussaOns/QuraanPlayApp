package com.example.android.quraanplayapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Sheikh implements Parcelable {

    private String mName;
    private int mImageResourceId;

    public Sheikh(String name, int imageResourceId) {
        mName = name;
        mImageResourceId = imageResourceId;
    }

    // After implementing the `Parcelable` interface, we need to create the
    // `Parcelable.Creator<MyParcelable> CREATOR` constant for our class;
    // Notice how it has our class specified as its type.
    public static final Parcelable.Creator<Sheikh> CREATOR
            = new Parcelable.Creator<Sheikh>() {

        // This simply calls our new constructor (typically private) and
        // passes along the unmarshalled `Parcel`, and then returns the new object!
        @Override
        public Sheikh createFromParcel(Parcel in) {
            return new Sheikh(in);
        }

        // We just need to copy this and change the type to match our class.
        @Override
        public Sheikh[] newArray(int size) {
            return new Sheikh[size];
        }
    };

    public String getName() {
        return mName;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    private Sheikh(Parcel in) {
        mName = in.readString();
        mImageResourceId = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int i) {
        out.writeString(mName);
        out.writeInt(mImageResourceId);
    }
}
