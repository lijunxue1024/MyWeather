package com.example.myweather.model;

import com.example.myweather.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by rabook on 2016/7/24.
 */
public class DayWeather {

    private String day_description;
    private String update;
    private String weekDay;
    private String day_number;
    private int  jpgId;
    private String sun;
    private String temperature;
    private String air;
    private String weather;
    private String description;
    public DayWeather(String day_description)
    {
        this.day_description = day_description;
    }
    public String getUpdate() {
        return update;
    }

    public void setUpdate(String updata) {
        this.update = updata;
    }


    public int getJpgId() {
        return jpgId;
    }

    public void setJpgId(String jpgName) {

            switch (jpgName)
            {
                case "0.gif" : jpgId = R.drawable.ic_0;
                    break;
                case "1.gif" : jpgId = R.drawable.ic_1;
                    break;
                case "2.gif" : jpgId = R.drawable.ic_2;
                    break;
                case "3.gif" : jpgId = R.drawable.ic_3;
                    break;
                case "4.gif" : jpgId = R.drawable.ic_4;
                    break;
                case "5.gif" : jpgId = R.drawable.ic_5;
                    break;
                case "6.gif" : jpgId = R.drawable.ic_6;
                    break;
                case "7.gif" : jpgId = R.drawable.ic_7;
                    break;
                case "8.gif" : jpgId = R.drawable.ic_8;
                    break;
                case "9.gif" : jpgId = R.drawable.ic_9;
                    break;
                case "10.gif" : jpgId = R.drawable.ic_10;
                    break;
                case "11.gif" : jpgId = R.drawable.ic_11;
                    break;
                case "12.gif" : jpgId = R.drawable.ic_12;
                    break;
                case "13.gif" : jpgId = R.drawable.ic_13;
                    break;
                case "14.gif" : jpgId = R.drawable.ic_14;
                    break;
                case "15.gif" : jpgId = R.drawable.ic_15;
                    break;
                case "16.gif" : jpgId = R.drawable.ic_16;
                    break;
                case "17.gif" : jpgId = R.drawable.ic_17;
                    break;
                case "18.gif" : jpgId = R.drawable.ic_18;
                    break;
                case "19.gif" : jpgId = R.drawable.ic_19;
                    break;
                case "20.gif" : jpgId = R.drawable.ic_20;
                    break;
                case "21.gif" : jpgId = R.drawable.ic_7;
                    break;
                case "22.gif" : jpgId = R.drawable.ic_8;
                    break;
                case "23.gif" : jpgId = R.drawable.ic_9;
                    break;
                case "24.gif" : jpgId = R.drawable.ic_9;
                    break;
                case "25.gif" : jpgId = R.drawable.ic_10;
                    break;
                case "26.gif" : jpgId = R.drawable.ic_14;
                    break;
                case "27.gif" : jpgId = R.drawable.ic_15;
                    break;
                case "28.gif" : jpgId = R.drawable.ic_16;
                    break;
                case "29.gif" : jpgId = R.drawable.ic_21;
                    break;
                case "30.gif" : jpgId = R.drawable.ic_20;
                    break;
                case "31.gif" : jpgId = R.drawable.ic_20;
                    break;
                default:  jpgId = R.drawable.ic_null;
                    break;
            }
    }

    public String getSun() {
        return sun;
    }

    public void setSun(String sun) {
        this.sun = sun;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getAir() {
        return air;
    }

    public void setAir(String air) {
        this.air = air;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getDay_number() {
        return day_number;
    }

    public void setDay_number(String day_number) {
        this.day_number = day_number;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public String getDay_description() {
        return day_description;
    }



    /**
     *     y,m,d  year:1993 month:1 day:12
     */

   public void getWhatDay(String datenumber){
       String te;
       int y;
       int m;
       int d;

        te = datenumber.substring(0,3);
        y = Integer.parseInt(te);
        te = datenumber.substring(5,6);
        m = Integer.parseInt(te);
        te = datenumber.substring(8,9);
        d = Integer.parseInt(te);

        int temp = 0; // 用来保存计算得到的星期几的整数
       String date="";
        if((m==1)||(m==2))//如果是一月或二月进行换算
        {
            m+=12;
            y--;
        }
       temp=(d+2*m+3*(m+1)/5+y+y/4-y/100+y/400)%7+1;   //得到的星期几的整数
        switch (temp){
            case 1:
                date="星期一";
                break;
            case 2:
                date="星期二";
                break;
            case 3:
                date="星期三";
                break;
            case 4:
                date="星期四";
                break;
            case 5:
                date="星期五";
                break;
            case 6:
                date="星期六";
                break;
            case 7:
                date="星期日";
                break;
        }
       this.weekDay = date;
    }

    //check day is right
    public boolean checkDay()
    {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(date);

        if (day_number != null) {
            if (dateNowStr.equals(day_number)) {
                return true;
            }
        }
        return false;
    }



    //
    public static List getDayWeatherList(List list)
    {
        List dayWeatherList = new ArrayList<DayWeather>();
        //******get

        return  dayWeatherList;
    }



}
