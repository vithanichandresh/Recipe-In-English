package com.varni.paneerrecipesinenglish.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class PrivacyPolicyActivity
  extends AppCompatActivity
{
  TextView textView;
  private Toolbar toolbar;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968607);
    this.toolbar = ((Toolbar)findViewById(2131558619));
    this.textView = ((TextView)findViewById(2131558569));
    this.toolbar.setTitle("Privacy Policy");
    this.toolbar.setTitleTextColor(getResources().getColor(2131492958));
    setSupportActionBar(this.toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    this.toolbar.setNavigationOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        PrivacyPolicyActivity.this.onBackPressed();
      }
    });
    this.textView.setText(getResources().getString(2131165278));
  }
}


/* Location:              D:\Chandresh\reverse engineering\1\dex2jar & jd-gui\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar!\com\varni\paneerrecipesinenglish\activity\PrivacyPolicyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */