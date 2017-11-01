package com.varni.paneerrecipesinenglish.model;

import java.util.ArrayList;

public class ResponseParam
{
  private ArrayList<Ad_status> ad_status;
  private ArrayList<Ad_units> ad_units;
  private String msg;
  private String status;
  
  public ArrayList<Ad_status> getAd_status()
  {
    return this.ad_status;
  }
  
  public ArrayList<Ad_units> getAd_units()
  {
    return this.ad_units;
  }
  
  public String getMsg()
  {
    return this.msg;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setAd_status(ArrayList<Ad_status> paramArrayList)
  {
    this.ad_status = paramArrayList;
  }
  
  public void setAd_units(ArrayList<Ad_units> paramArrayList)
  {
    this.ad_units = paramArrayList;
  }
  
  public void setMsg(String paramString)
  {
    this.msg = paramString;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
  
  public String toString()
  {
    return "ResponseParam{status='" + this.status + '\'' + ", msg='" + this.msg + '\'' + ", ad_units=" + this.ad_units + ", ad_status=" + this.ad_status + '}';
  }
}


/* Location:              D:\Chandresh\reverse engineering\1\dex2jar & jd-gui\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar!\com\varni\paneerrecipesinenglish\model\ResponseParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */