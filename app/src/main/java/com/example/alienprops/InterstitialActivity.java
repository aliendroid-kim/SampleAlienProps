package com.example.alienprops;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.props.adsmanager.PropsAdsManagement;

public class InterstitialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstitial);
        PropsAdsManagement.loadInterstitialAds(this, "testing_alien", new InterstitialAdLoadCallback() {
            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);

            }
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAdProps) {
                super.onAdLoaded(interstitialAdProps);
            }
        });

        this.findViewById(R.id.tbShowInterstitial).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PropsAdsManagement.getInterstitialAds() != null) {
                    PropsAdsManagement.getInterstitialAds().show(InterstitialActivity.this);
                }
            }
        });
    }
}