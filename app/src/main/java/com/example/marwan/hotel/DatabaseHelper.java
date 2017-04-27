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
    private static final int DB_VERSION = 9;
    private static final String TABLE_NAME = "bed";

    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "DESCRIPTION";
    public static final String COL_4 = "TYPE";
    public static final String COL_5 = "CITY";
    public static final String COL_6 = "PRICE";
    public static final String COL_7 = "LNG";
    /*
        public DatabaseHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION)        }
    /*
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE BED (_id INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, DESCRIPTION TEXT, TYPE TEXT, CITY TEXT, PRICE TEXT ,LNG TEXT)");
            insertPlace(db, "Princes Street Suites", "With stylish décor and free Wi-Fi available throughout", "Appartment", "Edinburgh", "169","01383112233");
            insertPlace(db, "Staycity Aparthotels West End", "Staycity Aparthotels West End are situated 0.5 miles from Edinburgh Haymarket Rail Station.", "Appartment","Edinburgh", "135","01383112244");
            insertPlace(db, "Blackfriars Lofts", "Stay in the historical Old Town of Edinburgh", "Appartment", "Edinburgh", "160","01383112255");
            insertPlace(db, "Old Town Chambers", "Experience world-class service at Old Town Chambers", "Appartment", "Edinburgh", "150","01383112266");
            insertPlace(db, "Bryson Road Edinburgh Apartment", "Set 0.7 miles from Murrayfield Stadium in Edinburgh", "Appartment","Edinburgh", "135", "01383112277");
            insertPlace(db, "Fountain Court Apartments – Stewart", "Set in the heart of historic Edinburgh just 10 minutes’ walk from The Royal Mile", "Appartment", "Edinburgh", "140","501383112288");
        }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    private static void insertPlace(SQLiteDatabase db, String name, String description, String type, String city, String price, String lng){
        ContentValues placeValues = new ContentValues();
        placeValues.put("NAME", name);
        placeValues.put("DESCRIPTION", description);
        placeValues.put("TYPE", type);
        placeValues.put("CITY", city);
        placeValues.put("PRICE", price);
        placeValues.put("LNG", lng);
        db.insert("BED", null, placeValues);

    }


    */
    public DatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
        //SQLiteDatabase db = this.getWritableDatabase();
    }

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
        //db.insert("BED", null, placeValues);

        long result = db.insert(TABLE_NAME,null,placeValues);
        if(result == -1){
            return false;
        }else {
            return true;
        }

    }
}
