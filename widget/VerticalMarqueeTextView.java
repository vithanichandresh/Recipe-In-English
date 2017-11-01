package com.varni.paneerrecipesinenglish.widget;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.widget.TextView;

public class VerticalMarqueeTextView
  extends TextView
{
  private final Activity activity;
  private int duration;
  private boolean isNotDrawn = true;
  private boolean isPaused;
  private boolean isUserScrolling;
  private int pixelYOffSet;
  private boolean stop;
  
  public VerticalMarqueeTextView(Context paramContext)
  {
    super(paramContext);
    this.activity = ((Activity)paramContext);
    init();
  }
  
  public VerticalMarqueeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.activity = ((Activity)paramContext);
    init();
  }
  
  public VerticalMarqueeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.activity = ((Activity)paramContext);
    init();
  }
  
  private void init()
  {
    setDuration(50);
    setPixelYOffSet(1);
    this.stop = false;
    this.isPaused = false;
    this.isUserScrolling = false;
  }
  
  public int getDuration()
  {
    this.duration = (1 + (100 - this.duration));
    return this.duration;
  }
  
  public int getPixelYOffSet()
  {
    return this.pixelYOffSet;
  }
  
  public boolean isPaused()
  {
    return (this.isPaused) || (this.isUserScrolling);
  }
  
  public void pauseMarquee()
  {
    this.isPaused = true;
  }
  
  public void restart()
  {
    new AutoScrollTextView(null).execute(new Void[0]);
  }
  
  public void resumeMarquee()
  {
    this.isPaused = false;
  }
  
  public void setDuration(int paramInt)
  {
    this.duration = paramInt;
  }
  
  public void setPixelYOffSet(int paramInt)
  {
    if (paramInt < 1)
    {
      this.pixelYOffSet = 1;
      return;
    }
    this.pixelYOffSet = paramInt;
  }
  
  public void startMarquee()
  {
    new AutoScrollTextView(null).execute(new Void[0]);
  }
  
  public void stopMarquee()
  {
    this.stop = true;
  }
  
  private class AutoScrollTextView
    extends AsyncTask<Void, Void, Void>
  {
    private int pixelCount;
    
    private AutoScrollTextView() {}
    
    private boolean textViewNotDrawn()
    {
      VerticalMarqueeTextView.this.activity.runOnUiThread(new Runnable()
      {
        public void run()
        {
          if (VerticalMarqueeTextView.this.getLineCount() > 0)
          {
            VerticalMarqueeTextView.AutoScrollTextView.access$502(VerticalMarqueeTextView.AutoScrollTextView.this, VerticalMarqueeTextView.this.getLineHeight() * VerticalMarqueeTextView.this.getLineCount());
            VerticalMarqueeTextView.access$802(VerticalMarqueeTextView.this, false);
          }
        }
      });
      return VerticalMarqueeTextView.this.isNotDrawn;
    }
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      while (textViewNotDrawn()) {
        try
        {
          Thread.sleep(1000L);
        }
        catch (InterruptedException localInterruptedException2)
        {
          localInterruptedException2.printStackTrace();
        }
      }
      if (!VerticalMarqueeTextView.this.stop)
      {
        if ((!VerticalMarqueeTextView.this.isPressed()) && (VerticalMarqueeTextView.this.isUserScrolling) && (!VerticalMarqueeTextView.this.isPaused)) {
          VerticalMarqueeTextView.access$202(VerticalMarqueeTextView.this, false);
        }
        while ((!VerticalMarqueeTextView.this.isUserScrolling) && (!VerticalMarqueeTextView.this.stop) && (!VerticalMarqueeTextView.this.isPaused)) {
          try
          {
            Thread.sleep(VerticalMarqueeTextView.this.duration);
            VerticalMarqueeTextView.this.activity.runOnUiThread(new Runnable()
            {
              public void run()
              {
                if (VerticalMarqueeTextView.this.isPressed())
                {
                  VerticalMarqueeTextView.access$202(VerticalMarqueeTextView.this, true);
                  return;
                }
                if (VerticalMarqueeTextView.this.getScrollY() >= VerticalMarqueeTextView.AutoScrollTextView.this.pixelCount) {
                  VerticalMarqueeTextView.this.scrollTo(0, 0);
                }
                for (;;)
                {
                  VerticalMarqueeTextView.this.invalidate();
                  return;
                  VerticalMarqueeTextView.this.scrollBy(0, VerticalMarqueeTextView.this.pixelYOffSet);
                }
              }
            });
          }
          catch (InterruptedException localInterruptedException1)
          {
            for (;;)
            {
              localInterruptedException1.printStackTrace();
            }
          }
        }
      }
      return null;
    }
    
    protected void onProgressUpdate(Void... paramVarArgs)
    {
      super.onProgressUpdate(paramVarArgs);
    }
  }
}


/* Location:              D:\Chandresh\reverse engineering\1\dex2jar & jd-gui\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar!\com\varni\paneerrecipesinenglish\widget\VerticalMarqueeTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */