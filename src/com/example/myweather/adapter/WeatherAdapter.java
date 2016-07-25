package com.example.myweather.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.myweather.R;
import com.example.myweather.model.DayWeather;

import java.util.List;

/**
 * Created by rabook on 2016/7/24.
 */
public class WeatherAdapter extends ArrayAdapter<DayWeather>{
    private  int resourceId;


    public WeatherAdapter(Context context, int resource,List list) {
        super(context, resource,list);
        resourceId = resource;
    }


    @Override
    public View getView(int position, View connertView , ViewGroup parent)
    {
        View view;
        DayWeather dayWeather;
        TextView weekDay_text;
        TextView temperature;
        TextView weather_text;
        ImageView weather_sign_image;

        dayWeather = getItem(position);
        view = LayoutInflater.from(getContext()).inflate(resourceId,null);
        weekDay_text = (TextView)view.findViewById(R.id.next_day);
        weather_sign_image = (ImageView)view.findViewById(R.id.next_day_weather_sign_image);
        weather_text = (TextView)view.findViewById(R.id.next_day_weather_text);
        temperature = (TextView)view.findViewById(R.id.next_day_temperature);

        weekDay_text.setText(dayWeather.getWeekDay());
        weather_sign_image.setImageResource(dayWeather.getJpgId());
        weather_text.setText(dayWeather.getWeather());
        temperature.setText(dayWeather.getTemperature());

        return view;
    }
}
