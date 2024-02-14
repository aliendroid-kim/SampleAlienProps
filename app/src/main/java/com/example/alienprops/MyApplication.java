package com.example.alienprops;

import android.app.Application;
import android.content.Context;

import com.props.adsmanager.PropsAdsManagement;

public class MyApplication extends Application {
    private static OpenAds alienOpenAds;
    Context context;
    //Uranus
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        PropsAdsManagement.initializeAdsMapping(this);
        alienOpenAds = new OpenAds(this);

    }
}