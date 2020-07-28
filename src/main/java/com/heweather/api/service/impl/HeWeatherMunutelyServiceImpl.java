package com.heweather.api.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heweather.api.dto.response.HeWeatherResponse;
import com.heweather.api.dto.response.Minutely;
import com.heweather.api.service.HeWeatherMunutelyService;
import com.heweather.utils.SignUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.util.HashMap;

/**
 * 分钟级降水
 * add by djc
 */
public class HeWeatherMunutelyServiceImpl implements HeWeatherMunutelyService {

    @Override
    public HeWeatherResponse getMinutely(String location, String key, String sign) {

        HeWeatherResponse heWeatherResponse = new HeWeatherResponse();
        String URL = "https://api.heweather.net/v7/minutely/5m?";
        HashMap<String, String> params = new HashMap<>();
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
        } catch (Exception e) {
            e.printStackTrace();
            heWeatherResponse.setStatus("400");
        }
        return heWeatherResponse;
    }

    @Override
    public HeWeatherResponse getMinutely(String location, String key, String lang, String sign) {

        HeWeatherResponse heWeatherResponse = new HeWeatherResponse();
        String URL = "https://api.heweather.net/v7/minutely/5m?";
        HashMap<String, String> params = new HashMap<>();
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
        if (lang != null && !lang.equals("")) {
            URL = URL + "&lang" + lang;
            params.put("lang", lang);
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
        } catch (Exception e) {
            e.printStackTrace();
            heWeatherResponse.setStatus("400");
        }
        return heWeatherResponse;
    }
}
