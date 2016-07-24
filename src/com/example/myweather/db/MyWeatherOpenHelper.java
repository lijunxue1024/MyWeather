package com.example.myweather.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rabook on 2016/7/23.
 */
public class MyWeatherOpenHelper extends SQLiteOpenHelper{




    public static final String CREATE_TODAY = "create table Today(" +
            "id integer primary key autoincrement," +
            "province_name text," +
            "province_code text)";


    public static final String CREATE_TOMORROW = "create table Tomorrow(" +
            "id integer primary key autoincrement," +
            "city_name text," +
            "city_code text," +
            "province_id integer)";


    public static final String CREATE_TWODAYLATER = "create table TwoDayLater(" +
            "id integer primary key autoincrement," +
            "county_name text," +
            "county_code text," +
            "city_id integer)";

    public static final String CREATE_THREEDAYLATER = "The day after ThreeDayLater(" +
            "id integer primary key autoincrement," +
            "county_name text," +
            "county_code text," +
            "city_id integer)";


    public MyWeatherOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TODAY);
        db.execSQL(CREATE_TOMORROW);
        db.execSQL(CREATE_TWODAYLATER);
        db.execSQL(CREATE_THREEDAYLATER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



}
