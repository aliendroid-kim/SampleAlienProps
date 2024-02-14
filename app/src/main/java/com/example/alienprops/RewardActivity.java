package com.example.alienprops;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.props.adsmanager.PropsAdsManagement;

public class RewardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward);
        PropsAdsManagement.loadRewardedAds(this, "testing_alien", new RewardedAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull RewardedAd rewardedAd) {

            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                // notif kondisi error
            }
        });



        this.findViewById(R.id.tbShowReward).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PropsAdsManagement.getRewardedAds() != null) {
                    PropsAdsManagement.triggerRewardedAds(RewardActivity.this, new OnUserEarnedRewardListener() {
                        @Override
                        public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                            //isi dengan kondisi hadiah, misalnya memberikan koin atau membuka item
                        }
                    });
                }
            }
        });
    }
}