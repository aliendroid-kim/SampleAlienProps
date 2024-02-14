package com.example.alienprops;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.props.adsmanager.PropsAdsManagement;

public class NativesActivity extends AppCompatActivity {
    private static NativeAd nativeAdSmall;
    private static NativeAd nativeAdBig;
    RelativeLayout laySmallNative ;
    RelativeLayout layBigNatives;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_natives);

        laySmallNative = findViewById(R.id.laySmallNative);
        layBigNatives = findViewById(R.id.layBigNatives);

        //Small Native
        String getNativeId = PropsAdsManagement.getNativeAdsId("testing_alien");
        AdLoader.Builder builder = new AdLoader.Builder(NativesActivity.this, getNativeId);
        builder.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
            @Override
            public void onNativeAdLoaded(@NonNull NativeAd nativeAds) {
                if (nativeAdSmall != null) {
                    nativeAdSmall.destroy();
                }
                nativeAdSmall = nativeAds;
                NativeAdView adView = (NativeAdView) getLayoutInflater()
                        .inflate(R.layout.alien_small_native, null);
                populateNativeAdView(nativeAds, adView);
                laySmallNative.removeAllViews();
                laySmallNative.addView(adView);
            }
        });
        VideoOptions videoOptions = new VideoOptions.Builder()
                .build();
        NativeAdOptions adOptions = new NativeAdOptions.Builder()
                .setVideoOptions(videoOptions)
                .build();
        builder.withNativeAdOptions(adOptions);
        AdRequest request = new AdRequest.Builder()
                .build();
        AdLoader adLoader =
                builder
                        .withAdListener(
                                new AdListener() {
                                    @Override
                                    public void onAdFailedToLoad(LoadAdError loadAdError) {

                                    }
                                })
                        .build();
        adLoader.loadAd(request);


        //Big Native
        String getNativeId2 = PropsAdsManagement.getNativeAdsId("testing_alien");
        AdLoader.Builder builder2 = new AdLoader.Builder(NativesActivity.this, getNativeId2);
        builder2.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
            @Override
            public void onNativeAdLoaded(@NonNull NativeAd nativeAds) {
                if (nativeAdBig != null) {
                    nativeAdBig.destroy();
                }
                nativeAdBig = nativeAds;
                NativeAdView adView = (NativeAdView) getLayoutInflater()
                        .inflate(R.layout.alien_big_native, null);
                populateNativeAdView(nativeAds, adView);
                layBigNatives.removeAllViews();
                layBigNatives.addView(adView);
            }
        });
        VideoOptions videoOptions2 = new VideoOptions.Builder()
                .build();
        NativeAdOptions adOptions2 = new NativeAdOptions.Builder()
                .setVideoOptions(videoOptions2)
                .build();
        builder2.withNativeAdOptions(adOptions2);
        AdRequest request2 = new AdRequest.Builder()
                .build();
        AdLoader adLoader2 =
                builder2
                        .withAdListener(
                                new AdListener() {
                                    @Override
                                    public void onAdFailedToLoad(LoadAdError loadAdError) {

                                    }
                                })
                        .build();
        adLoader2.loadAd(request2);
    }
    private static void populateNativeAdView(NativeAd nativeAd, NativeAdView adView) {
        adView.setMediaView((MediaView) adView.findViewById(R.id.ad_media));
        adView.setHeadlineView(adView.findViewById(R.id.ad_headline));
        adView.setBodyView(adView.findViewById(R.id.ad_body));
        adView.setCallToActionView(adView.findViewById(R.id.ad_call_to_action));
        adView.setIconView(adView.findViewById(R.id.ad_app_icon));
        adView.setPriceView(adView.findViewById(R.id.ad_price));
        adView.setStarRatingView(adView.findViewById(R.id.ad_stars));
        adView.setStoreView(adView.findViewById(R.id.ad_store));
        adView.setAdvertiserView(adView.findViewById(R.id.ad_advertiser));
        ((TextView) adView.getHeadlineView()).setText(nativeAd.getHeadline());
        adView.getMediaView().setMediaContent(nativeAd.getMediaContent());
        if (nativeAd.getBody() == null) {
            adView.getBodyView().setVisibility(View.INVISIBLE);
        } else {
            adView.getBodyView().setVisibility(View.VISIBLE);
            ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
        }

        if (nativeAd.getCallToAction() == null) {
            adView.getCallToActionView().setVisibility(View.INVISIBLE);
        } else {
            adView.getCallToActionView().setVisibility(View.VISIBLE);
            ((Button) adView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }

        if (nativeAd.getIcon() == null) {
            adView.getIconView().setVisibility(View.GONE);
        } else {
            ((ImageView) adView.getIconView()).setImageDrawable(
                    nativeAd.getIcon().getDrawable());
            adView.getIconView().setVisibility(View.VISIBLE);
        }

        if (nativeAd.getPrice() == null) {
            adView.getPriceView().setVisibility(View.INVISIBLE);
        } else {
            adView.getPriceView().setVisibility(View.VISIBLE);
            ((TextView) adView.getPriceView()).setText(nativeAd.getPrice());
        }

        if (nativeAd.getStore() == null) {
            adView.getStoreView().setVisibility(View.INVISIBLE);
        } else {
            adView.getStoreView().setVisibility(View.VISIBLE);
            ((TextView) adView.getStoreView()).setText(nativeAd.getStore());
        }

        if (nativeAd.getStarRating() == null) {
            adView.getStarRatingView().setVisibility(View.INVISIBLE);
        } else {
            ((RatingBar) adView.getStarRatingView())
                    .setRating(nativeAd.getStarRating().floatValue());
            adView.getStarRatingView().setVisibility(View.VISIBLE);
        }

        if (nativeAd.getAdvertiser() == null) {
            adView.getAdvertiserView().setVisibility(View.GONE);
        } else {
            ((TextView) adView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
            adView.getAdvertiserView().setVisibility(View.GONE);
        }
        adView.setNativeAd(nativeAd);
    }
}