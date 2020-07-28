package com.heweather.api.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heweather.api.dto.TypeEnum;
import com.heweather.api.dto.UnitEnum;
import com.heweather.api.dto.response.HeWeatherResponse;
import com.heweather.api.service.HeWeatherHistoricalService;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * 历史天气空气请求处理
 * add by djc
 */
public class HeWeatherHistoricalServiceImpl implements HeWeatherHistoricalService {

    public HeWeatherResponse getWeatherPoi(TypeEnum enum_type_code, String location, String key, String date) {

        HeWeatherResponse heWeatherResponse = new HeWeatherResponse();
        String url = "https://api.heweather.net/v7/weather-poi/";
        if (enum_type_code != null && !enum_type_code.getName().equals("")) {
            url = url + enum_type_code.getValue();
        } else {
            heWeatherResponse.setStatus("400");
            return heWeatherResponse;
        }
        if (location != null && !location.equals("")) {
            url = url + "location" + location;
        } else {
            heWeatherResponse.setStatus("400");
            return heWeatherResponse;
        }
        if (key != null && !key.equals("")) {
            url = url + "&key" + key;
        } else {
            heWeatherResponse.setStatus("400");
            return heWeatherResponse;
        }
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            String json = httpResponse.getEntity().toString();
            JSONObject response = (JSONObject) JSONObject.parse(json);
            if (response.get("code").equals("200")) {
                heWeatherResponse.setStatus("200");
                heWeatherResponse.setFxLink(response.getString("fxLink"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public HeWeatherResponse getWeatherPoi(TypeEnum enum_type_code, String location, String key, String date, String lang, UnitEnum enum_unit_code) {

        HeWeatherResponse heWeatherResponse = new HeWeatherResponse();
        String url = "https://api.heweather.net/v7/weather-poi/";
        if (enum_type_code != null && !enum_type_code.getName().equals("")) {
            url = url + enum_type_code.getValue();
        } else {
            heWeatherResponse.setStatus("400");
            return heWeatherResponse;
        }
        if (location != null && !location.equals("")) {
            url = url + "location" + location;
        } else {
            heWeatherResponse.setStatus("400");
            return heWeatherResponse;
        }
        if (key != null && !key.equals("")) {
            url = url + "&key" + key;
        } else {
            heWeatherResponse.setStatus("400");
            return heWeatherResponse;
        }
        if (enum_unit_code != null && !enum_unit_code.getName().equals("")) {
            url = url + enum_unit_code.getValue();
        } else {
            heWeatherResponse.setStatus("400");
            return heWeatherResponse;
        }
        return null;
    }
}
