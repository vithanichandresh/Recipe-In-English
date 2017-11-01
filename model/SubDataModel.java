package com.varni.paneerrecipesinenglish.model;

import java.io.Serializable;

public class SubDataModel
  implements Serializable
{
  String benefits;
  String cat_name;
  String category_id;
  String favorite;
  String image;
  String method;
  String mudra_id;
  String mudra_name;
  String mudra_name_eng;
  
  public String getBenefits()
  {
    return this.benefits;
  }
  
  public String getCat_name()
  {
    return this.cat_name;
  }
  
  public String getCategory_id()
  {
    return this.category_id;
  }
  
  public String getFavorite()
  {
    return this.favorite;
  }
  
  public String getImage()
  {
    return this.image;
  }
  
  public String getMethod()
  {
    return this.method;
  }
  
  public String getMudra_id()
  {
    return this.mudra_id;
  }
  
  public String getMudra_name()
  {
    return this.mudra_name;
  }
  
  public String getMudra_name_eng()
  {
    return this.mudra_name_eng;
  }
  
  public void setBenefits(String paramString)
  {
    this.benefits = paramString;
  }
  
  public void setCat_name(String paramString)
  {
    this.cat_name = paramString;
  }
  
  public void setCategory_id(String paramString)
  {
    this.category_id = paramString;
  }
  
  public void setFavorite(String paramString)
  {
    this.favorite = paramString;
  }
  
  public void setImage(String paramString)
  {
    this.image = paramString;
  }
  
  public void setMethod(String paramString)
  {
    this.method = paramString;
  }
  
  public void setMudra_id(String paramString)
  {
    this.mudra_id = paramString;
  }
  
  public void setMudra_name(String paramString)
  {
    this.mudra_name = paramString;
  }
  
  public void setMudra_name_eng(String paramString)
  {
    this.mudra_name_eng = paramString;
  }
  
  public String toString()
  {
    return "SubDataModel{mudra_id='" + this.mudra_id + '\'' + ", category_id='" + this.category_id + '\'' + ", mudra_name='" + this.mudra_name + '\'' + ", method='" + this.method + '\'' + ", benefits='" + this.benefits + '\'' + ", image='" + this.image + '\'' + ", mudra_name_eng='" + this.mudra_name_eng + '\'' + ", cat_name='" + this.cat_name + '\'' + ", favorite='" + this.favorite + '\'' + '}';
  }
}


/* Location:              D:\Chandresh\reverse engineering\1\dex2jar & jd-gui\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar!\com\varni\paneerrecipesinenglish\model\SubDataModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */