package com.varni.paneerrecipesinenglish.webapi;

import com.varni.paneerrecipesinenglish.model.ResponseGetAds;
import com.varni.paneerrecipesinenglish.model.ResponseParam;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public abstract interface ApiInterface
{
  @FormUrlEncoded
  @POST("/apps/index.php/api/add_contacts")
  public abstract Call<ResponseBody> PassJson_data(@Field("json_data") String paramString);
  
  @FormUrlEncoded
  @POST("/apps/index.php/api/save_device_token")
  public abstract Call<ResponseBody> SaveDeviceToken(@Field("device_id") String paramString1, @Field("device_type") String paramString2, @Field("device_token") String paramString3, @Field("application_id") String paramString4);
  
  @GET("apps/index.php/api/get_ad_unit")
  public abstract Call<ResponseParam> getAdsIdsList(@Query("application_id") String paramString);
  
  @GET("/apps/index.php/api/get_ad_status")
  public abstract Call<ResponseParam> getAdsStatus();
  
  @GET("/apps/index.php/api/get_image")
  public abstract Call<ResponseGetAds> getImage();
}


/* Location:              D:\Chandresh\reverse engineering\1\dex2jar & jd-gui\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar!\com\varni\paneerrecipesinenglish\webapi\ApiInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */