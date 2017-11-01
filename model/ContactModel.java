package com.varni.paneerrecipesinenglish.model;

public class ContactModel
{
  String city;
  String country;
  String email;
  String name;
  String number;
  String state;
  
  public String getCity()
  {
    return this.city;
  }
  
  public String getCountry()
  {
    return this.country;
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getNumber()
  {
    return this.number;
  }
  
  public String getState()
  {
    return this.state;
  }
  
  public void setCity(String paramString)
  {
    this.city = paramString;
  }
  
  public void setCountry(String paramString)
  {
    this.country = paramString;
  }
  
  public void setEmail(String paramString)
  {
    this.email = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setNumber(String paramString)
  {
    this.number = paramString;
  }
  
  public void setState(String paramString)
  {
    this.state = paramString;
  }
  
  public String toString()
  {
    return "ContactModel{name='" + this.name + '\'' + ", number='" + this.number + '\'' + ", city='" + this.city + '\'' + ", country='" + this.country + '\'' + ", email='" + this.email + '\'' + ", state='" + this.state + '\'' + '}';
  }
}


/* Location:              D:\Chandresh\reverse engineering\1\dex2jar & jd-gui\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar!\com\varni\paneerrecipesinenglish\model\ContactModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */