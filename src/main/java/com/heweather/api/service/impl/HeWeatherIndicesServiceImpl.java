package com.heweather.api.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.heweather.api.dto.ApiEnum;
import com.heweather.api.dto.response.HeWeatherResponse;
import com.heweather.api.dto.response.WeatherIndices;
import com.heweather.api.dto.response.indices.Daily;
import com.heweather.api.dto.response.weatherInfo.Refer;
import com.heweather.api.service.HeWeatherIndicesService;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.util.ArrayList;
import java.util.List;

public class HeWeatherIndicesServiceImpl implements HeWeatherIndicesService {
    public HeWeatherResponse getWeatherIndices(String location, String key, String type, String lang, ApiEnum apiEnum) {
        HeWeatherResponse heWeatherResponse = new HeWeatherResponse();
        String url = "https://api.heweather.net/v7/indices/";
        if (apiEnum != null && !apiEnum.getName().equals("")) {
            url = url + apiEnum.getValue();
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
        if (type != null && !type.equals("")) {
            url = url + "&type" + type;
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
                heWeatherResponse.setUpdateTime(response.getString("updateTime"));
                heWeatherResponse.setFxLink(response.getString("fxLink"));
                JSONArray dailys = response.getJSONArray("daily");
                List<JSONObject> list = JSONObject.parseArray(dailys.toJSONString(), JSONObject.class);
                List<Daily> dailyList = new ArrayList<Daily>();
                for(JSONObject jsonObject : list){
                    Daily daily = new Daily();
                    daily.setCategory(jsonObject.getString("category"));
                    daily.setDate(jsonObject.getString("date"));
                    daily.setLevel(jsonObject.getString("level"));
                    daily.setName(jsonObject.getString("name"));
                    daily.setText(jsonObject.getString("txt"));
                    daily.setType(jsonObject.getString("type"));
                    dailyList.add(daily);
                }
                Refer refer = new Refer();
                JSONObject refer1 = response.getJSONObject("refer");
                JSONArray sources = refer1.getJSONArray("sources");
                List<String> sourcesList = JSONObject.parseArray(sources.toJSONString(), String.class);
                JSONArray license = refer1.getJSONArray("license");
                List<String> licenseList = JSONObject.parseArray(license.toJSONString(), String.class);
                refer.setLicense(sourcesList);
                refer.setSources(licenseList);
                WeatherIndices weatherIndices = new WeatherIndices();
                weatherIndices.setDaily(dailyList);
                weatherIndices.setRefer(refer);
                heWeatherResponse.setWeatherIndices(weatherIndices);
            }
        }catch (Exception e){
            e.printStackTrace();
            heWeatherResponse.setStatus("400");
        }
        return heWeatherResponse;
    }

    public HeWeatherResponse getWeatherIndices(String location, String key, String type, ApiEnum apiEnum) {
        HeWeatherResponse heWeatherResponse = new HeWeatherResponse();
        String url = "https://api.heweather.net/v7/indices/";
        if (apiEnum != null && !apiEnum.getName().equals("")) {
            url = url + apiEnum.getValue();
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
        if (type != null && !type.equals("")) {
            url = url + "&type" + type;
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
                heWeatherResponse.setUpdateTime(response.getString("updateTime"));
                heWeatherResponse.setFxLink(response.getString("fxLink"));
                JSONArray dailys = response.getJSONArray("daily");
                List<JSONObject> list = JSONObject.parseArray(dailys.toJSONString(), JSONObject.class);
                List<Daily> dailyList = new ArrayList<Daily>();
                for(JSONObject jsonObject : list){
                    Daily daily = new Daily();
                    daily.setCategory(jsonObject.getString("category"));
                    daily.setDate(jsonObject.getString("date"));
                    daily.setLevel(jsonObject.getString("level"));
                    daily.setName(jsonObject.getString("name"));
                    daily.setText(jsonObject.getString("txt"));
                    daily.setType(jsonObject.getString("type"));
                    dailyList.add(daily);
                }
                Refer refer = new Refer();
                JSONObject refer1 = response.getJSONObject("refer");
                JSONArray sources = refer1.getJSONArray("sources");
                List<String> sourcesList = JSONObject.parseArray(sources.toJSONString(), String.class);
                JSONArray license = refer1.getJSONArray("license");
                List<String> licenseList = JSONObject.parseArray(license.toJSONString(), String.class);
                refer.setLicense(sourcesList);
                refer.setSources(licenseList);
                WeatherIndices weatherIndices = new WeatherIndices();
                weatherIndices.setDaily(dailyList);
                weatherIndices.setRefer(refer);
                heWeatherResponse.setWeatherIndices(weatherIndices);
            }
        }catch (Exception e){
            e.printStackTrace();
            heWeatherResponse.setStatus("400");
        }
        return heWeatherResponse;
    }
}
