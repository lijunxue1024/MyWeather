package com.example.myweather.business;

import android.content.Context;
import android.util.Log;
import com.example.myweather.db.MyWeatherDB;
import com.example.myweather.model.DayWeather;
import com.example.myweather.util.HttpCallbackListener;
import com.example.myweather.util.HttpUtil;
import org.ksoap2.serialization.SoapObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rabook on 2016/7/25.
 */
public class WebService {

    private final int MAX_NUMBER = 4;
    private final String[] day_description = {"today","tomorrow","twoDaysLater","threeDaysLater"};


    private MyWeatherDB myWeatherDB;
    private DayWeather toDay;
    private List dayWeatherList;







    public List getDayWeatherList() {
        return dayWeatherList;
    }

    /**
     * query data from webService
     */
    public void queryFromServerByCity(String city)
    {
        HttpUtil.sendHttpRequest(city, new HttpCallbackListener() {
            @Override
            public void onFinish(SoapObject response) {
                int length = response.getPropertyCount();
                List result = new ArrayList<String>();
                dayWeatherList = new ArrayList<DayWeather>();

                //系统维护
                if (length < 2) {
                    /**
                     * 测试起点
                     */

                        Log.d("--------","WebService----------//系统维护if (length < 2");
                    /**
                     * 测试结束
                     */


                    return ;
                }
                // 获取返回的结果
                for (int i = 0;i<length;i++) {
                    result.add(response.getProperty(0).toString());
                }

                //这里可以是处理结果
                dayWeatherList = DayWeather.getDayWeatherList(result);
                /**
                 * 测试起点
                 */
                if (dayWeatherList == null)
                    Log.d("--------","WebService----------dayWeatherList == null");
                /**
                 * 测试结束
                 */
            }

            @Override
            public void onError(Exception e) {
                e.printStackTrace();
            }
        });





    }






}
