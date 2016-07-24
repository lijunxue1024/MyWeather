package com.example.myweather.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.myweather.model.DayWeather;


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
     *  save Today to DB
     */
    public void savedayWeather (DayWeather dayWeather)
    {
        if(dayWeather != null)
        {
            ContentValues values = new ContentValues();

            values.put("today_weekDay",dayWeather.getWeekDay());
            values.put("today_temperature",dayWeather.getTemperature());
            values.put("today_weather",dayWeather.getWeather());
            values.put("today_jpgName",dayWeather.getJpgName());

            //if is not today
            if (dayWeather.getDay_description().equals("today")) {
                values.put("today_update", dayWeather.getUpdate());
                values.put("day_number", dayWeather.getDay_number());
                values.put("today_sun", dayWeather.getSun());
                values.put("today_air", dayWeather.getAir());
                values.put("today_description", dayWeather.getDescription());
            }
            db.insert("DayWeather",null,values);
        }
    }

    /**
     * get DayWeather from DB
     */
    public DayWeather loadDayWeatherBydaydescription(String dayDescription)
    {
        DayWeather dayWeather = new DayWeather();
        Cursor cursor = db
                .query("Today",null,"day_description = ?",
                        new String[]{dayDescription}
                        ,null,null,null);
        if (cursor.moveToFirst())
        {

                dayWeather.setWeekDay(cursor.getString(cursor.getColumnIndex("today_weekDay")));
                dayWeather.setTemperature(cursor.getString(cursor.getColumnIndex("today_temperature")));
                dayWeather.setWeather(cursor.getString(cursor.getColumnIndex("today_weather")));
                dayWeather.setJpgName(cursor.getString(cursor.getColumnIndex("today_jpgName")));

            if(dayDescription.equals("today")) {
                dayWeather.setDay_description(cursor.getString(cursor.getColumnIndex("today_description")));
                dayWeather.setUpdate(cursor.getString(cursor.getColumnIndex("today_update")));
                dayWeather.setDay_number(cursor.getString(cursor.getColumnIndex("day_number")));
                dayWeather.setSun(cursor.getString(cursor.getColumnIndex("today_sun")));
                dayWeather.setAir(cursor.getString(cursor.getColumnIndex("today_air")));
            }
        }
        return dayWeather;
    }


}