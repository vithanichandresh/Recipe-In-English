package com.varni.paneerrecipesinenglish.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.NotificationCompat.BigPictureStyle;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.NotificationCompat.InboxStyle;
import android.text.Html;
import android.text.TextUtils;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.Map;

public class MyFirebaseMessagingService
  extends FirebaseMessagingService
{
  private String TAG = getClass().getSimpleName();
  
  private void sendNotification(String paramString1, String paramString2, NotificationCompat.Builder paramBuilder, int paramInt, PendingIntent paramPendingIntent, long paramLong, Bitmap paramBitmap, String paramString3, Uri paramUri)
  {
    NotificationCompat.BigPictureStyle localBigPictureStyle = new NotificationCompat.BigPictureStyle();
    localBigPictureStyle.setBigContentTitle(paramString1);
    localBigPictureStyle.setSummaryText(Html.fromHtml(paramString2).toString());
    localBigPictureStyle.bigPicture(paramBitmap);
    Intent localIntent = new Intent("android.intent.action.VIEW");
    if (!TextUtils.isEmpty(paramString3)) {
      localIntent.setData(Uri.parse(paramString3));
    }
    Notification localNotification = paramBuilder.setSmallIcon(paramInt).setTicker(paramString1).setWhen(0L).setAutoCancel(true).setContentTitle(paramString1).setContentIntent(paramPendingIntent).setSound(paramUri).setStyle(localBigPictureStyle).setWhen(paramLong).setSmallIcon(2130903040).setLargeIcon(BitmapFactory.decodeResource(getResources(), paramInt)).setContentText(paramString2).build();
    ((NotificationManager)getSystemService("notification")).notify((int)paramLong, localNotification);
  }
  
  private void showSmallNotification(String paramString1, String paramString2, NotificationCompat.Builder paramBuilder, int paramInt, PendingIntent paramPendingIntent, long paramLong, String paramString3, Uri paramUri)
  {
    NotificationCompat.InboxStyle localInboxStyle = new NotificationCompat.InboxStyle();
    localInboxStyle.addLine(paramString2);
    Intent localIntent = new Intent("android.intent.action.VIEW");
    if (!TextUtils.isEmpty(paramString3)) {
      localIntent.setData(Uri.parse(paramString3));
    }
    Notification localNotification = paramBuilder.setSmallIcon(paramInt).setTicker(paramString1).setWhen(0L).setAutoCancel(true).setContentTitle(paramString1).setContentIntent(paramPendingIntent).setSound(paramUri).setStyle(localInboxStyle).setWhen(paramLong).setSmallIcon(2130903040).setLargeIcon(BitmapFactory.decodeResource(getResources(), paramInt)).setContentText(paramString2).build();
    ((NotificationManager)getSystemService("notification")).notify((int)paramLong, localNotification);
  }
  
  public Bitmap getBitmapFromURL(String paramString)
  {
    Object localObject = null;
    if (paramString != null) {}
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
      localHttpURLConnection.setDoInput(true);
      localHttpURLConnection.connect();
      Bitmap localBitmap = BitmapFactory.decodeStream(localHttpURLConnection.getInputStream());
      localObject = localBitmap;
      return (Bitmap)localObject;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return null;
  }
  
  public void onMessageReceived(RemoteMessage paramRemoteMessage)
  {
    String str1;
    String str2;
    String str3;
    long l;
    NotificationCompat.Builder localBuilder;
    Uri localUri;
    PendingIntent localPendingIntent;
    if (paramRemoteMessage.getData().size() > 0)
    {
      str1 = (String)paramRemoteMessage.getData().get("message");
      str2 = (String)paramRemoteMessage.getData().get("title");
      str3 = (String)paramRemoteMessage.getData().get("image_url");
      String str4 = (String)paramRemoteMessage.getData().get("url");
      l = Calendar.getInstance().getTimeInMillis();
      Bitmap localBitmap = getBitmapFromURL(str3);
      localBuilder = new NotificationCompat.Builder(this);
      localUri = Uri.parse("android.resource://" + getPackageName() + "/raw/notification");
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(str4));
      localIntent.setFlags(603979776);
      localPendingIntent = PendingIntent.getActivity(this, 0, localIntent, 268435456);
      if (localBitmap != null) {
        sendNotification(str2, str1, localBuilder, 2130903040, localPendingIntent, l, localBitmap, str3, localUri);
      }
    }
    else
    {
      return;
    }
    showSmallNotification(str2, str1, localBuilder, 2130903040, localPendingIntent, l, str3, localUri);
  }
}


/* Location:              D:\Chandresh\reverse engineering\1\dex2jar & jd-gui\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar!\com\varni\paneerrecipesinenglish\service\MyFirebaseMessagingService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */