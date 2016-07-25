package com.example.myweather.util;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rabook on 2016/7/24.
 */
public class HttpUtil {

    // 命名空间
    private final String nameSpace = "http://WebXml.com.cn/";
    // 调用的方法名称
    private final String methodName = "getWeather";
    // EndPoint
    private final String endPoint = "http://ws.webxml.com.cn/WebServices/WeatherWS.asmx";
    // SOAP Action
    private final String soapAction = "http://WebXml.com.cn/getWeather";


    public static void sendHttpRequest(final String city,
                                       final HttpCallbackListener listener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 指定WebService的命名空间和调用的方法名
                SoapObject rpc = new SoapObject(nameSpace, methodName);

                // 设置需调用WebService接口需要传入的两个参数mobileCode、userId
                rpc.addProperty("theCityCode", city);
                rpc.addProperty("theUserID", "");

                // 生成调用WebService方法的SOAP请求信息,并指定SOAP的版本
                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER10);

                envelope.bodyOut = rpc;
                // 设置是否调用的是dotNet开发的WebService
                envelope.dotNet = true;
                // 等价于envelope.bodyOut = rpc;
                envelope.setOutputSoapObject(rpc);

                HttpTransportSE transport = new HttpTransportSE(endPoint);
                try {
                    // 调用WebService
                    transport.call(soapAction, envelope);

                    // 获取返回的数据
                    SoapObject response = (SoapObject) envelope.bodyIn;

                    if (listener != null) {
                        listener.onFinish(response);

                    }

                } catch (Exception e) {
                    if (listener != null) {
                        listener.onError(e);
                    }
                } finally {

                }
            }
        }).start();
    }


    /**
     *
     * not  do now
     */
//    public void getRemoteInfo(String city) {
//        // 命名空间
//        String nameSpace = "http://WebXml.com.cn/";
//        // 调用的方法名称
//        String methodName = "getWeather";
//        // EndPoint
//        String endPoint = "http://ws.webxml.com.cn/WebServices/WeatherWS.asmx";
//        // SOAP Action
//        String soapAction = "http://WebXml.com.cn/getWeather";
//
//        int length ;
//        List<String>result ;
//
//        // 指定WebService的命名空间和调用的方法名
//        SoapObject rpc = new SoapObject(nameSpace, methodName);
//
//        // 设置需调用WebService接口需要传入的两个参数mobileCode、userId
//        rpc.addProperty("theCityCode", city);
//        rpc.addProperty("theUserID", "");
//
//        // 生成调用WebService方法的SOAP请求信息,并指定SOAP的版本
//        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER10);
//
//        envelope.bodyOut = rpc;
//        // 设置是否调用的是dotNet开发的WebService
//        envelope.dotNet = true;
//        // 等价于envelope.bodyOut = rpc;
//        envelope.setOutputSoapObject(rpc);
//
//        HttpTransportSE transport = new HttpTransportSE(endPoint);
//        try {
//            // 调用WebService
//            transport.call(soapAction, envelope);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        // 获取返回的数据
//        SoapObject object = (SoapObject) envelope.bodyIn;
//        //获取长度
//        length = object.getPropertyCount();
//        result = new ArrayList<String>();
//
//        //系统维护
//        if (length < 2) {
//            return;
//        }
//        // 获取返回的结果
//        for (int i = 0;i<length;i++) {
//            result.add(object.getProperty(0).toString());
//        }
//
//        //这里可以是处理结果
//
//
//
//        String ERROR = "系统维护 免费用户服务暂停。http://www.webxml.com.cn/";
//    }
}

