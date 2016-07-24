package com.example.myweather.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rabook on 2016/7/23.
 */
public class MyWeatherOpenHelper extends SQLiteOpenHelper{


    public static final String CREATE_DAYWEATHER = "create table DayWeather(" +
            "dayWeather_update  text," +
            "dayWeather_day_description  text," +
            "dayWeather_weekDay  text," +
            "dayWeather_jpgName  text," +
            "dayWeather_sun  text," +
            "dayWeather_temperature  text," +
            "dayWeather_air  text," +
            "dayWeather_weather  text," +
            "dayWeather_description  text)";



    public MyWeatherOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_DAYWEATHER);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



}
