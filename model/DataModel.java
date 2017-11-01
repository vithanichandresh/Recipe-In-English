package com.varni.paneerrecipesinenglish.model;

import java.io.Serializable;

public class DataModel
  implements Serializable
{
  String content;
  String id;
  String image;
  String method;
  String name;
  
  public String getContent()
  {
    return this.content;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getImage()
  {
    return this.image;
  }
  
  public String getMethod()
  {
    return this.method;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setImage(String paramString)
  {
    this.image = paramString;
  }
  
  public void setMethod(String paramString)
  {
    this.method = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
}


/* Location:              D:\Chandresh\reverse engineering\1\dex2jar & jd-gui\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar!\com\varni\paneerrecipesinenglish\model\DataModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */