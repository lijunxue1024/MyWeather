package com.example.myweather.util;

import org.ksoap2.serialization.SoapObject;

/**
 * Created by rabook on 2016/7/24.
 */
public interface HttpCallbackListener {
    void onFinish(SoapObject response);
    void onError(Exception e);
}
