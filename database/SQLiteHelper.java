package com.varni.paneerrecipesinenglish.database;

import android.app.Activity;
import android.content.ContentValues;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.varni.paneerrecipesinenglish.model.DataModel;
import com.varni.paneerrecipesinenglish.utils.Constants;
import com.varni.paneerrecipesinenglish.utils.PrefUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class SQLiteHelper
  extends SQLiteOpenHelper
{
  private static String DB_PATH = "/databases/";
  public static String DataBaseName = "Paneer.db";
  private static final String TABLENAME = "Paneer";
  String TAG = getClass().getSimpleName();
  Activity mContext;
  
  public SQLiteHelper(Activity paramActivity)
  {
    super(paramActivity, DataBaseName, null, 1);
    try
    {
      this.mContext = paramActivity;
      if (!PrefUtils.LoadBoolean(paramActivity)) {
        CopyDataBaseFromAsset();
      }
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public void CopyDataBaseFromAsset()
    throws IOException
  {
    InputStream localInputStream = this.mContext.getAssets().open(DataBaseName);
    String str = getDatabasePath();
    File localFile = new File(this.mContext.getApplicationInfo().dataDir + DB_PATH);
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    FileOutputStream localFileOutputStream = new FileOutputStream(str);
    byte[] arrayOfByte = new byte['Ѐ'];
    for (;;)
    {
      int i = localInputStream.read(arrayOfByte);
      if (i <= 0) {
        break;
      }
      localFileOutputStream.write(arrayOfByte, 0, i);
    }
    PrefUtils.SaveBoolean(Constants.sStoreBoolean, true, this.mContext);
    localFileOutputStream.flush();
    localFileOutputStream.close();
    localInputStream.close();
  }
  
  public boolean checkExists(String paramString)
  {
    label125:
    for (boolean bool = false;; bool = false) {
      try
      {
        SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
        Cursor localCursor = localSQLiteDatabase.rawQuery("SELECT * FROM Paneer WHERE id = '" + paramString + "'", null);
        while (localCursor.moveToNext())
        {
          Log.i("SQLite", "checkExists: " + paramString);
          if (!localCursor.getString(localCursor.getColumnIndex("favorite")).equals("1")) {
            break label125;
          }
          bool = true;
        }
        localCursor.close();
        localSQLiteDatabase.close();
        return bool;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return bool;
      }
    }
  }
  
  public ArrayList<DataModel> dataOfFavorite()
  {
    ArrayList localArrayList = new ArrayList();
    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
    Cursor localCursor = localSQLiteDatabase.rawQuery("select * from Paneer WHERE favorite = 1", null);
    while (localCursor.moveToNext())
    {
      DataModel localDataModel = new DataModel();
      localDataModel.setName(localCursor.getString(0));
      localDataModel.setContent(localCursor.getString(1));
      localDataModel.setMethod(localCursor.getString(2));
      localDataModel.setImage(localCursor.getString(3));
      localDataModel.setId(localCursor.getString(4));
      localArrayList.add(localDataModel);
    }
    localSQLiteDatabase.close();
    return localArrayList;
  }
  
  public ArrayList<DataModel> dataOfPaneer()
  {
    ArrayList localArrayList = new ArrayList();
    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
    Cursor localCursor = localSQLiteDatabase.rawQuery("select * from Paneer", null);
    if (localCursor != null) {
      while (localCursor.moveToNext())
      {
        DataModel localDataModel = new DataModel();
        localDataModel.setName(localCursor.getString(0));
        localDataModel.setContent(localCursor.getString(1));
        localDataModel.setMethod(localCursor.getString(2));
        localDataModel.setImage(localCursor.getString(3));
        localDataModel.setId(localCursor.getString(4));
        localArrayList.add(localDataModel);
      }
    }
    localSQLiteDatabase.close();
    return localArrayList;
  }
  
  public String getDatabasePath()
  {
    return this.mContext.getApplicationInfo().dataDir + DB_PATH + DataBaseName;
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  public void updateFavorite(String paramString, int paramInt)
  {
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("favorite", Integer.valueOf(paramInt));
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(paramString);
    localSQLiteDatabase.update("Paneer", localContentValues, "id = ?", arrayOfString);
    localSQLiteDatabase.close();
  }
}


/* Location:              D:\Chandresh\reverse engineering\1\dex2jar & jd-gui\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar!\com\varni\paneerrecipesinenglish\database\SQLiteHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */