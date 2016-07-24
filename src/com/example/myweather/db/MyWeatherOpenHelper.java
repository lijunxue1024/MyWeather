package com.example.myweather.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rabook on 2016/7/23.
 */
public class MyWeatherOpenHelper extends SQLiteOpenHelper{



    /**
     * Province TABLE  ↓
     */
    public static final String CREATE_PROVINCE = "create table Province(" +
            "id integer primary key autoincrement," +
            "province_name text," +
            "province_code text)";


    /**
     * City TABLE  ↓
     */
    public static final String CREATE_CITY = "create table Province(" +
            "id integer primary key autoincrement," +
            "city_name text," +
            "city_code text," +
            "province_id integer)";

    /**
     * County TABLE ↓
     */
    public static final String CREATE_COUNTY = "create table Province(" +
            "id integer primary key autoincrement," +
            "county_name text," +
            "county_code text," +
            "city_id integer)";


    public MyWeatherOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_PROVINCE);    //CREATE PROVINCE TABLE
        db.execSQL(CREATE_CITY);        //CREATE CITY TABLE
        db.execSQL(CREATE_COUNTY);      //CREATE COUNTY TABLE
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



}
