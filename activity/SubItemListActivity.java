package com.varni.paneerrecipesinenglish.activity;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.varni.paneerrecipesinenglish.adapter.RecyclerAdapter;
import com.varni.paneerrecipesinenglish.database.SQLiteHelper;
import com.varni.paneerrecipesinenglish.model.DataModel;
import com.varni.paneerrecipesinenglish.utils.Constants;
import java.util.ArrayList;

public class SubItemListActivity
  extends AppCompatActivity
{
  int Position;
  private String TAG = getClass().getSimpleName();
  RelativeLayout adViewLayout;
  private RecyclerAdapter adapter;
  private ArrayList<DataModel> arrayList;
  Activity context = this;
  private SQLiteHelper helper;
  private RecyclerView recyclerView;
  private Toolbar toolbar;
  
  private void initViews()
  {
    this.recyclerView.setHasFixedSize(true);
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getApplicationContext());
    this.recyclerView.setLayoutManager(localLinearLayoutManager);
    this.adapter = new RecyclerAdapter(this.context, this.arrayList);
    this.recyclerView.setAdapter(this.adapter);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968609);
    this.adViewLayout = ((RelativeLayout)findViewById(2131558538));
    try
    {
      if (Constants.isCheckInternetcon(this.context))
      {
        if (Constants.bannerAdStatus == 1) {
          Constants.loadStartappBannerAd(this.context, this.adViewLayout);
        }
        for (;;)
        {
          Constants.callTouch(this.context);
          this.toolbar = ((Toolbar)findViewById(2131558619));
          setSupportActionBar(this.toolbar);
          getSupportActionBar().setDisplayHomeAsUpEnabled(true);
          this.toolbar.setNavigationOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              SubItemListActivity.this.onBackPressed();
            }
          });
          this.toolbar.setTitleTextColor(getResources().getColor(2131492958));
          this.helper = new SQLiteHelper(this.context);
          this.arrayList = this.helper.dataOfPaneer();
          this.recyclerView = ((RecyclerView)findViewById(2131558563));
          initViews();
          return;
          if (Constants.bannerAdStatus == 2) {
            Constants.loadAdmobBannerAd(this.context, this.adViewLayout);
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        this.adViewLayout.setVisibility(8);
      }
    }
  }
}


/* Location:              D:\Chandresh\reverse engineering\1\dex2jar & jd-gui\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar!\com\varni\paneerrecipesinenglish\activity\SubItemListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */