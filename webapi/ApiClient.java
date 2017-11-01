package com.varni.paneerrecipesinenglish.webapi;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient
{
  public static final String BASE_URL = "http://varniapp.com/";
  private static Retrofit retrofit = null;
  
  public static Retrofit getClient()
  {
    HttpLoggingInterceptor localHttpLoggingInterceptor = new HttpLoggingInterceptor();
    localHttpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient localOkHttpClient = new OkHttpClient.Builder().readTimeout(300L, TimeUnit.SECONDS).connectTimeout(300L, TimeUnit.SECONDS).addInterceptor(localHttpLoggingInterceptor).build();
    if (retrofit == null) {
      retrofit = new Retrofit.Builder().baseUrl("http://varniapp.com/").client(localOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
    }
    return retrofit;
  }
}


/* Location:              D:\Chandresh\reverse engineering\1\dex2jar & jd-gui\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar!\com\varni\paneerrecipesinenglish\webapi\ApiClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */