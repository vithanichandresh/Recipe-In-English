package com.varni.paneerrecipesinenglish.model;

public class ResponseGetAds
{
  private Image_data image_data;
  private String msg;
  private String status;
  
  public Image_data getImage_data()
  {
    return this.image_data;
  }
  
  public String getMsg()
  {
    return this.msg;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setImage_data(Image_data paramImage_data)
  {
    this.image_data = paramImage_data;
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
    return "ClassPojo [image_data = " + this.image_data + ", status = " + this.status + ", msg = " + this.msg + "]";
  }
}


/* Location:              D:\Chandresh\reverse engineering\1\dex2jar & jd-gui\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar!\com\varni\paneerrecipesinenglish\model\ResponseGetAds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */