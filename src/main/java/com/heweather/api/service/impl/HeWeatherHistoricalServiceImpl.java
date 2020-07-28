package com.heweather.api.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heweather.api.dto.TypeEnum;
import com.heweather.api.dto.UnitEnum;
import com.heweather.api.dto.response.HeWeatherResponse;
import com.heweather.api.service.HeWeatherHistoricalService;
import com.heweather.utils.SignUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.util.HashMap;

/**
 * 历史天气空气请求处理
 * add by djc
 */
public class HeWeatherHistoricalServiceImpl implements HeWeatherHistoricalService {
    @Override
    public HeWeatherResponse getWeatherPoi(TypeEnum enum_type_code, String location, String key, String date, String sign) {

        HeWeatherResponse heWeatherResponse = new HeWeatherResponse();
        String URL = "https://api.heweather.net/v7/weather-poi/";
        HashMap<String, String> params = new HashMap<>();
        if (enum_type_code != null) {
            URL = URL + enum_type_code.getValue();
        } else {
            heWeatherResponse.setStatus("400");
            return heWeatherResponse;
        }
        if (location != null && !location.equals("")) {
            URL = URL + "location" + location;
            params.put("location", location);
        } else {
            heWeatherResponse.setStatus("400");
            return heWeatherResponse;
        }
        if (key != null && !key.equals("")) {
            URL = URL + "&username" + key;
            params.put("username", key);
        } else {
            heWeatherResponse.setStatus("400");
            return heWeatherResponse;
        }
        if (date != null && !date.equals("")) {
            URL = URL + "&date" + date;
            params.put("date", date);
        } else {
            heWeatherResponse.setStatus("400");
            return heWeatherResponse;
        }
        String t = String.valueOf(System.currentTimeMillis() / 1000);
        URL = URL + "&t" + t;
        params.put("t", t);
        String secret = sign;
        try {
            String signature = SignUtils.getSignature(params, secret);
            URL = URL + "&sign" + signature;
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(URL);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            String json = httpResponse.getEntity().toString();
            JSONObject response = (JSONObject) JSONObject.parse(json);
            if (response.get("code").equals("200")) {
                heWeatherResponse.setStatus("200");
                heWeatherResponse.setFxLink(response.getString("fxLink"));

            } else {
                heWeatherResponse.setStatus("400");
                return heWeatherResponse;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public HeWeatherResponse getWeatherPoi(TypeEnum enum_type_code, String location, String key, String date, String lang, UnitEnum enum_unit_code, String sign) {

        HeWeatherResponse heWeatherResponse = new HeWeatherResponse();
        String URL = "https://api.heweather.net/v7/weather-poi/";
        HashMap<String, String> params = new HashMap<>();
        if (enum_type_code != null && !enum_type_code.getName().equals("")) {
            URL = URL + enum_type_code.getValue();
        } else {
            heWeatherResponse.setStatus("400");
            return heWeatherResponse;
        }
        if (location != null && !location.equals("")) {
            URL = URL + "location" + location;
        } else {
            heWeatherResponse.setStatus("400");
            return heWeatherResponse;
        }
        if (key != null && !key.equals("")) {
            URL = URL + "&key" + key;
        } else {
            heWeatherResponse.setStatus("400");
            return heWeatherResponse;
        }
        if (enum_unit_code != null) {
            URL = URL + "&unit" + enum_unit_code.getValue();
            params.put("unit", enum_unit_code.getValue());
        } else {
            heWeatherResponse.setStatus("400");
            return heWeatherResponse;
        }
        if (date != null && !date.equals("")) {
            URL = URL + "&date" + date;
            params.put("date", date);
        } else {
            heWeatherResponse.setStatus("400");
            return heWeatherResponse;
        }
        String t = String.valueOf(System.currentTimeMillis() / 1000);
        URL = URL + "&t" + t;
        params.put("t", t);
        String secret = sign;
        try {
            String signature = SignUtils.getSignature(params, secret);
            URL = URL + "&sign" + signature;
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(URL);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            String json = httpResponse.getEntity().toString();
            JSONObject response = (JSONObject) JSONObject.parse(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
