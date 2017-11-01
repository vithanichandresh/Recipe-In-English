package com.varni.paneerrecipesinenglish.adapter;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.varni.paneerrecipesinenglish.activity.DescriptionActivity;
import com.varni.paneerrecipesinenglish.model.DataModel;
import java.util.ArrayList;

public class RecyclerAdapter
  extends RecyclerView.Adapter<ViewHolder>
{
  String TAG = getClass().getSimpleName();
  private ArrayList<DataModel> arraylist;
  private Activity context;
  boolean isSubActivity;
  
  public RecyclerAdapter(Activity paramActivity, ArrayList<DataModel> paramArrayList)
  {
    this.arraylist = paramArrayList;
    this.context = paramActivity;
  }
  
  public int getItemCount()
  {
    return this.arraylist.size();
  }
  
  public void onBindViewHolder(ViewHolder paramViewHolder, final int paramInt)
  {
    String str1 = ((DataModel)this.arraylist.get(paramInt)).getImage();
    String str2 = ((DataModel)this.arraylist.get(paramInt)).getName();
    paramViewHolder.txtTitle.setText(str2);
    int i = this.context.getResources().getIdentifier(str1, "drawable", this.context.getPackageName());
    Glide.with(this.context).load(Integer.valueOf(i)).placeholder(2130837654).into(paramViewHolder.imageView);
    paramViewHolder.subItemView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(RecyclerAdapter.this.context, DescriptionActivity.class);
        localIntent.putExtra("data", RecyclerAdapter.this.arraylist);
        localIntent.putExtra("position", paramInt);
        RecyclerAdapter.this.context.startActivity(localIntent);
      }
    });
  }
  
  public ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new ViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2130968627, paramViewGroup, false));
  }
  
  public class ViewHolder
    extends RecyclerView.ViewHolder
  {
    private ImageView imageView;
    private FrameLayout subItemView;
    private TextView txtTitle;
    
    public ViewHolder(View paramView)
    {
      super();
      this.imageView = ((ImageView)paramView.findViewById(2131558591));
      this.txtTitle = ((TextView)paramView.findViewById(2131558592));
      this.subItemView = ((FrameLayout)paramView.findViewById(2131558590));
    }
  }
}


/* Location:              D:\Chandresh\reverse engineering\1\dex2jar & jd-gui\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar!\com\varni\paneerrecipesinenglish\adapter\RecyclerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */