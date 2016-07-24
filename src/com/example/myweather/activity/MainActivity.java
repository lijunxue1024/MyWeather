package com.example.myweather.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.example.myweather.R;
import com.example.myweather.db.MyWeatherDB;
import com.example.myweather.model.DayWeather;
import com.example.myweather.util.HttpCallbackListener;
import com.example.myweather.util.HttpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rabook on 2016/7/24.
 */
public class MainActivity extends Activity{


    private ListView listView ;
    private ArrayAdapter<String> adapter;
    private List<String> dataList = new ArrayList<String>();
    private MyWeatherDB myWeatherDB;

    private final String[] day_description = {"today","tomorrow","twoDayslater","threeDayslater"};
    private final DayWeather[] dayWeatherList = new DayWeather[3] ;
    private DayWeather toDay ;
    @Override
    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main_activity);
        listView = (ListView)findViewById(R.id.list_view);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dataList);
        listView.setAdapter(adapter);
        myWeatherDB = MyWeatherDB.getInstance(this);

        queryDayWeather();
    }

    /**
     * queryqueryProvinces
     */
    private void queryDayWeather()
    {

        for (int i = 0 ; i < day_description.length;i++)
        {
            if (i == 0)
            {
                toDay = myWeatherDB.loadDayWeatherBydaydescription(day_description[i]);
            }
            else
            {
                dayWeatherList[i-1] = myWeatherDB.loadDayWeatherBydaydescription(day_description[i]);
            }
        }
            if (toDay != null||toDay.checkDay())
            {
                queryFromServer();
            }
    }

    /**
     * query data from DB by code
     */
    private void queryFromServer()
    {

    }

}
