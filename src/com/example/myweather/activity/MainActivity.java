package com.example.myweather.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.webkit.WebView;
import android.widget.ListView;


import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.example.myweather.R;
import com.example.myweather.adapter.WeatherAdapter;
import com.example.myweather.deal.WeatherDataDeal;
import com.example.myweather.model.DayWeather;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by rabook on 2016/7/24.
 */
public class MainActivity extends Activity{

    // 定位相关
    LocationClient mLocClient;
    public MyLocationListenner myListener = new MyLocationListenner();

    //view 相关
    private ListView listView ;

    //数据相关
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

        setLocationOption();
        weatherDataDeal = WeatherDataDeal.getInstance(this);
        dayWeatherList = weatherDataDeal.getWeatherDataList(city);
        adapter = new WeatherAdapter(this,R.layout.list_view,dayWeatherList);
        /**
         * 测试起点
         */
        if (dayWeatherList == null)
            Log.d("--------","MainActivity----------dayWeatherList == null");
        /**
         * 测试结束
         */

        listView.setAdapter(adapter);


    }



    private void setLocationOption() {
        mLocClient = new LocationClient(this);
        mLocClient.registerLocationListener(myListener);// 注册监听函数：
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); //打开gps
        option.setCoorType("bd09ll");// 返回的定位结果是百度经纬度,默认值gcj02
        option.setScanSpan(600000);// 设置发起定位请求的间隔时间为5000ms
        option.setIsNeedAddress(true);// 返回的定位结果包含地址信息
        mLocClient.setLocOption(option);
        mLocClient.start();
    }


    /**
     * 定位SDK监听函数
     */
    public class MyLocationListenner implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {
            city = location.getCity();
            Log.d("----------getCity()--",location.getCity());
            Log.d("-------getAddrStr()--",location.getAddrStr());

        }
        public void onReceivePoi(BDLocation poiLocation) {
        }
    }

    @Override
    protected void onPause() {

        super.onPause();
    }

    @Override
    protected void onResume() {

        super.onResume();
    }

    @Override
    protected void onDestroy() {
        // 退出时销毁定位
        mLocClient.stop();
        super.onDestroy();
    }





}
