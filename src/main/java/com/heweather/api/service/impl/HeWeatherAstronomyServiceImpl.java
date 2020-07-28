package com.heweather.api.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.heweather.api.dto.response.HeWeatherResponse;
import com.heweather.api.dto.response.SunMoonData;
import com.heweather.api.dto.response.sunmoon.MoonPhase;
import com.heweather.api.dto.response.weatherinfo.Refer;
import com.heweather.api.service.HeWeatherAstronomyService;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.util.List;

/**
 * 太阳和月亮请求处理
 * add by djc
 */
public class HeWeatherAstronomyServiceImpl implements HeWeatherAstronomyService {
    @Override
    public HeWeatherResponse geitSunmoon(String location, String key, String date) {

        HeWeatherResponse heWeatherResponse = new HeWeatherResponse();
        String url = "https://api.heweather.net/v7/astronomy/sunmoon?";
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
        if (date != null && !date.equals("")) {
            url = url + "&date" + date;
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
    public HeWeatherResponse geitSunmoon(String location, String key, String date, String lang) {

        HeWeatherResponse heWeatherResponse = new HeWeatherResponse();
        String url = "https://api.heweather.net/v7/astronomy/sunmoon?";
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
        if (date != null && !date.equals("")) {
            url = url + "&date" + date;
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
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);
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
