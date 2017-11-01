package com.varni.paneerrecipesinenglish.model;

import java.io.Serializable;

public class Ad_units
  implements Serializable
{
  private String AdmobAppID;
  private String BannerAdunitID;
  private String InterstitalAdunitID;
  private String NativeUnitID;
  private String RewardVideoUnitID;
  private String StartappID;
  private String ad_unit_id;
  private String application_id;
  private String created;
  private String updated;
  
  public String getAd_unit_id()
  {
    return this.ad_unit_id;
  }
  
  public String getAdmobAppID()
  {
    return this.AdmobAppID;
  }
  
  public String getApplication_id()
  {
    return this.application_id;
  }
  
  public String getBannerAdunitID()
  {
    return this.BannerAdunitID;
  }
  
  public String getCreated()
  {
    return this.created;
  }
  
  public String getInterstitalAdunitID()
  {
    return this.InterstitalAdunitID;
  }
  
  public String getNativeUnitID()
  {
    return this.NativeUnitID;
  }
  
  public String getRewardVideoUnitID()
  {
    return this.RewardVideoUnitID;
  }
  
  public String getStartappID()
  {
    return this.StartappID;
  }
  
  public String getUpdated()
  {
    return this.updated;
  }
  
  public void setAd_unit_id(String paramString)
  {
    this.ad_unit_id = paramString;
  }
  
  public void setAdmobAppID(String paramString)
  {
    this.AdmobAppID = paramString;
  }
  
  public void setApplication_id(String paramString)
  {
    this.application_id = paramString;
  }
  
  public void setBannerAdunitID(String paramString)
  {
    this.BannerAdunitID = paramString;
  }
  
  public void setCreated(String paramString)
  {
    this.created = paramString;
  }
  
  public void setInterstitalAdunitID(String paramString)
  {
    this.InterstitalAdunitID = paramString;
  }
  
  public void setNativeUnitID(String paramString)
  {
    this.NativeUnitID = paramString;
  }
  
  public void setRewardVideoUnitID(String paramString)
  {
    this.RewardVideoUnitID = paramString;
  }
  
  public void setStartappID(String paramString)
  {
    this.StartappID = paramString;
  }
  
  public void setUpdated(String paramString)
  {
    this.updated = paramString;
  }
  
  public String toString()
  {
    return "ClassPojo [NativeUnitID = " + this.NativeUnitID + ", BannerAdunitID = " + this.BannerAdunitID + ", AdmobAppID = " + this.AdmobAppID + ", updated = " + this.updated + ", created = " + this.created + ", RewardVideoUnitID = " + this.RewardVideoUnitID + ", StartappID = " + this.StartappID + ", InterstitalAdunitID = " + this.InterstitalAdunitID + ", application_id = " + this.application_id + ", ad_unit_id = " + this.ad_unit_id + "]";
  }
}


/* Location:              D:\Chandresh\reverse engineering\1\dex2jar & jd-gui\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar!\com\varni\paneerrecipesinenglish\model\Ad_units.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */