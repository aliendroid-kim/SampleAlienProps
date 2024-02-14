package com.example.alienprops;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        OpenAds.LoadOpenAds("testing_alien");
        OpenAds.AppOpenAdManager.showAdIfAvailable(SplashActivity.this, new OpenAds.OnShowAdCompleteListener() {
            @Override
            public void onShowAdComplete() {
                //Kondisi iklan Open App selesai dibuka
                startActivity(true);
            }
        });
    }
    private void startActivity(boolean useTime){
        if (useTime){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
            },1000*3);
        }else {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

    }
}