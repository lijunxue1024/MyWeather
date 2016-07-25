package com.example.myweather.business;

import android.content.Context;
import com.example.myweather.db.MyWeatherDB;
import com.example.myweather.model.DayWeather;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rabook on 2016/7/25.
 */
public class DBService {

    private final int MAX_NUMBER = 4;
    private final String[] day_description = {"today","tomorrow","twoDaysLater","threeDaysLater"};

    MyWeatherDB myWeatherDB ;

    public DBService(Context context)
    {
        this.myWeatherDB = MyWeatherDB.getInstance(context);
    }

    /**
     *  save list to DB
     */
    public boolean  saveDayWeatherList(List list)
    {
        if (list == null)
        {
            return false;
        }
        for (int i = 0;i<list.size();i++) {
            DayWeather dayWeather = (DayWeather)list.get(i);
            myWeatherDB.saveDayWeather(dayWeather);
        }
        return true;

    }

    /**
     *  save list to DB
     */
    public List  getDayWeatherList()
    {

            List list = new ArrayList<DayWeather>();
        for (int i = 0; i<MAX_NUMBER;i++)
        {
            list.add(myWeatherDB.loadDayWeatherBydaydescription(day_description[i]));
        }

        return list;

    }


}
