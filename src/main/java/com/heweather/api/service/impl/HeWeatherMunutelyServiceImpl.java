package com.heweather.api.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heweather.api.dto.response.HeWeatherResponse;
import com.heweather.api.dto.response.Minutely;
import com.heweather.api.service.HeWeatherMunutelyService;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class HeWeatherMunutelyServiceImpl implements HeWeatherMunutelyService {
    public HeWeatherResponse getMinutely(String location, String key) {
        HeWeatherResponse heWeatherResponse = new HeWeatherResponse();
        String url = "https://api.heweather.net/v7/minutely/5m?";
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
        try{
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            String json = httpResponse.getEntity().toString();
            JSONObject response = (JSONObject) JSONObject.parse(json);
            if (response.get("code").equals("200")) {
                heWeatherResponse.setStatus("200");
                Minutely minutely = new Minutely();
                minutely.setFxLink(response.getString("fxLink"));
                minutely.setSummary(response.getString("summary"));
                minutely.setUpdateTime(response.getString("updateTime"));
                JSONObject minutely1 = response.getJSONObject("minutely");
                minutely.setFxTime(minutely1.getString("fxTime"));
                minutely.setPrecip(minutely1.getString("precip"));
                minutely.setType(minutely1.getString("type"));
                heWeatherResponse.setMinutely(minutely);
            }
        }catch (Exception e){
            e.printStackTrace();
            heWeatherResponse.setStatus("400");
        }
        return heWeatherResponse;
    }

    public HeWeatherResponse getMinutely(String location, String key, String lang) {
        HeWeatherResponse heWeatherResponse = new HeWeatherResponse();
        String url = "https://api.heweather.net/v7/minutely/5m?";
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
        if (lang != null && !lang.equals("")) {
            url = url + "&lang" + lang;
        } else {
            heWeatherResponse.setStatus("400");
            return heWeatherResponse;
        }
        try{
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            String json = httpResponse.getEntity().toString();
            JSONObject response = (JSONObject) JSONObject.parse(json);
            if (response.get("code").equals("200")) {
                heWeatherResponse.setStatus("200");
                Minutely minutely = new Minutely();
                minutely.setFxLink(response.getString("fxLink"));
                minutely.setSummary(response.getString("summary"));
                minutely.setUpdateTime(response.getString("updateTime"));
                JSONObject minutely1 = response.getJSONObject("minutely");
                minutely.setFxTime(minutely1.getString("fxTime"));
                minutely.setPrecip(minutely1.getString("precip"));
                minutely.setType(minutely1.getString("type"));
                heWeatherResponse.setMinutely(minutely);
            }
        }catch (Exception e){
            e.printStackTrace();
            heWeatherResponse.setStatus("400");
        }
        return heWeatherResponse;
    }
}
