package com.varni.paneerrecipesinenglish.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Handler;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.startapp.android.publish.ads.banner.Banner;
import com.varni.paneerrecipesinenglish.activity.HomeActivity;

public class Constants
{
  public static String AdmobAppID;
  public static String AppId = "102";
  public static String BannerAdunitID;
  public static String IMEI;
  public static String InterstitalAdunitID;
  public static String NativeUnitID;
  public static final int PERMISSION_CALLBACK_CONSTANT = 111;
  public static final String PUSH_NOTIFICATION = "pushNotification";
  public static String PrefeKeyCount;
  public static String PrefeKeyToken;
  public static String PrivacyAccept;
  public static final String REGISTRATION_COMPLETE = "registrationComplete";
  public static final int REQUEST_PERMISSION_SETTING = 200;
  public static String RegId;
  public static String RewardVideoUnitID;
  public static final String SHARED_PREF = "ah_firebase";
  public static int SPLASH_TIME_OUT = 2000;
  public static String StartappID;
  public static String ad_unit_id;
  public static int bannerAdStatus;
  public static int count;
  public static int interstitalAdStatus;
  public static int nativeAdStatus;
  public static int returnAdStatus;
  public static int rewardStatus;
  public static String sArrayPrefKey;
  public static String sStoreBoolean;
  public static int sliderAdStatus;
  public static int splashAdStatus;
  
  static
  {
    PrivacyAccept = "Accepted";
    PrefeKeyCount = "count";
    sArrayPrefKey = "array";
    sStoreBoolean = "saveBoolean";
    count = 0;
    PrefeKeyToken = "firebase";
    IMEI = "";
    RegId = "";
  }
  
  public static void callTouch(Activity paramActivity)
  {
    try
    {
      if (HomeActivity.displayAppAds(paramActivity)) {
        PrefUtils.alertDialogShow(paramActivity);
      }
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      localNullPointerException.printStackTrace();
    }
  }
  
  public static boolean isCheckInternetcon(Context paramContext)
  {
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localConnectivityManager != null)
    {
      NetworkInfo[] arrayOfNetworkInfo = localConnectivityManager.getAllNetworkInfo();
      if (arrayOfNetworkInfo != null) {
        for (int i = 0; i < arrayOfNetworkInfo.length; i++) {
          if (arrayOfNetworkInfo[i].getState() == NetworkInfo.State.CONNECTED) {
            return true;
          }
        }
      }
      new Handler(paramContext.getMainLooper()).post(new Runnable()
      {
        public void run() {}
      });
    }
    return false;
  }
  
  public static void loadAdmobBannerAd(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    AdView localAdView = new AdView(paramContext);
    localAdView.setAdSize(AdSize.SMART_BANNER);
    localAdView.setAdUnitId(BannerAdunitID);
    localAdView.loadAd(new AdRequest.Builder().addTestDevice("2DED1FDABFA58E13EE3942119FC95EBE").build());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(14);
    paramRelativeLayout.addView(localAdView, localLayoutParams);
  }
  
  public static void loadStartappBannerAd(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    Banner localBanner = new Banner(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(14);
    localLayoutParams.addRule(12);
    paramRelativeLayout.addView(localBanner, localLayoutParams);
  }
}


/* Location:              D:\Chandresh\reverse engineering\1\dex2jar & jd-gui\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar!\com\varni\paneerrecipesinenglish\utils\Constants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */