package com.example.android.quakereport;

import java.util.Date;

/**
 * Created by v-nkumar on 1/25/2018.
 */

public class EarthQuake {
    //Earthquake occured place
    private String mPlace;
    //Magnitude of the earthquake
    private double mMagnitude;
    //Date of the occurrence in milliseconds
    private long mTimeInMilliSeconds;

    private String mUrl;

    public EarthQuake(String place,double magnitude,long timeInMilliSeconds,String url) {
        mPlace = place;
        mMagnitude = magnitude;
        mTimeInMilliSeconds = timeInMilliSeconds;
        mUrl = url;
    }

    public String getPlace(){
        return mPlace;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public long getTimeInMilliSeconds() {
        return mTimeInMilliSeconds;
    }

    public String getmUrl(){
        return mUrl;
    }
}
