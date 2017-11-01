package com.varni.paneerrecipesinenglish.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.varni.paneerrecipesinenglish.activity.HomeActivity;

public class PrivacyClass
{
  Context context;
  private Activity mContext;
  
  public PrivacyClass(Context paramContext, Activity paramActivity)
  {
    this.mContext = paramActivity;
    this.context = paramContext;
  }
  
  private PackageInfo getPackageInfo()
  {
    try
    {
      PackageInfo localPackageInfo = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1);
      return localPackageInfo;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
    return null;
  }
  
  public void show()
  {
    PackageInfo localPackageInfo = getPackageInfo();
    if (PrefUtils.getintPref(" ", this.mContext) == 0)
    {
      String str = this.mContext.getString(2131165255) + " " + localPackageInfo.versionName;
      this.mContext.setRequestedOrientation(1);
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.mContext);
      View localView = this.mContext.getLayoutInflater().inflate(2130968626, null);
      localBuilder.setView(localView);
      localBuilder.setCancelable(false);
      TextView localTextView = (TextView)localView.findViewById(2131558585);
      ((TextView)localView.findViewById(2131558587)).setText(2131165278);
      localTextView.setText(str);
      Button localButton1 = (Button)localView.findViewById(2131558589);
      Button localButton2 = (Button)localView.findViewById(2131558588);
      final AlertDialog localAlertDialog = localBuilder.create();
      localButton2.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          PrefUtils.putintPref(Constants.PrivacyAccept, 1, PrivacyClass.this.mContext);
          localAlertDialog.dismiss();
          PrivacyClass.this.mContext.setRequestedOrientation(4);
          new Handler().postDelayed(new Runnable()
          {
            public void run()
            {
              if (Constants.isCheckInternetcon(PrivacyClass.this.mContext))
              {
                Intent localIntent1 = new Intent(PrivacyClass.this.mContext, HomeActivity.class);
                PrivacyClass.this.mContext.startActivity(localIntent1);
                PrivacyClass.this.mContext.finish();
                return;
              }
              Intent localIntent2 = new Intent(PrivacyClass.this.mContext, HomeActivity.class);
              PrivacyClass.this.mContext.startActivity(localIntent2);
              PrivacyClass.this.mContext.finish();
            }
          }, Constants.SPLASH_TIME_OUT);
        }
      });
      localButton1.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          localAlertDialog.dismiss();
          PrefUtils.putintPref(Constants.PrivacyAccept, 2, PrivacyClass.this.mContext);
          PrivacyClass.this.mContext.setRequestedOrientation(4);
          PrivacyClass.this.mContext.setRequestedOrientation(4);
          new Handler().postDelayed(new Runnable()
          {
            public void run()
            {
              Intent localIntent = new Intent(PrivacyClass.this.mContext, HomeActivity.class);
              PrivacyClass.this.mContext.startActivity(localIntent);
              PrivacyClass.this.mContext.finish();
            }
          }, Constants.SPLASH_TIME_OUT);
        }
      });
      localAlertDialog.show();
    }
  }
}


/* Location:              D:\Chandresh\reverse engineering\1\dex2jar & jd-gui\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar!\com\varni\paneerrecipesinenglish\utils\PrivacyClass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */