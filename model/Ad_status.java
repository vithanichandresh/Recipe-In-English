package com.varni.paneerrecipesinenglish.model;

import java.io.Serializable;

public class Ad_status
  implements Serializable
{
  private String add_on_id;
  private String filed_name;
  private String status;
  
  public String getAdd_on_id()
  {
    return this.add_on_id;
  }
  
  public String getFiled_name()
  {
    return this.filed_name;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setAdd_on_id(String paramString)
  {
    this.add_on_id = paramString;
  }
  
  public void setFiled_name(String paramString)
  {
    this.filed_name = paramString;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
  
  public String toString()
  {
    return "ClassPojo [status = " + this.status + ", filed_name = " + this.filed_name + ", add_on_id = " + this.add_on_id + "]";
  }
}


/* Location:              D:\Chandresh\reverse engineering\1\dex2jar & jd-gui\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar!\com\varni\paneerrecipesinenglish\model\Ad_status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */