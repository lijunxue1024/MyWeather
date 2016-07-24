package com.example.myweather.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rabook on 2016/7/24.
 */
public class DayWeather {

    private String day_description;
    private String update;
    private String weekDay;
    private String day_number;
    private String jpgName;
    private String sun;
    private String temperature;
    private String air;
    private String weather;
    private String description;

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String updata) {
        this.update = updata;
    }


    public String getJpgName() {
        return jpgName;
    }

    public void setJpgName(String jpgName) {
        this.jpgName = jpgName;
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

    public void setDay_description(String day_description) {
        this.day_description = day_description;
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


        if (dateNowStr.equals(day_number)){
            return true;
        }
        return false;
    }

}
