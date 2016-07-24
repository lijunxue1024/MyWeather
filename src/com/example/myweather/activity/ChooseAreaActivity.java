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
import com.example.myweather.util.HttpCallbackListener;
import com.example.myweather.util.HttpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rabook on 2016/7/24.
 */
public class ChooseAreaActivity extends Activity {
    public static final int LEVEL_PROVINCE = 0;
    public static final int LEVEL_CITY = 1;
    public static final int LEVEL_COUNTY = 2;

    private ProgressDialog progressDialog;
    private TextView titleText ;
    private ListView listView ;
    private ArrayAdapter<String> adapter;
    private MyWeatherDB myWeatherDB;
    private List<String> dataList = new ArrayList<String>();


    /**
     * province list
     */
    private List<Province> provincelist;


    /**
     * cityList list
     */
    private List<City> cityList;


    /**
     * county list
     */
    private List<County> countyList;

    /**
     * province
     */
    private Province province;

    /**
     * city
     */
    private City city;

    /**
     * county
     */
    private County county;

    /**
     *
     */
    private int currentLevel;


    @Override
    protected void onCreate(Bundle saveInstanceState)
    {
        super.onCreate(saveInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.choose_area);
        listView = (ListView)findViewById(R.id.list_view);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dataList);
        listView.setAdapter(adapter);
        myWeatherDB = MyWeatherDB.getInstance(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (currentLevel == LEVEL_PROVINCE)
                {
                    province = provincelist.get(position);
                    queryCities();
                }
                else if (currentLevel == LEVEL_CITY)
                {
                    city = cityList.get(position);
                    queryCounties();
                }
            }
        });
        queryProvinces();
    }


    /**
     * query all province   from DB if null from web service
     */

    private void queryProvinces()
    {
        provincelist = myWeatherDB.loadProvinces();
        if (provincelist.size() > 0)
        {
            dataList.clear();
            for (Province province :provincelist)
            {
                dataList.add(province.getProvinceName());
            }
            adapter.notifyDataSetChanged();
            listView.setSelection(0);
            titleText.setText("Chinese");
            currentLevel = LEVEL_PROVINCE;
        }else {
            queryFromServer(null,"province");
        }
    }

    /**
     * query all city  from DB if null from web service
     */
    private void queryCities()
    {
        cityList = myWeatherDB.loadCities(province.getId());
        if (cityList.size() > 0)
        {
            dataList.clear();
            for (City city :cityList)
            {
                dataList.add(city.getCityCode());
            }
            adapter.notifyDataSetChanged();
            listView.setSelection(0);
            titleText.setText(province.getProvinceName());
            currentLevel = LEVEL_CITY;
        }else {
            queryFromServer(province.getProvinceCode(),"city");
        }
    }

    /**
     * query all city  from DB if null from web service
     */
    private void queryCounties()
    {
        countyList = myWeatherDB.loadCounties(city.getId());
        if (countyList.size() >0)
        {
            for (County county:countyList)
            {
                dataList.add(county.getCountyName());
            }
            adapter.notifyDataSetChanged();
            listView.setSelection(0);
            titleText.setText(city.getCityName());
            currentLevel = LEVEL_COUNTY;
        }else {
            queryFromServer(city.getCityCode(),"county");
        }
    }

/**
 * query data from DB by code
 */
    private void queryFromServer(final String code,final String type)
    {
        String address;
        if (!TextUtils.isEmpty(code))
        {
            address = "";
        }else {
            address = "";
        }

        showProgressDialog();

        HttpUtil.sendHttpRequest(address, new HttpCallbackListener() {
            @Override
            public void onFinish(String response) {
                Boolean result false;
                if ("province".equals(type))
                {
                    result = Utility.
                }
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }

}
