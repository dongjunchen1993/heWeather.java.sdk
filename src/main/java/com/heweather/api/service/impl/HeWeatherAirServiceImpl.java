package com.heweather.api.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.heweather.api.dto.ENUM_WHEATHER_TIME;
import com.heweather.api.dto.response.AirQualit;
import com.heweather.api.dto.response.HeWeatherResponse;
import com.heweather.api.dto.response.airQualit.Daily;
import com.heweather.api.dto.response.airQualit.Now;
import com.heweather.api.dto.response.airQualit.Station;
import com.heweather.api.dto.response.weatherInfo.Refer;
import com.heweather.api.service.HeWeatherAirService;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.util.ArrayList;
import java.util.List;

public class HeWeatherAirServiceImpl implements HeWeatherAirService {
    public HeWeatherResponse getWeatherAir(String location, String key, String lang, ENUM_WHEATHER_TIME enum_wheather_time) {
        HeWeatherResponse heWeatherResponse = new HeWeatherResponse();
        String url = "https://api.heweather.net/v7/air/";
        if (enum_wheather_time != null && !enum_wheather_time.getName().equals("")) {
            url = url + enum_wheather_time.getValue();
        } else {
            heWeatherResponse.setStatus("400");
            return heWeatherResponse;
        }
        if (location != null && !location.equals("")) {
            url = url + "&location" + location;
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
                heWeatherResponse.setUpdateTime(response.getString("updateTime"));
                heWeatherResponse.setFxLink(response.getString("fxLink"));
                AirQualit airQualit = new AirQualit();
                if (response.containsKey("now")) {
                    JSONObject nowobj = response.getJSONObject("now");
                    Now now = new Now();
                    now.setAqi(nowobj.getString("aqi"));
                    now.setCategory(nowobj.getString("category"));
                    now.setCo(nowobj.getString("co"));
                    now.setNo2(nowobj.getString("no2"));
                    now.setO3(nowobj.getString("o3"));
                    now.setPm2p5(nowobj.getString("pm2p5"));
                    now.setPm10(nowobj.getString("pm10"));
                    now.setPrimary(nowobj.getString("primary"));
                    now.setPubTime(nowobj.getString("pubTime"));
                    now.setSo2(nowobj.getString("so2"));
                    JSONArray stationes= response.getJSONArray("station");
                    List<Station> stationList = new ArrayList<Station>();
                    List<JSONObject> list = JSONObject.parseArray(stationes.toJSONString(), JSONObject.class);
                    for(JSONObject jsonObject: list){
                        Station station = new Station();
                        station.setAqi(jsonObject.getString("api"));
                        station.setCategory(jsonObject.getString("category"));
                        station.setCo(jsonObject.getString("co"));
                        station.setId(jsonObject.getString("stationId"));
                        station.setLevel(jsonObject.getString("level"));
                        station.setName(jsonObject.getString("stationName"));
                        station.setNo2(jsonObject.getString("no2"));
                        station.setO3(jsonObject.getString("o3"));
                        station.setPm2p5(jsonObject.getString("pm2p5"));
                        station.setPm10(jsonObject.getString("pm10"));
                        station.setPrimary(jsonObject.getString("primary"));
                        station.setPubTime(jsonObject.getString("pubTime"));
                        station.setSo2(jsonObject.getString("so2"));
                        stationList.add(station);
                    }
                    Refer refer = new Refer();
                    JSONObject refer1 = response.getJSONObject("refer");
                    JSONArray sources = refer1.getJSONArray("sources");
                    List<String> sourcesList = JSONObject.parseArray(sources.toJSONString(), String.class);
                    JSONArray license = refer1.getJSONArray("license");
                    List<String> licenseList = JSONObject.parseArray(license.toJSONString(), String.class);
                    refer.setLicense(sourcesList);
                    refer.setSources(licenseList);
                    airQualit.setNow(now);
                    airQualit.setStation(stationList);
                    airQualit.setRefer(refer);
                    heWeatherResponse.setAirQualit(airQualit);
                }else if (response.containsKey("daily")){
                    List<Daily> dailyList = new ArrayList<Daily>();
                    JSONArray dailies= response.getJSONArray("station");
                    List<JSONObject> list = JSONObject.parseArray(dailies.toJSONString(), JSONObject.class);
                    for(JSONObject jsonObject:list){
                        Daily daily = new Daily();
                        daily.setAqi(jsonObject.getString("aqi"));
                        daily.setCategory(jsonObject.getString("category"));
                        daily.setFxDate(jsonObject.getString("fxDate"));
                        daily.setPrimary(jsonObject.getString("primary"));
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
                    airQualit.setDaily(dailyList);
                    airQualit.setRefer(refer);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            heWeatherResponse.setStatus("400");
        }
        return heWeatherResponse;
    }

    public HeWeatherResponse getWeatherAir(String location, String key, ENUM_WHEATHER_TIME enum_wheather_time) {
        HeWeatherResponse heWeatherResponse = new HeWeatherResponse();
        String url = "https://api.heweather.net/v7/air/";
        if (enum_wheather_time != null && !enum_wheather_time.getName().equals("")) {
            url = url + enum_wheather_time.getValue();
        } else {
            heWeatherResponse.setStatus("400");
            return heWeatherResponse;
        }
        if (location != null && !location.equals("")) {
            url = url + "&location" + location;
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
                heWeatherResponse.setUpdateTime(response.getString("updateTime"));
                heWeatherResponse.setFxLink(response.getString("fxLink"));
                AirQualit airQualit = new AirQualit();
                if (response.containsKey("now")) {
                    JSONObject nowobj = response.getJSONObject("now");
                    Now now = new Now();
                    now.setAqi(nowobj.getString("aqi"));
                    now.setCategory(nowobj.getString("category"));
                    now.setCo(nowobj.getString("co"));
                    now.setNo2(nowobj.getString("no2"));
                    now.setO3(nowobj.getString("o3"));
                    now.setPm2p5(nowobj.getString("pm2p5"));
                    now.setPm10(nowobj.getString("pm10"));
                    now.setPrimary(nowobj.getString("primary"));
                    now.setPubTime(nowobj.getString("pubTime"));
                    now.setSo2(nowobj.getString("so2"));
                    JSONArray stationes= response.getJSONArray("station");
                    List<Station> stationList = new ArrayList<Station>();
                    List<JSONObject> list = JSONObject.parseArray(stationes.toJSONString(), JSONObject.class);
                    for(JSONObject jsonObject: list){
                        Station station = new Station();
                        station.setAqi(jsonObject.getString("api"));
                        station.setCategory(jsonObject.getString("category"));
                        station.setCo(jsonObject.getString("co"));
                        station.setId(jsonObject.getString("stationId"));
                        station.setLevel(jsonObject.getString("level"));
                        station.setName(jsonObject.getString("stationName"));
                        station.setNo2(jsonObject.getString("no2"));
                        station.setO3(jsonObject.getString("o3"));
                        station.setPm2p5(jsonObject.getString("pm2p5"));
                        station.setPm10(jsonObject.getString("pm10"));
                        station.setPrimary(jsonObject.getString("primary"));
                        station.setPubTime(jsonObject.getString("pubTime"));
                        station.setSo2(jsonObject.getString("so2"));
                        stationList.add(station);
                    }
                    Refer refer = new Refer();
                    JSONObject refer1 = response.getJSONObject("refer");
                    JSONArray sources = refer1.getJSONArray("sources");
                    List<String> sourcesList = JSONObject.parseArray(sources.toJSONString(), String.class);
                    JSONArray license = refer1.getJSONArray("license");
                    List<String> licenseList = JSONObject.parseArray(license.toJSONString(), String.class);
                    refer.setLicense(sourcesList);
                    refer.setSources(licenseList);
                    airQualit.setNow(now);
                    airQualit.setStation(stationList);
                    airQualit.setRefer(refer);
                    heWeatherResponse.setAirQualit(airQualit);
                }else if (response.containsKey("daily")){
                    List<Daily> dailyList = new ArrayList<Daily>();
                    JSONArray dailies= response.getJSONArray("station");
                    List<JSONObject> list = JSONObject.parseArray(dailies.toJSONString(), JSONObject.class);
                    for(JSONObject jsonObject:list){
                        Daily daily = new Daily();
                        daily.setAqi(jsonObject.getString("aqi"));
                        daily.setCategory(jsonObject.getString("category"));
                        daily.setFxDate(jsonObject.getString("fxDate"));
                        daily.setPrimary(jsonObject.getString("primary"));
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
                    airQualit.setDaily(dailyList);
                    airQualit.setRefer(refer);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            heWeatherResponse.setStatus("400");
        }
        return heWeatherResponse;
    }
}
