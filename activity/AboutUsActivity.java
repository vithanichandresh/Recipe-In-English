package com.varni.paneerrecipesinenglish.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class AboutUsActivity
  extends AppCompatActivity
{
  Activity context = this;
  LinearLayout gotoPrivacy;
  Toolbar toolbar;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968603);
    this.toolbar = ((Toolbar)findViewById(2131558619));
    this.gotoPrivacy = ((LinearLayout)findViewById(2131558537));
    this.toolbar.setTitle("About Us");
    this.toolbar.setTitleTextColor(getResources().getColor(2131492958));
    setSupportActionBar(this.toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    this.toolbar.setNavigationOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AboutUsActivity.this.onBackPressed();
      }
    });
    this.gotoPrivacy.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AboutUsActivity.this.startActivity(new Intent(AboutUsActivity.this.context, PrivacyPolicyActivity.class));
      }
    });
  }
}


/* Location:              D:\Chandresh\reverse engineering\1\dex2jar & jd-gui\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar!\com\varni\paneerrecipesinenglish\activity\AboutUsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */