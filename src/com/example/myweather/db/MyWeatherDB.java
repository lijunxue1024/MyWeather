package com.example.myweather.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.myweather.model.City;
import com.example.myweather.model.County;
import com.example.myweather.model.Province;


import java.util.ArrayList;
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
     *  save province to DB
     */
    public void saveProvince (Province province)
    {
        if(province != null)
        {
            ContentValues values = new ContentValues();
            values.put("province_name",province.getProvinceName());
            values.put("province_code",province.getProvinceCode());

            db.insert("Province",null,values);
        }
    }

    /**
     * get province from DB
     */
    public List<Province> loadProvinces()
    {
        List<Province> list = new ArrayList<Province>();
        Cursor cursor = db
                .query("Province",null,null,null,null,null,null);
        if (cursor.moveToFirst())
        {
            do{
                Province province = new Province();
                province.setId(cursor.getInt(cursor.getColumnIndex("id")));
                province.setProvinceName(cursor.getString(cursor.getColumnIndex("province_name")));
                province.setProvinceCode(cursor.getString(cursor.getColumnIndex("province_code")));
                list.add(province);
            }while (cursor.moveToNext());
        }
        return list;
    }

    /**
     * save city to DB
     */
    public void saveCity(City city)
    {
        if (city != null)
        {
            ContentValues values = new ContentValues();
            values.put("city_name",city.getCityName());
            values.put("city_code",city.getCityCode());
            values.put("province_id",city.getProvinceId());
            db.insert("City",null,values);
        }
    }



    /**
     * get city of province from DB
     */
    public List<City> loadCities(int province)
    {
        List<City> list = new ArrayList<City>();
        Cursor cursor = db.query("City",null,"province = ?",
                new String[]{String.valueOf(province)},null,null,null);
        if(cursor.moveToFirst())
        {
            do{
                City city = new City();
                city.setId(cursor.getInt(cursor.getColumnIndex("id")));
                city.setCityName(cursor.getString(cursor.getColumnIndex("city_name")));
                city.setProvinceId(province);
                list.add(city);
            }while(cursor.moveToNext());
        }

        return list;

    }


        /**
         * put county to DB
         */
    public void SaveCountry(County county)
    {
        if (county != null)
        {
            ContentValues values = new ContentValues();
            values.put("county_name",county.getCountyName());
            values.put("county_code",county.getCountyCode());
            values.put("county_id",county.getCityId());
            db.insert("County",null,values);
        }
    }


    /**
     * get city from DB
     */
    public List<County> loadCounties(int cityId)
    {
        List<County> list = new ArrayList<County>();
        Cursor cursor = db.query("County",null,"city_id = ?",
                new String[]{String.valueOf(cityId)},
                null,null,null);
        if (cursor.moveToFirst())
        {
            do{
                County county = new County();
                county.setId(cursor.getColumnIndex("id"));
                county.setCountyName(cursor.getString(cursor
                        .getColumnIndex("county_name")));
                county.setCountyCode(cursor.getString(cursor
                        .getColumnIndex("county_code")));
                county.setCityId(cityId);
                list.add(county);
            }while(cursor.moveToNext());
        }
        return list;

    }
}