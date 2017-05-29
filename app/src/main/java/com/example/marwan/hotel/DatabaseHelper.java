package com.example.marwan.hotel;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

/**
 * Created by MARWAN on 15/04/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "bb";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "booking";

    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "DESCRIPTION";
    public static final String COL_4 = "TYPE";
    public static final String COL_5 = "CITY";
    public static final String COL_6 = "PRICE";
    public static final String COL_7 = "LNG";
    
    public DatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }
    /*  Create The Table */
    @Override
    public  void onCreate(SQLiteDatabase db){
        db.execSQL("create table " + TABLE_NAME +"(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, DESCRIPTION TEXT, TYPE TEXT, CITY TEXT, PRICE TEXT, LNG TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS"+ TABLE_NAME);
        onCreate(db);
    }


    public boolean insertPlace(String name, String description, String type, String city, String price, String lng) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues placeValues = new ContentValues();
        placeValues.put(COL_2, name);
        placeValues.put(COL_3, description);
        placeValues.put(COL_4, type);
        placeValues.put(COL_5, city);
        placeValues.put(COL_6, price);
        placeValues.put(COL_7, lng);

        long result = db.insert(TABLE_NAME,null,placeValues);
        if(result == -1){
            return false;
        }else {
            return true;
        }

    }
}
