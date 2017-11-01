package com.varni.paneerrecipesinenglish.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.varni.paneerrecipesinenglish.model.Image_data;
import com.varni.paneerrecipesinenglish.model.ResponseGetAds;
import com.varni.paneerrecipesinenglish.webapi.ApiClient;
import com.varni.paneerrecipesinenglish.webapi.ApiInterface;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PrefUtils
{
  static SharedPreferences sharedPrefs;
  
  public static boolean LoadBoolean(Activity paramActivity)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramActivity.getApplicationContext()).getBoolean(Constants.sStoreBoolean, false);
  }
  
  public static int LoadInt(Activity paramActivity)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramActivity.getApplicationContext()).getInt(Constants.PrefeKeyCount, 0);
  }
  
  public static void SaveBoolean(String paramString, boolean paramBoolean, Activity paramActivity)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramActivity.getApplicationContext()).edit();
    localEditor.putBoolean(paramString, paramBoolean);
    localEditor.commit();
  }
  
  public static void SaveInt(String paramString, int paramInt, Activity paramActivity)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramActivity.getApplicationContext()).edit();
    localEditor.putInt(paramString, paramInt);
    localEditor.commit();
  }
  
  public static void alertDialogShow(Context paramContext)
  {
    loadAds(paramContext);
  }
  
  public static String getToken(String paramString, Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString, null);
  }
  
  public static int getintPref(String paramString, Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString, 0);
  }
  
  public static void loadAds(Context paramContext)
  {
    ((ApiInterface)ApiClient.getClient().create(ApiInterface.class)).getImage().enqueue(new retrofit2.Callback()
    {
      public void onFailure(Call<ResponseGetAds> paramAnonymousCall, Throwable paramAnonymousThrowable) {}
      
      public void onResponse(Call<ResponseGetAds> paramAnonymousCall, final Response<ResponseGetAds> paramAnonymousResponse)
      {
        try
        {
          final Dialog localDialog = new Dialog(this.val$context, 2131296639);
          localDialog.requestWindowFeature(1);
          localDialog.setCancelable(true);
          localDialog.setContentView(2130968625);
          WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
          localLayoutParams.copyFrom(localDialog.getWindow().getAttributes());
          localLayoutParams.width = -1;
          localLayoutParams.height = -1;
          localDialog.getWindow().setAttributes(localLayoutParams);
          final ImageView localImageView1 = (ImageView)localDialog.findViewById(2131558583);
          final ImageView localImageView2 = (ImageView)localDialog.findViewById(2131558584);
          Picasso.with(this.val$context).load(((ResponseGetAds)paramAnonymousResponse.body()).getImage_data().getImage_location()).into(localImageView1, new com.squareup.picasso.Callback()
          {
            public void onError()
            {
              localDialog.dismiss();
            }
            
            public void onSuccess()
            {
              if (!((Activity)PrefUtils.1.this.val$context).isFinishing()) {
                localDialog.show();
              }
              localImageView1.setOnClickListener(new View.OnClickListener()
              {
                public void onClick(View paramAnonymous3View)
                {
                  try
                  {
                    PrefUtils.1.this.val$context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(((ResponseGetAds)PrefUtils.1.1.this.val$response.body()).getImage_data().getUrl())));
                    return;
                  }
                  catch (Exception localException)
                  {
                    localException.printStackTrace();
                  }
                }
              });
              localImageView2.setOnClickListener(new View.OnClickListener()
              {
                public void onClick(View paramAnonymous3View)
                {
                  PrefUtils.1.1.this.val$dialog.dismiss();
                }
              });
            }
          });
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    });
  }
  
  public static void putArrayList(String paramString, ArrayList paramArrayList, Activity paramActivity)
  {
    try
    {
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramActivity).edit();
      localEditor.putString(paramString, new Gson().toJson(paramArrayList));
      localEditor.apply();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static void putToken(String paramString1, String paramString2, Context paramContext)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.apply();
  }
  
  public static void putintPref(String paramString, int paramInt, Context paramContext)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    localEditor.putInt(paramString, paramInt);
    localEditor.apply();
  }
}


/* Location:              D:\Chandresh\reverse engineering\1\dex2jar & jd-gui\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar!\com\varni\paneerrecipesinenglish\utils\PrefUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */