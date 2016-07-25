package com.example.myweather.deal;

import android.content.Context;
import android.widget.ListView;
import com.example.myweather.adapter.WeatherAdapter;
import com.example.myweather.business.DBService;
import com.example.myweather.business.WebService;
import com.example.myweather.db.MyWeatherDB;
import com.example.myweather.model.DayWeather;

import java.util.List;

/**
 * Created by rabook on 2016/7/25.
 */
public class WeatherDataDeal {

    private static WeatherDataDeal weatherDataDeal;

    private Context context;
    private DBService dbService;
    private WebService webService;
    private List dayWeatherList ;
    private DayWeather today ;




    public WeatherDataDeal(Context context) {
        this.context = context;
    }

    /**
     * get WeatherDataDeal sample
     */

    public synchronized static WeatherDataDeal getInstance(Context context)
    {
        if (weatherDataDeal == null)
        {
            weatherDataDeal = new WeatherDataDeal(context);

        }
        return weatherDataDeal;
    }



    public List getWeatherData(String city)
    {
        dayWeatherList = dbService.getDayWeatherList();
        today = (DayWeather) dayWeatherList.get(0);
        if ( today == null || (!today.checkDay()) )
        {
            webService.queryFromServerByCity(city);
            dayWeatherList = webService.getDayWeatherList();
            dbService.saveDayWeatherList(dayWeatherList);
        }
        return dayWeatherList;
    }
}
