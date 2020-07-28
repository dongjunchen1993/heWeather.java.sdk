package com.heweather.api.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.heweather.api.dto.ApiEnum;
import com.heweather.api.dto.response.HeWeatherResponse;
import com.heweather.api.dto.response.WeatherInfo;
import com.heweather.api.dto.response.weatherInfo.Daily;
import com.heweather.api.dto.response.weatherInfo.Hourly;
import com.heweather.api.dto.response.weatherInfo.Now;
import com.heweather.api.dto.response.weatherInfo.Refer;
import com.heweather.api.service.HeWertherInfoService;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.util.ArrayList;
import java.util.List;

/**
 * 天气预报和实况
 * add by djc
 */
public class HeWertherInfoServiceImpl implements HeWertherInfoService {

    public HeWeatherResponse getWeatherInfo(String location, String key, ApiEnum apiEnum) {

        HeWeatherResponse heWeatherResponse = new HeWeatherResponse();
        String url = "https://api.heweather.net/v7/weather/";
        if (apiEnum != null && !apiEnum.getName().equals("")) {
            url = url + apiEnum.getValue();
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
                if (response.containsKey("now")) {
                    WeatherInfo weatherInfo = new WeatherInfo();
                    Now now = new Now();
                    now.setCloud(response.getString("cloud"));
                    now.setDew(response.getString("dew"));
                    now.setFeelsLike(response.getString("feelsLike"));
                    now.setHumidity(response.getString("humidity"));
                    now.setIcon(response.getString("icon"));
                    now.setObsTime(response.getString("obsTime"));
                    now.setPrecip(response.getString("precip"));
                    now.setPressure(response.getString("pressure"));
                    now.setTemp(response.getString("temp"));
                    now.setText(response.getString("text"));
                    now.setVis(response.getString("vis"));
                    now.setWind360(response.getString("wind360"));
                    now.setWindDir(response.getString("windDir"));
                    now.setWindScale(response.getString("windScale"));
                    now.setWindSpeed(response.getString("windSpeed"));
                    weatherInfo.setNow(now);
                    heWeatherResponse.setWeatherInfo(weatherInfo);
                } else if (response.containsKey("daily")) {
                    WeatherInfo weatherInfo = new WeatherInfo();
                    JSONArray dailyList = response.getJSONArray("daily");
                    List<JSONObject> list = JSONObject.parseArray(dailyList.toJSONString(), JSONObject.class);
                    List<Daily> dailies = new ArrayList<Daily>();
                    for (JSONObject jsonObject : list) {
                        Daily daily = new Daily();
                        daily.setCloud(jsonObject.getString("cloud"));
                        daily.setFxDate(jsonObject.getString("fxDate"));
                        daily.setHumidity(jsonObject.getString("humidity"));
                        daily.setIconDay(jsonObject.getString("iconDay"));
                        daily.setIconNight(jsonObject.getString("iconNight"));
                        daily.setMoonPhase(jsonObject.getString("moonPhase"));
                        daily.setMoonrise(jsonObject.getString("moonrise"));
                        daily.setPrecip(jsonObject.getString("precip"));
                        daily.setPressure(jsonObject.getString("pressure"));
                        daily.setMoonset(jsonObject.getString("moonset"));
                        daily.setWindSpeedNight(jsonObject.getString("windSpeedNight"));
                        daily.setWindSpeedDay(jsonObject.getString("windSpeedDay"));
                        daily.setWindScaleNight(jsonObject.getString("windScaleNight"));
                        daily.setWindScaleDay(jsonObject.getString("windScaleDay"));
                        daily.setWindDirNight(jsonObject.getString("windDirNight"));
                        daily.setWindDirDay(jsonObject.getString("windDirDay"));
                        daily.setWind360Night(jsonObject.getString("wind360Night"));
                        daily.setWind360Day(jsonObject.getString("wind360Day"));
                        daily.setVis(jsonObject.getString("vis"));
                        daily.setTempMin(jsonObject.getString("tempMin"));
                        daily.setTempMax(jsonObject.getString("tempMax"));
                        daily.setSunset(jsonObject.getString("sunset"));
                        daily.setSunrise(jsonObject.getString("sunrise"));
                        daily.setUvIndex(jsonObject.getString("uvIndex"));
                        daily.setTextNight(jsonObject.getString("textNight"));
                        daily.setTextDay(jsonObject.getString("textDay"));
                        dailies.add(daily);
                    }
                    weatherInfo.setDaily(dailies);
                    Refer refer = new Refer();
                    JSONObject refer1 = response.getJSONObject("refer");
                    JSONArray sources = refer1.getJSONArray("sources");
                    List<String> sourcesList = JSONObject.parseArray(sources.toJSONString(), String.class);
                    JSONArray license = refer1.getJSONArray("license");
                    List<String> licenseList = JSONObject.parseArray(license.toJSONString(), String.class);
                    refer.setLicense(sourcesList);
                    refer.setSources(licenseList);
                    weatherInfo.setRefer(refer);
                    heWeatherResponse.setWeatherInfo(weatherInfo);
                } else if (response.containsKey("hourly")) {
                    WeatherInfo weatherInfo = new WeatherInfo();
                    JSONArray hourlyList = response.getJSONArray("hourly");
                    List<JSONObject> list = JSONObject.parseArray(hourlyList.toJSONString(), JSONObject.class);
                    List<Hourly> hourlyes = new ArrayList<Hourly>();
                    for (JSONObject jsonObject : list) {
                        Hourly hourly = new Hourly();
                        hourly.setFxTime(jsonObject.getString("fxTime"));
                        hourly.setCloud(jsonObject.getString("cloud"));
                        hourly.setDew(jsonObject.getString("dew"));
                        hourly.setPop(jsonObject.getString("pop"));
                        hourly.setHumidity(jsonObject.getString("humidity"));
                        hourly.setIcon(jsonObject.getString("icon"));
                        hourly.setPrecip(jsonObject.getString("precip"));
                        hourly.setPressure(jsonObject.getString("pressure"));
                        hourly.setTemp(jsonObject.getString("temp"));
                        hourly.setText(jsonObject.getString("text"));
                        hourly.setWind360(jsonObject.getString("wind360"));
                        hourly.setWindDir(jsonObject.getString("windDir"));
                        hourly.setWindScale(jsonObject.getString("windScale"));
                        hourly.setWindSpeed(jsonObject.getString("windSpeed"));
                        hourlyes.add(hourly);
                        weatherInfo.setHourly(hourlyes);
                    }
                    heWeatherResponse.setWeatherInfo(weatherInfo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            heWeatherResponse.setStatus("400");
        }
        return heWeatherResponse;
    }

    public HeWeatherResponse getWeatherInfo(String location, String key, String lang, String unit, ApiEnum apiEnum) {
        HeWeatherResponse heWeatherResponse = new HeWeatherResponse();
        String url = "https://api.heweather.net/v7/weather/";
        if (apiEnum != null && !apiEnum.getName().equals("")) {
            url = url + apiEnum.getValue();
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
        if (unit != null && !unit.equals("")) {
            url = url + "&unit" + unit;
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
                if (response.containsKey("now")) {
                    heWeatherResponse.setStatus("200");
                    WeatherInfo weatherInfo = new WeatherInfo();
                    weatherInfo.setUpdateTime(response.getString("updateTime"));
                    weatherInfo.setFxLink(response.getString("fxLink"));
                    Now now = new Now();
                    now.setCloud(response.getString("cloud"));
                    now.setDew(response.getString("dew"));
                    now.setFeelsLike(response.getString("feelsLike"));
                    now.setHumidity(response.getString("humidity"));
                    now.setIcon(response.getString("icon"));
                    now.setObsTime(response.getString("obsTime"));
                    now.setPrecip(response.getString("precip"));
                    now.setPressure(response.getString("pressure"));
                    now.setTemp(response.getString("temp"));
                    now.setText(response.getString("text"));
                    now.setVis(response.getString("vis"));
                    now.setWind360(response.getString("wind360"));
                    now.setWindDir(response.getString("windDir"));
                    now.setWindScale(response.getString("windScale"));
                    now.setWindSpeed(response.getString("windSpeed"));
                    weatherInfo.setNow(now);
                    heWeatherResponse.setWeatherInfo(weatherInfo);
                } else if (response.containsKey("daily")) {
                    heWeatherResponse.setStatus("200");
                    WeatherInfo weatherInfo = new WeatherInfo();
                    weatherInfo.setUpdateTime(response.getString("updateTime"));
                    weatherInfo.setFxLink(response.getString("fxLink"));
                    JSONArray dailyList = response.getJSONArray("daily");
                    List<JSONObject> list = JSONObject.parseArray(dailyList.toJSONString(), JSONObject.class);
                    List<Daily> dailies = new ArrayList<Daily>();
                    for (JSONObject jsonObject : list) {
                        Daily daily = new Daily();
                        daily.setCloud(jsonObject.getString("cloud"));
                        daily.setFxDate(jsonObject.getString("fxDate"));
                        daily.setHumidity(jsonObject.getString("humidity"));
                        daily.setIconDay(jsonObject.getString("iconDay"));
                        daily.setIconNight(jsonObject.getString("iconNight"));
                        daily.setMoonPhase(jsonObject.getString("moonPhase"));
                        daily.setMoonrise(jsonObject.getString("moonrise"));
                        daily.setPrecip(jsonObject.getString("precip"));
                        daily.setPressure(jsonObject.getString("pressure"));
                        daily.setMoonset(jsonObject.getString("moonset"));
                        daily.setWindSpeedNight(jsonObject.getString("windSpeedNight"));
                        daily.setWindSpeedDay(jsonObject.getString("windSpeedDay"));
                        daily.setWindScaleNight(jsonObject.getString("windScaleNight"));
                        daily.setWindScaleDay(jsonObject.getString("windScaleDay"));
                        daily.setWindDirNight(jsonObject.getString("windDirNight"));
                        daily.setWindDirDay(jsonObject.getString("windDirDay"));
                        daily.setWind360Night(jsonObject.getString("wind360Night"));
                        daily.setWind360Day(jsonObject.getString("wind360Day"));
                        daily.setVis(jsonObject.getString("vis"));
                        daily.setTempMin(jsonObject.getString("tempMin"));
                        daily.setTempMax(jsonObject.getString("tempMax"));
                        daily.setSunset(jsonObject.getString("sunset"));
                        daily.setSunrise(jsonObject.getString("sunrise"));
                        daily.setUvIndex(jsonObject.getString("uvIndex"));
                        daily.setTextNight(jsonObject.getString("textNight"));
                        daily.setTextDay(jsonObject.getString("textDay"));
                        dailies.add(daily);
                    }
                    weatherInfo.setDaily(dailies);
                    heWeatherResponse.setWeatherInfo(weatherInfo);
                } else if (response.containsKey("hourly")) {
                    heWeatherResponse.setStatus("200");
                    WeatherInfo weatherInfo = new WeatherInfo();
                    weatherInfo.setUpdateTime(response.getString("updateTime"));
                    weatherInfo.setFxLink(response.getString("fxLink"));
                    JSONArray hourlyList = response.getJSONArray("hourly");
                    List<JSONObject> list = JSONObject.parseArray(hourlyList.toJSONString(), JSONObject.class);
                    List<Hourly> hourlyes = new ArrayList<Hourly>();
                    for (JSONObject jsonObject : list) {
                        Hourly hourly = new Hourly();
                        hourly.setFxTime(jsonObject.getString("fxTime"));
                        hourly.setCloud(jsonObject.getString("cloud"));
                        hourly.setDew(jsonObject.getString("dew"));
                        hourly.setPop(jsonObject.getString("pop"));
                        hourly.setHumidity(jsonObject.getString("humidity"));
                        hourly.setIcon(jsonObject.getString("icon"));
                        hourly.setPrecip(jsonObject.getString("precip"));
                        hourly.setPressure(jsonObject.getString("pressure"));
                        hourly.setTemp(jsonObject.getString("temp"));
                        hourly.setText(jsonObject.getString("text"));
                        hourly.setWind360(jsonObject.getString("wind360"));
                        hourly.setWindDir(jsonObject.getString("windDir"));
                        hourly.setWindScale(jsonObject.getString("windScale"));
                        hourly.setWindSpeed(jsonObject.getString("windSpeed"));
                        hourlyes.add(hourly);
                        weatherInfo.setHourly(hourlyes);
                    }
                    heWeatherResponse.setWeatherInfo(weatherInfo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            heWeatherResponse.setStatus("400");
        }
        return heWeatherResponse;
    }
}
