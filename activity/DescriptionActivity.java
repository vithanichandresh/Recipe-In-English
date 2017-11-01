package com.varni.paneerrecipesinenglish.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.InterstitialAd;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.startapp.android.publish.adsCommon.StartAppAd;
import com.varni.paneerrecipesinenglish.database.SQLiteHelper;
import com.varni.paneerrecipesinenglish.model.DataModel;
import com.varni.paneerrecipesinenglish.utils.Constants;
import com.varni.paneerrecipesinenglish.widget.VerticalMarqueeTextView;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import uz.shift.colorpicker.LineColorPicker;
import uz.shift.colorpicker.OnColorChangedListener;

public class DescriptionActivity
  extends AppCompatActivity
  implements View.OnClickListener
{
  boolean AoutoScroolFlag = false;
  int Position;
  private String TAG = getClass().getSimpleName();
  RelativeLayout adViewLayout;
  ArrayList<DataModel> arrayList;
  Button btnContent;
  Button btnMethod;
  int categoryId;
  Activity context = this;
  String dataId;
  com.github.clans.fab.FloatingActionButton fabColorButton;
  android.support.design.widget.FloatingActionButton fabFavorite;
  com.github.clans.fab.FloatingActionButton fabFontButton;
  FloatingActionMenu fabMenu;
  com.github.clans.fab.FloatingActionButton fabScrollButton;
  SQLiteHelper helper;
  int id;
  ImageView imageView;
  ImageView imgPlay;
  LinearLayout layoutFont;
  LinearLayout layoutScroll;
  LineColorPicker lineColorPicker;
  LinearLayout linearLayout;
  InterstitialAd mInterstitialAd;
  SeekBar seekFont;
  SeekBar seekScroll;
  private Toolbar toolbar;
  VerticalMarqueeTextView txtContent;
  TextView txtItemName;
  
  private void interstilaAds()
  {
    if (Constants.interstitalAdStatus == 1) {
      StartAppAd.showAd(this.context);
    }
    while (Constants.interstitalAdStatus != 2) {
      return;
    }
    this.mInterstitialAd = new InterstitialAd(this);
    if ((Constants.isCheckInternetcon(this.context)) && (Constants.InterstitalAdunitID != null)) {
      this.mInterstitialAd.setAdUnitId(Constants.InterstitalAdunitID);
    }
    AdRequest localAdRequest = new AdRequest.Builder().build();
    this.mInterstitialAd.loadAd(localAdRequest);
    this.mInterstitialAd.setAdListener(new AdListener()
    {
      public void onAdLoaded()
      {
        DescriptionActivity.this.displayInterstitial();
      }
    });
  }
  
  public void colorPick()
  {
    LineColorPicker localLineColorPicker = this.lineColorPicker;
    int[] arrayOfInt = new int[19];
    arrayOfInt[0] = Color.parseColor("#F6402C");
    arrayOfInt[1] = Color.parseColor("#EB1460");
    arrayOfInt[2] = Color.parseColor("#9C1AB1");
    arrayOfInt[3] = Color.parseColor("#6633B9");
    arrayOfInt[4] = Color.parseColor("#3D4DB7");
    arrayOfInt[5] = Color.parseColor("#1093F5");
    arrayOfInt[6] = Color.parseColor("#00A6F6");
    arrayOfInt[7] = Color.parseColor("#00BBD5");
    arrayOfInt[8] = Color.parseColor("#009687");
    arrayOfInt[9] = Color.parseColor("#46AF4A");
    arrayOfInt[10] = Color.parseColor("#88C440");
    arrayOfInt[11] = Color.parseColor("#CCDD1E");
    arrayOfInt[12] = Color.parseColor("#FFEC16");
    arrayOfInt[13] = Color.parseColor("#FFC100");
    arrayOfInt[14] = Color.parseColor("#FF9800");
    arrayOfInt[15] = Color.parseColor("#FF5505");
    arrayOfInt[16] = Color.parseColor("#7A5547");
    arrayOfInt[17] = Color.parseColor("#9D9D9D");
    arrayOfInt[18] = Color.parseColor("#5E7C8B");
    localLineColorPicker.setColors(arrayOfInt);
    this.lineColorPicker.setOnColorChangedListener(new OnColorChangedListener()
    {
      public void onColorChanged(int paramAnonymousInt)
      {
        int i = DescriptionActivity.this.lineColorPicker.getColor();
        DescriptionActivity.this.txtContent.setTextColor(i);
      }
    });
  }
  
  public void displayInterstitial()
  {
    if (this.mInterstitialAd.isLoaded()) {
      this.mInterstitialAd.show();
    }
  }
  
  public void favorite()
  {
    if (this.helper.checkExists(this.dataId))
    {
      this.fabFavorite.setImageResource(2130837673);
      this.helper.updateFavorite(this.dataId, 0);
      return;
    }
    this.fabFavorite.setImageResource(2130837662);
    this.helper.updateFavorite(this.dataId, 1);
  }
  
  public void fontChanges()
  {
    this.seekFont.setProgress(14);
    this.seekFont.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
    {
      public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        DescriptionActivity.this.txtContent.setTextSize(paramAnonymousInt);
      }
      
      public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar) {}
      
      public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar) {}
    });
  }
  
  public void imageDialog()
  {
    this.imageView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Dialog localDialog = new Dialog(DescriptionActivity.this.context);
        localDialog.getWindow().requestFeature(1);
        localDialog.setContentView(DescriptionActivity.this.getLayoutInflater().inflate(2130968610, null));
        ImageView localImageView = (ImageView)localDialog.findViewById(2131558570);
        Glide.with(DescriptionActivity.this.context).load(Integer.valueOf(DescriptionActivity.this.id)).into(localImageView);
        localDialog.show();
      }
    });
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131558548: 
    case 2131558549: 
    case 2131558551: 
    case 2131558552: 
    case 2131558554: 
    case 2131558555: 
    case 2131558556: 
    case 2131558557: 
    case 2131558558: 
    default: 
      return;
    case 2131558545: 
      Constants.callTouch(this.context);
      this.btnMethod.setTextColor(getResources().getColor(2131492888));
      this.btnContent.setTextColor(getResources().getColor(2131492958));
      this.txtContent.setText(((DataModel)this.arrayList.get(this.Position)).getContent());
      return;
    case 2131558546: 
      Constants.callTouch(this.context);
      this.btnContent.setTextColor(getResources().getColor(2131492888));
      this.btnMethod.setTextColor(getResources().getColor(2131492958));
      this.txtContent.setText(((DataModel)this.arrayList.get(this.Position)).getMethod());
      return;
    case 2131558559: 
      Constants.callTouch(this.context);
      visibilityForFabColorPiker();
      this.fabMenu.close(true);
      colorPick();
      return;
    case 2131558560: 
      Constants.callTouch(this.context);
      visibilityForFabSize();
      this.fabMenu.close(true);
      fontChanges();
      return;
    case 2131558561: 
      Constants.callTouch(this.context);
      visibilityForFabScroll();
      this.fabMenu.close(true);
      scroll();
      return;
    case 2131558553: 
      Constants.callTouch(this.context);
      if (this.AoutoScroolFlag) {
        this.imgPlay.setImageResource(2130837667);
      }
      for (;;)
      {
        scroll();
        return;
        this.imgPlay.setImageResource(2130837668);
      }
    case 2131558550: 
      Constants.callTouch(this.context);
      this.linearLayout.setVisibility(8);
      this.fabMenu.setVisibility(0);
      return;
    }
    Constants.callTouch(this.context);
    favorite();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968604);
    Constants.callTouch(this.context);
    this.helper = new SQLiteHelper(this.context);
    this.adViewLayout = ((RelativeLayout)findViewById(2131558538));
    try
    {
      if (Constants.isCheckInternetcon(this.context))
      {
        interstilaAds();
        if (Constants.bannerAdStatus == 1) {
          Constants.loadStartappBannerAd(this.context, this.adViewLayout);
        }
        for (;;)
        {
          this.toolbar = ((Toolbar)findViewById(2131558619));
          this.btnContent = ((Button)findViewById(2131558546));
          this.btnMethod = ((Button)findViewById(2131558545));
          this.txtContent = ((VerticalMarqueeTextView)findViewById(2131558550));
          this.txtItemName = ((TextView)findViewById(2131558544));
          this.fabFavorite = ((android.support.design.widget.FloatingActionButton)findViewById(2131558547));
          this.fabMenu = ((FloatingActionMenu)findViewById(2131558558));
          this.fabColorButton = ((com.github.clans.fab.FloatingActionButton)findViewById(2131558559));
          this.fabFontButton = ((com.github.clans.fab.FloatingActionButton)findViewById(2131558560));
          this.fabScrollButton = ((com.github.clans.fab.FloatingActionButton)findViewById(2131558561));
          this.linearLayout = ((LinearLayout)findViewById(2131558549));
          this.imageView = ((ImageView)findViewById(2131558541));
          this.layoutFont = ((LinearLayout)findViewById(2131558555));
          this.layoutScroll = ((LinearLayout)findViewById(2131558552));
          this.lineColorPicker = ((LineColorPicker)findViewById(2131558557));
          this.seekFont = ((SeekBar)findViewById(2131558556));
          this.seekScroll = ((SeekBar)findViewById(2131558554));
          this.imgPlay = ((ImageView)findViewById(2131558553));
          this.arrayList = ((ArrayList)getIntent().getSerializableExtra("data"));
          this.Position = getIntent().getIntExtra("position", 0);
          this.toolbar.setTitle("");
          setSupportActionBar(this.toolbar);
          getSupportActionBar().setDisplayHomeAsUpEnabled(true);
          Drawable localDrawable = getResources().getDrawable(2130837657);
          localDrawable.setColorFilter(getResources().getColor(2131492887), PorterDuff.Mode.SRC_ATOP);
          getSupportActionBar().setHomeAsUpIndicator(localDrawable);
          this.toolbar.setNavigationOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              DescriptionActivity.this.onBackPressed();
            }
          });
          this.toolbar.setTitleTextColor(getResources().getColor(2131492958));
          this.toolbar.setBackgroundColor(getResources().getColor(2131492957));
          this.txtItemName.setText(((DataModel)this.arrayList.get(this.Position)).getName());
          this.txtContent.setText(((DataModel)this.arrayList.get(this.Position)).getContent());
          this.id = getResources().getIdentifier(((DataModel)this.arrayList.get(this.Position)).getImage(), "drawable", getApplicationContext().getPackageName());
          if (this.id != 0) {
            Picasso.with(this.context).load(this.id).placeholder(2130837654).into(this.imageView);
          }
          this.dataId = ((DataModel)this.arrayList.get(this.Position)).getId();
          this.btnMethod.setOnClickListener(this);
          this.btnContent.setOnClickListener(this);
          this.fabFavorite.setOnClickListener(this);
          this.fabColorButton.setOnClickListener(this);
          this.fabFontButton.setOnClickListener(this);
          this.fabScrollButton.setOnClickListener(this);
          this.imgPlay.setOnClickListener(this);
          this.txtContent.setOnClickListener(this);
          Log.i(this.TAG, "onCreate: " + this.helper.checkExists(this.dataId));
          if (!this.helper.checkExists(this.dataId)) {
            break;
          }
          this.fabFavorite.setImageResource(2130837662);
          imageDialog();
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
        continue;
        this.fabFavorite.setImageResource(2130837673);
      }
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623936, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      share();
    }
  }
  
  public void scroll()
  {
    this.txtContent.setMovementMethod(new ScrollingMovementMethod());
    this.txtContent.startMarquee();
    this.imgPlay.setImageResource(2130837667);
    if (!this.AoutoScroolFlag)
    {
      this.AoutoScroolFlag = true;
      this.imgPlay.setImageResource(2130837667);
      if (this.txtContent.isPaused()) {
        this.txtContent.resumeMarquee();
      }
    }
    for (;;)
    {
      this.seekScroll.setProgress(50);
      this.seekScroll.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
      {
        public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          int i = 90 - paramAnonymousInt;
          DescriptionActivity.this.txtContent.setDuration(i);
        }
        
        public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar) {}
        
        public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar) {}
      });
      return;
      if (this.AoutoScroolFlag)
      {
        this.AoutoScroolFlag = false;
        this.imgPlay.setImageResource(2130837668);
        this.txtContent.pauseMarquee();
      }
    }
  }
  
  public void share()
  {
    Bitmap localBitmap = BitmapFactory.decodeResource(getResources(), this.id);
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setType("image/*");
    localIntent.putExtra("android.intent.extra.SUBJECT", ((DataModel)this.arrayList.get(this.Position)).getName());
    localIntent.putExtra("android.intent.extra.TEXT", getResources().getString(2131165269) + " \n\n" + ((DataModel)this.arrayList.get(this.Position)).getContent() + "\n\n Method \n\n" + ((DataModel)this.arrayList.get(this.Position)).getMethod() + " \n\n " + getResources().getString(2131165270) + " " + getResources().getString(2131165279));
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    localBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
    localIntent.putExtra("android.intent.extra.STREAM", Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(), localBitmap, getResources().getString(2131165255), null)));
    startActivity(Intent.createChooser(localIntent, "Select"));
  }
  
  public void visibilityForFabColorPiker()
  {
    this.linearLayout.setVisibility(0);
    this.fabMenu.setVisibility(8);
    this.layoutFont.setVisibility(8);
    this.lineColorPicker.setVisibility(0);
    this.layoutScroll.setVisibility(8);
  }
  
  public void visibilityForFabScroll()
  {
    this.linearLayout.setVisibility(0);
    this.fabMenu.setVisibility(8);
    this.layoutFont.setVisibility(8);
    this.lineColorPicker.setVisibility(8);
    this.layoutScroll.setVisibility(0);
  }
  
  public void visibilityForFabSize()
  {
    this.linearLayout.setVisibility(0);
    this.fabMenu.setVisibility(8);
    this.layoutFont.setVisibility(0);
    this.lineColorPicker.setVisibility(8);
    this.layoutScroll.setVisibility(8);
  }
}


/* Location:              D:\Chandresh\reverse engineering\1\dex2jar & jd-gui\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar!\com\varni\paneerrecipesinenglish\activity\DescriptionActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */