package com.heweather.api.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.heweather.api.dto.response.HeWeatherResponse;
import com.heweather.api.dto.response.SunMoonData;
import com.heweather.api.dto.response.sunmoon.MoonPhase;
import com.heweather.api.dto.response.weatherinfo.Refer;
import com.heweather.api.service.HeWeatherAstronomyService;
import com.heweather.utils.SignUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.util.HashMap;
import java.util.List;

/**
 * 太阳和月亮请求处理
 * add by djc
 */
public class HeWeatherAstronomyServiceImpl implements HeWeatherAstronomyService {
    @Override
    public HeWeatherResponse geitSunmoon(String location, String key, String date, String sign) {

        HeWeatherResponse heWeatherResponse = new HeWeatherResponse();
        String URL = "https://api.heweather.net/v7/astronomy/sunmoon?";
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
                heWeatherResponse.setUpdateTime(response.getString("updateTime"));
                heWeatherResponse.setFxLink(response.getString("fxLink"));
                SunMoonData sunMoonData = new SunMoonData();
                sunMoonData.setSunset(response.getString("sunset"));
                sunMoonData.setSunrise(response.getString("sunrise"));
                sunMoonData.setMoonset(response.getString("moonrise"));
                sunMoonData.setMoonrise(response.getString("moonrise"));
                MoonPhase moonPhase = new MoonPhase();
                moonPhase.setFxTime(response.getJSONObject("moonPhase").getString("fxTime"));
                moonPhase.setIllumination(response.getJSONObject("moonPhase").getString("illumination"));
                moonPhase.setName(response.getJSONObject("moonPhase").getString("name"));
                moonPhase.setValue(response.getJSONObject("moonPhase").getString("value"));
                sunMoonData.setMoonPhase(moonPhase);
                Refer refer = new Refer();
                JSONObject refer1 = response.getJSONObject("refer");
                JSONArray sources = refer1.getJSONArray("sources");
                List<String> sourcesList = JSONObject.parseArray(sources.toJSONString(), String.class);
                JSONArray license = refer1.getJSONArray("license");
                List<String> licenseList = JSONObject.parseArray(license.toJSONString(), String.class);
                refer.setLicense(sourcesList);
                refer.setSources(licenseList);
                sunMoonData.setRefer(refer);
                heWeatherResponse.setSunMoonData(sunMoonData);
            }
        } catch (Exception e) {
            e.printStackTrace();
            heWeatherResponse.setStatus("400");
        }
        return heWeatherResponse;
    }

    @Override
    public HeWeatherResponse geitSunmoon(String location, String key, String date, String lang, String sign) {

        HeWeatherResponse heWeatherResponse = new HeWeatherResponse();
        String URL = "https://api.heweather.net/v7/astronomy/sunmoon?";
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
        if (date != null && !date.equals("")) {
            URL = URL + "&date" + date;
            params.put("date", date);
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
                heWeatherResponse.setUpdateTime(response.getString("updateTime"));
                heWeatherResponse.setFxLink(response.getString("fxLink"));
                SunMoonData sunMoonData = new SunMoonData();
                sunMoonData.setSunset(response.getString("sunset"));
                sunMoonData.setSunrise(response.getString("sunrise"));
                sunMoonData.setMoonset(response.getString("moonrise"));
                sunMoonData.setMoonrise(response.getString("moonrise"));
                MoonPhase moonPhase = new MoonPhase();
                moonPhase.setFxTime(response.getJSONObject("moonPhase").getString("fxTime"));
                moonPhase.setIllumination(response.getJSONObject("moonPhase").getString("illumination"));
                moonPhase.setName(response.getJSONObject("moonPhase").getString("name"));
                moonPhase.setValue(response.getJSONObject("moonPhase").getString("value"));
                sunMoonData.setMoonPhase(moonPhase);
                Refer refer = new Refer();
                JSONObject refer1 = response.getJSONObject("refer");
                JSONArray sources = refer1.getJSONArray("sources");
                List<String> sourcesList = JSONObject.parseArray(sources.toJSONString(), String.class);
                JSONArray license = refer1.getJSONArray("license");
                List<String> licenseList = JSONObject.parseArray(license.toJSONString(), String.class);
                refer.setLicense(sourcesList);
                refer.setSources(licenseList);
                sunMoonData.setRefer(refer);
                heWeatherResponse.setSunMoonData(sunMoonData);
            }
        } catch (Exception e) {
            e.printStackTrace();
            heWeatherResponse.setStatus("400");
        }
        return heWeatherResponse;
    }
}
