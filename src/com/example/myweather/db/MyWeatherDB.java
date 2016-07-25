package com.example.myweather.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.myweather.model.DayWeather;

import java.util.List;


/**
 * Created by rabook on 2016/7/23.
 */
public class MyWeatherDB {
    /**
     * DB name
     */
    public static final String DB_NAME = "my_weather";


    /**
     * DB version
     */
    public static final int VERSION = 1;

    private static MyWeatherDB myWeatherDB;

    private SQLiteDatabase db ;

        /**
         * Construction method private
         */
    private MyWeatherDB(Context context)
    {
        MyWeatherOpenHelper dbHelp = new MyWeatherOpenHelper(context,DB_NAME,null,VERSION);
        db = dbHelp.getWritableDatabase();
    }

    /**
     * get MyWeather sample
     */

    public synchronized static MyWeatherDB getInstance(Context context)
    {
        if (myWeatherDB == null)
        {
            myWeatherDB = new MyWeatherDB(context);

        }
        return myWeatherDB;
    }

    /**
     *  save one to DB
     */
    public void saveDayWeather (DayWeather dayWeather)
    {
        if(dayWeather != null)
        {
            ContentValues values = new ContentValues();

            values.put("dayWeather_weekDay",dayWeather.getWeekDay());
            values.put("dayWeather_temperature",dayWeather.getTemperature());
            values.put("dayWeather_weather",dayWeather.getWeather());
            values.put("dayWeather_jpgName",dayWeather.getJpgId());
            values.put("dayWeather_day_description", dayWeather.getDay_description());

            //if is not today
            if (dayWeather.getDay_description().equals("today")) {
                values.put("dayWeather_update", dayWeather.getUpdate());
                values.put("dayWeather_day_number", dayWeather.getDay_number());
                values.put("dayWeather_sun", dayWeather.getSun());
                values.put("dayWeather_air", dayWeather.getAir());
                values.put("dayWeather_description", dayWeather.getDescription());
            }
            db.insert("DayWeather",null,values);
        }
    }

    /**
     * get DayWeather from DB
     */
    public DayWeather loadDayWeatherBydaydescription(String dayDescription)
    {
        DayWeather dayWeather = null;
        Cursor cursor = db
                .query("DayWeather",null,"dayWeather_day_description = ?",
                        new String[]{dayDescription}
                        ,null,null,null);
        if (cursor.moveToFirst())
        {
                String day_description = cursor.getString(cursor.getColumnIndex("dayWeather_day_description"));
                dayWeather = new DayWeather(day_description);
                dayWeather.setWeekDay(cursor.getString(cursor.getColumnIndex("dayWeather_weekDay")));
                dayWeather.setTemperature(cursor.getString(cursor.getColumnIndex("dayWeather_temperature")));
                dayWeather.setWeather(cursor.getString(cursor.getColumnIndex("dayWeather_weather")));
                dayWeather.setJpgId(cursor.getString(cursor.getColumnIndex("dayWeather_jpgName")));


            if(dayDescription.equals("today")) {
                dayWeather.setDescription(cursor.getString(cursor.getColumnIndex("dayWeather_description")));
                dayWeather.setUpdate(cursor.getString(cursor.getColumnIndex("dayWeather_update")));
                dayWeather.setDay_number(cursor.getString(cursor.getColumnIndex("dayWeather_day_number")));
                dayWeather.setSun(cursor.getString(cursor.getColumnIndex("dayWeather_sun")));
                dayWeather.setAir(cursor.getString(cursor.getColumnIndex("dayWeather_air")));
            }
        }
        return dayWeather;
    }








}