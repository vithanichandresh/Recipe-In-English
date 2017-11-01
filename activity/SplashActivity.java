package com.varni.paneerrecipesinenglish.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import com.crashlytics.android.Crashlytics;
import com.varni.paneerrecipesinenglish.model.Ad_status;
import com.varni.paneerrecipesinenglish.model.Ad_units;
import com.varni.paneerrecipesinenglish.model.ResponseParam;
import com.varni.paneerrecipesinenglish.utils.Constants;
import com.varni.paneerrecipesinenglish.utils.PrefUtils;
import com.varni.paneerrecipesinenglish.utils.PrivacyClass;
import com.varni.paneerrecipesinenglish.webapi.ApiClient;
import com.varni.paneerrecipesinenglish.webapi.ApiInterface;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SplashActivity
  extends AppCompatActivity
{
  private String TAG = getClass().getSimpleName();
  private ArrayList<Ad_status> ad_statuses = new ArrayList();
  private ArrayList<Ad_units> ad_unitses = new ArrayList();
  Activity context = this;
  
  private void getAdStatusInfo()
  {
    ((ApiInterface)ApiClient.getClient().create(ApiInterface.class)).getAdsStatus().enqueue(new Callback()
    {
      public void onFailure(Call<ResponseParam> paramAnonymousCall, Throwable paramAnonymousThrowable)
      {
        Log.i(SplashActivity.this.TAG, "onFailure: ");
      }
      
      public void onResponse(Call<ResponseParam> paramAnonymousCall, Response<ResponseParam> paramAnonymousResponse)
      {
        try
        {
          if ((paramAnonymousResponse.body() != null) && (((ResponseParam)paramAnonymousResponse.body()).getStatus().equalsIgnoreCase("1")))
          {
            SplashActivity.access$002(SplashActivity.this, ((ResponseParam)paramAnonymousResponse.body()).getAd_status());
            Constants.splashAdStatus = Integer.parseInt(((Ad_status)SplashActivity.this.ad_statuses.get(0)).getStatus());
            Constants.returnAdStatus = Integer.parseInt(((Ad_status)SplashActivity.this.ad_statuses.get(1)).getStatus());
            Constants.sliderAdStatus = Integer.parseInt(((Ad_status)SplashActivity.this.ad_statuses.get(2)).getStatus());
            Constants.bannerAdStatus = Integer.parseInt(((Ad_status)SplashActivity.this.ad_statuses.get(3)).getStatus());
            Constants.interstitalAdStatus = Integer.parseInt(((Ad_status)SplashActivity.this.ad_statuses.get(4)).getStatus());
            Constants.rewardStatus = Integer.parseInt(((Ad_status)SplashActivity.this.ad_statuses.get(5)).getStatus());
            Constants.nativeAdStatus = Integer.parseInt(((Ad_status)SplashActivity.this.ad_statuses.get(6)).getStatus());
            SplashActivity.this.getAdsInfo();
          }
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    });
  }
  
  private void getAdsInfo()
  {
    ((ApiInterface)ApiClient.getClient().create(ApiInterface.class)).getAdsIdsList(String.valueOf(Constants.AppId)).enqueue(new Callback()
    {
      public void onFailure(Call<ResponseParam> paramAnonymousCall, Throwable paramAnonymousThrowable)
      {
        Log.i(SplashActivity.this.TAG, "onFailure: ");
      }
      
      public void onResponse(Call<ResponseParam> paramAnonymousCall, Response<ResponseParam> paramAnonymousResponse)
      {
        try
        {
          if ((paramAnonymousResponse.body() != null) && (((ResponseParam)paramAnonymousResponse.body()).getStatus().equalsIgnoreCase("1")))
          {
            SplashActivity.access$302(SplashActivity.this, ((ResponseParam)paramAnonymousResponse.body()).getAd_units());
            Constants.ad_unit_id = ((Ad_units)SplashActivity.this.ad_unitses.get(0)).getAd_unit_id();
            Constants.AppId = ((Ad_units)SplashActivity.this.ad_unitses.get(0)).getApplication_id();
            Constants.StartappID = ((Ad_units)SplashActivity.this.ad_unitses.get(0)).getStartappID();
            Constants.AdmobAppID = ((Ad_units)SplashActivity.this.ad_unitses.get(0)).getAdmobAppID();
            Constants.BannerAdunitID = ((Ad_units)SplashActivity.this.ad_unitses.get(0)).getBannerAdunitID();
            Constants.InterstitalAdunitID = ((Ad_units)SplashActivity.this.ad_unitses.get(0)).getInterstitalAdunitID();
            Constants.RewardVideoUnitID = ((Ad_units)SplashActivity.this.ad_unitses.get(0)).getRewardVideoUnitID();
            Constants.NativeUnitID = ((Ad_units)SplashActivity.this.ad_unitses.get(0)).getNativeUnitID();
            Intent localIntent = new Intent(SplashActivity.this.getApplicationContext(), HomeActivity.class);
            SplashActivity.this.startActivity(localIntent);
            SplashActivity.this.finish();
          }
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Kit[] arrayOfKit = new Kit[1];
    arrayOfKit[0] = new Crashlytics();
    Fabric.with(this, arrayOfKit);
    setContentView(2130968608);
    getWindow().setFlags(1024, 1024);
    PrivacyClass localPrivacyClass = new PrivacyClass(getApplicationContext(), this);
    if (PrefUtils.getintPref(Constants.PrivacyAccept, this) == 0)
    {
      localPrivacyClass.show();
      return;
    }
    if (Constants.isCheckInternetcon(this.context))
    {
      getAdStatusInfo();
      return;
    }
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        Intent localIntent = new Intent(SplashActivity.this, HomeActivity.class);
        SplashActivity.this.startActivity(localIntent);
        SplashActivity.this.finish();
      }
    }, Constants.SPLASH_TIME_OUT);
  }
}


/* Location:              D:\Chandresh\reverse engineering\1\dex2jar & jd-gui\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar!\com\varni\paneerrecipesinenglish\activity\SplashActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */