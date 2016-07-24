package com.example.myweather.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rabook on 2016/7/23.
 */
public class MyWeatherOpenHelper extends SQLiteOpenHelper{




    public static final String CREATE_TODAY = "create table Today(" +
            "today_update  text," +
            "today_day  text," +
            "today_jpgName  text," +
            "today_sun  text," +
            "today_temperature  text," +
            "today_air  text," +
            "today_weather  text," +
            "today_description  text)";


    public static final String CREATE_TOMORROW = "create table Tomorrow(" +
            "tomorrow_day  text," +
            "tomorrow_jpgName  text," +
            "tomorrow_temperature  text)";


    public static final String CREATE_TWODAYLATER = "create table TwoDayLater(" +
            "twoDayLater_day  text," +
            "twoDayLater_jpgName  text," +
            "twoDayLater_temperature  text)";

    public static final String CREATE_THREEDAYLATER = "The day after ThreeDayLater(" +
            "threeDayLater_day  text," +
            "threeDayLater_jpgName  text," +
            "threeDayLater_temperature  text)";


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
