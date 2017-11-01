package com.varni.paneerrecipesinenglish.activity;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.startapp.android.publish.adsCommon.StartAppSDK;
import com.varni.paneerrecipesinenglish.service.ContactInfoService;
import com.varni.paneerrecipesinenglish.utils.Constants;
import com.varni.paneerrecipesinenglish.utils.PrefUtils;
import com.varni.paneerrecipesinenglish.webapi.ApiClient;
import com.varni.paneerrecipesinenglish.webapi.ApiInterface;
import java.io.ByteArrayOutputStream;
import java.util.Random;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeActivity
  extends AppCompatActivity
  implements View.OnClickListener
{
  private String TAG = getClass().getSimpleName();
  RelativeLayout adViewLayout;
  ApiInterface apiInterface;
  Activity context = this;
  RelativeLayout layoutAboutUs;
  RelativeLayout layoutFavorite;
  RelativeLayout layoutRecipes;
  RelativeLayout layoutShare;
  private SharedPreferences permissionStatus;
  private String[] permissions0 = { "android.permission.READ_CONTACTS", "android.permission.READ_PHONE_STATE" };
  private String[] permissions1 = { "android.permission.WRITE_EXTERNAL_STORAGE" };
  private String[] permissions2 = { "android.permission.READ_PHONE_STATE" };
  private boolean sentToSettings = false;
  private Toolbar toolbar;
  
  private void SaveDeviceInfo()
  {
    getIMEI();
    String str = PrefUtils.getToken(Constants.PrefeKeyToken, this.context);
    this.apiInterface = ((ApiInterface)ApiClient.getClient().create(ApiInterface.class));
    this.apiInterface.SaveDeviceToken(Constants.IMEI, "1", str, Constants.AppId).enqueue(new Callback()
    {
      public void onFailure(Call<ResponseBody> paramAnonymousCall, Throwable paramAnonymousThrowable) {}
      
      public void onResponse(Call<ResponseBody> paramAnonymousCall, Response<ResponseBody> paramAnonymousResponse) {}
    });
  }
  
  private void checkPermission()
  {
    if ((ActivityCompat.checkSelfPermission(this, this.permissions0[0]) != 0) || (ActivityCompat.checkSelfPermission(this, this.permissions0[1]) != 0))
    {
      if ((!ActivityCompat.shouldShowRequestPermissionRationale(this, this.permissions0[0])) || (!ActivityCompat.shouldShowRequestPermissionRationale(this, this.permissions0[1]))) {
        ActivityCompat.requestPermissions(this, this.permissions0, 0);
      }
      SharedPreferences.Editor localEditor = this.permissionStatus.edit();
      localEditor.putBoolean(this.permissions0[0], true);
      localEditor.commit();
      return;
    }
    try
    {
      if (PrefUtils.getintPref(Constants.PrivacyAccept, this) == 1) {
        startService(new Intent(this, ContactInfoService.class));
      }
      SaveDeviceInfo();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void checkPermission1()
  {
    if (ActivityCompat.checkSelfPermission(this, this.permissions1[0]) != 0)
    {
      if (ActivityCompat.shouldShowRequestPermissionRationale(this, this.permissions1[0]))
      {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
        localBuilder.setTitle("Need Permissions");
        localBuilder.setMessage("This app needs Write Storage permissions.");
        localBuilder.setPositiveButton("Grant", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            paramAnonymousDialogInterface.cancel();
            ActivityCompat.requestPermissions(HomeActivity.this, HomeActivity.this.permissions1, 111);
          }
        });
        localBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            paramAnonymousDialogInterface.cancel();
          }
        });
        localBuilder.show();
      }
      for (;;)
      {
        SharedPreferences.Editor localEditor = this.permissionStatus.edit();
        localEditor.putBoolean(this.permissions1[0], true);
        localEditor.commit();
        return;
        ActivityCompat.requestPermissions(this, this.permissions1, 111);
      }
    }
    try
    {
      share();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void checkPermission2()
  {
    if (ActivityCompat.checkSelfPermission(this, this.permissions2[0]) != 0)
    {
      if (!ActivityCompat.shouldShowRequestPermissionRationale(this, this.permissions2[0])) {
        ActivityCompat.requestPermissions(this, this.permissions2, 3);
      }
      SharedPreferences.Editor localEditor = this.permissionStatus.edit();
      localEditor.putBoolean(this.permissions2[0], true);
      localEditor.commit();
    }
    for (;;)
    {
      return;
      try
      {
        if (Constants.isCheckInternetcon(this))
        {
          SaveDeviceInfo();
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static boolean displayAppAds(Activity paramActivity)
  {
    if (PrefUtils.LoadInt(paramActivity) == 0)
    {
      Constants.count = PrefUtils.LoadInt(paramActivity);
      int i = 9 + new Random().nextInt(6);
      PrefUtils.SaveInt(Constants.PrefeKeyCount, i, paramActivity);
    }
    do
    {
      return false;
      Constants.count = 1 + Constants.count;
    } while (Constants.count != PrefUtils.LoadInt(paramActivity));
    Constants.count = 0;
    PrefUtils.SaveInt(Constants.PrefeKeyCount, 0, paramActivity);
    return true;
  }
  
  private void getIMEI()
  {
    Constants.IMEI = ((TelephonyManager)getApplicationContext().getSystemService("phone")).getDeviceId();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131558565: 
      startActivity(new Intent(this.context, SubItemListActivity.class));
      return;
    case 2131558566: 
      startActivity(new Intent(this.context, FavoriteActivity.class));
      return;
    case 2131558567: 
      checkPermission1();
      return;
    }
    startActivity(new Intent(this.context, AboutUsActivity.class));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((Constants.splashAdStatus == 1) && (Constants.StartappID != null)) {
      StartAppSDK.init(this, Constants.StartappID, true);
    }
    setContentView(2130968606);
    this.toolbar = ((Toolbar)findViewById(2131558619));
    this.layoutRecipes = ((RelativeLayout)findViewById(2131558565));
    this.layoutFavorite = ((RelativeLayout)findViewById(2131558566));
    this.layoutShare = ((RelativeLayout)findViewById(2131558567));
    this.layoutAboutUs = ((RelativeLayout)findViewById(2131558568));
    this.adViewLayout = ((RelativeLayout)findViewById(2131558538));
    try
    {
      if (Constants.isCheckInternetcon(this.context)) {
        if (Constants.bannerAdStatus == 1)
        {
          Constants.loadStartappBannerAd(this.context, this.adViewLayout);
          this.toolbar.setTitle(getResources().getString(2131165255));
          this.toolbar.setTitleTextColor(getResources().getColor(2131492958));
          setSupportActionBar(this.toolbar);
        }
      }
    }
    catch (Exception localException1)
    {
      try
      {
        this.permissionStatus = getSharedPreferences("permissionStatus", 0);
        if (PrefUtils.getintPref(Constants.PrivacyAccept, this) == 1) {
          checkPermission();
        }
        for (;;)
        {
          this.layoutRecipes.setOnClickListener(this);
          this.layoutFavorite.setOnClickListener(this);
          this.layoutShare.setOnClickListener(this);
          this.layoutAboutUs.setOnClickListener(this);
          return;
          if (Constants.bannerAdStatus != 2) {
            break;
          }
          Constants.loadAdmobBannerAd(this.context, this.adViewLayout);
          break;
          localException1 = localException1;
          localException1.printStackTrace();
          break;
          this.adViewLayout.setVisibility(8);
          break;
          checkPermission2();
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623937, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getString(2131165279))));
      continue;
      startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getString(2131165272))));
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if (paramInt == 0)
    {
      int n = 0;
      int i1 = 0;
      if (i1 < paramArrayOfInt.length)
      {
        if (paramArrayOfInt[i1] == 0) {
          n = 1;
        }
        for (;;)
        {
          i1++;
          break;
          if (paramArrayOfInt[1] != 0) {
            break label53;
          }
          SaveDeviceInfo();
        }
        label53:
        n = 0;
      }
      if (n != 0) {
        SaveDeviceInfo();
      }
    }
    int i;
    do
    {
      do
      {
        int k;
        do
        {
          return;
          if (paramInt != 2) {
            break;
          }
          k = 0;
          int m = 0;
          while (m < paramArrayOfInt.length) {
            if (paramArrayOfInt[m] == 0)
            {
              k = 1;
              m++;
            }
            else
            {
              k = 0;
            }
          }
        } while (k == 0);
        share();
        return;
      } while (paramInt != 3);
      i = 0;
      int j = 0;
      while (j < paramArrayOfInt.length) {
        if (paramArrayOfInt[j] == 0)
        {
          i = 1;
          j++;
        }
        else
        {
          i = 0;
        }
      }
    } while (i == 0);
    SaveDeviceInfo();
  }
  
  public void share()
  {
    Bitmap localBitmap = BitmapFactory.decodeResource(getResources(), 2130903040);
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setType("image/*");
    localIntent.putExtra("android.intent.extra.SUBJECT", getString(2131165282));
    localIntent.putExtra("android.intent.extra.TEXT", getString(2131165270) + " " + getString(2131165279));
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    localBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
    localIntent.putExtra("android.intent.extra.STREAM", Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(), localBitmap, getResources().getString(2131165255), null)));
    startActivity(Intent.createChooser(localIntent, "Select"));
  }
}


/* Location:              D:\Chandresh\reverse engineering\1\dex2jar & jd-gui\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar!\com\varni\paneerrecipesinenglish\activity\HomeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */