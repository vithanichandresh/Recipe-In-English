package com.varni.paneerrecipesinenglish.service;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.varni.paneerrecipesinenglish.utils.Constants;
import com.varni.paneerrecipesinenglish.utils.PrefUtils;

public class MyFirebaseInstanceIDService
  extends FirebaseInstanceIdService
{
  private String TAG = getClass().getSimpleName();
  Context context = this;
  
  private void sendRegistrationToServer(String paramString) {}
  
  private void storeRegIdInPref(String paramString)
  {
    SharedPreferences.Editor localEditor = getApplicationContext().getSharedPreferences("ah_firebase", 0).edit();
    localEditor.putString("regId", paramString);
    localEditor.commit();
  }
  
  public void onTokenRefresh()
  {
    super.onTokenRefresh();
    Log.i(this.TAG, "onTokenRefresh: sd");
    String str = FirebaseInstanceId.getInstance().getToken();
    PrefUtils.putToken(Constants.PrefeKeyToken, str, this.context);
    storeRegIdInPref(str);
    sendRegistrationToServer(str);
    Intent localIntent = new Intent("registrationComplete");
    localIntent.putExtra("token", str);
    LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);
  }
}


/* Location:              D:\Chandresh\reverse engineering\1\dex2jar & jd-gui\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar!\com\varni\paneerrecipesinenglish\service\MyFirebaseInstanceIDService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */