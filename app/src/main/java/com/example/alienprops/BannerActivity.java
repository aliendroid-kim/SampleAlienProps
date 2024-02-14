package com.example.alienprops;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RelativeLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.props.adsmanager.PropsAdsManagement;

public class BannerActivity extends AppCompatActivity {
    RelativeLayout layBanner320x50;
    RelativeLayout layBanner300x250;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);

        layBanner320x50 = findViewById(R.id.layBanner320x50);
        layBanner300x250 = findViewById(R.id.layBanner300x250);

        //Banner 320x50
        PropsAdsManagement propsAds = new PropsAdsManagement(this);
        AdView adView320x50 = propsAds.createBannerAdview("BANNER", "testing_alien");
        AdRequest adRequest = new AdRequest.Builder().build();
        layBanner320x50.addView(adView320x50);
        adView320x50.loadAd(adRequest);

        //Banner 300x250
        AdView adView300x250 = propsAds.createBannerAdview("MEDIUM_RECTANGLE", "testing_alien");
        layBanner300x250.addView(adView300x250);
        adView300x250.loadAd(adRequest);


    }
}