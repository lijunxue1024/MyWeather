package com.example.myweather.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebView;
import android.widget.ListView;

import com.example.myweather.R;
import com.example.myweather.adapter.WeatherAdapter;
import com.example.myweather.business.DBService;
import com.example.myweather.business.WebService;
import com.example.myweather.db.MyWeatherDB;
import com.example.myweather.deal.WeatherDataDeal;
import com.example.myweather.model.DayWeather;
import com.example.myweather.util.HttpCallbackListener;
import com.example.myweather.util.HttpUtil;
import org.ksoap2.serialization.SoapObject;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by rabook on 2016/7/24.
 */
public class MainActivity extends Activity{


    private ListView listView ;
    private WeatherAdapter adapter;
    private WeatherDataDeal weatherDataDeal;
    private List dayWeatherList ;
    private String city;

    @Override
    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        dayWeatherList = new ArrayList<DayWeather>();
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main_activity);
        listView = (ListView)findViewById(R.id.list_view);
        weatherDataDeal = WeatherDataDeal.getInstance(this);
        dayWeatherList = weatherDataDeal.getWeatherData(city);
        adapter = new WeatherAdapter(this,R.layout.list_view,dayWeatherList);
        listView.setAdapter(adapter);


    }





}
