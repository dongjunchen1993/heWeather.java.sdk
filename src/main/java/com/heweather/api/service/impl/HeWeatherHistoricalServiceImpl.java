package com.heweather.api.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.heweather.api.InitializeSign;
import com.heweather.api.dto.TypeEnum;
import com.heweather.api.dto.UnitEnum;
import com.heweather.api.dto.response.HeWeatherResponse;
import com.heweather.api.dto.response.WeatherHistory;
import com.heweather.api.dto.response.history.AirHourly;
import com.heweather.api.dto.response.history.WeatherDaily;
import com.heweather.api.dto.response.history.WeatherHourly;
import com.heweather.api.dto.response.weatherinfo.Refer;
import com.heweather.api.service.HeWeatherHistoricalService;
import com.heweather.utils.SignUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 历史天气空气请求处理
 * add by djc
 */
public class HeWeatherHistoricalServiceImpl implements HeWeatherHistoricalService {
    @Override
    public HeWeatherResponse getWeatherPoi(TypeEnum enum_type_code, String location, String date) {

        HeWeatherResponse heWeatherResponse = new HeWeatherResponse();
        String URL = "https://api.heweather.net/v7/weather-poi/";
        HashMap<String, String> params = new HashMap<>();
        String key;
        String sign;
        try{
            key = InitializeSign.getKey();
            sign = InitializeSign.getSign();
        }catch (Exception e){
            e.printStackTrace();
            heWeatherResponse.setStatus("4001");
            return heWeatherResponse;
        }
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
    public HeWeatherResponse getWeatherPoi(TypeEnum enum_type_code, String location, String date, String lang, UnitEnum enum_unit_code) {

        HeWeatherResponse heWeatherResponse = new HeWeatherResponse();
        String URL = "https://api.heweather.net/v7/weather-poi/";
        HashMap<String, String> params = new HashMap<>();
        String key;
        String sign;
        try{
            key = InitializeSign.getKey();
            sign = InitializeSign.getSign();
        }catch (Exception e){
            e.printStackTrace();
            heWeatherResponse.setStatus("4001");
            return heWeatherResponse;
        }
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
        if (lang != null && !lang.equals("")) {
            URL = URL + "&lang" + date;
            params.put("lang", date);
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
            if(response.containsKey("weatherDaily")){
                WeatherHistory weatherHistory = new WeatherHistory();
                heWeatherResponse.setFxLink(response.getString("fxLink"));
                JSONObject weatherDaily1 = response.getJSONObject("weatherDaily");
                WeatherDaily weatherDaily = new WeatherDaily();
                weatherDaily.setPressure(weatherDaily1.getString("pressure"));
                weatherDaily.setPrecip(weatherDaily1.getString("precip"));
                weatherDaily.setHumidity(weatherDaily1.getString("humidity"));
                weatherDaily.setDate(weatherDaily1.getString("date"));
                weatherDaily.setMoonPhase(weatherDaily1.getString("moonPhase"));
                weatherDaily.setMoonrise(weatherDaily1.getString("moonrise"));
                weatherDaily.setMoonset(weatherDaily1.getString("moonset"));
                weatherDaily.setSunrise(weatherDaily1.getString("sunrise"));
                weatherDaily.setSunset(weatherDaily1.getString("sunset"));
                weatherDaily.setTempMax(weatherDaily1.getString("tempMax"));
                weatherDaily.setTempMin(weatherDaily1.getString("tempMin"));
                weatherHistory.setWeatherDaily(weatherDaily);

                JSONArray weatherHourlies = response.getJSONArray("weatherHourly");
                List<WeatherHourly> weatherHourlyList = new ArrayList<WeatherHourly>();
                List<JSONObject> list = JSONObject.parseArray(weatherHourlies.toJSONString(), JSONObject.class);
                for(JSONObject jsonObject : list){
                    WeatherHourly weatherHourly = new WeatherHourly();
                    weatherHourly.setHumidity(jsonObject.getString("humidity"));
                    weatherHourly.setIcon(jsonObject.getString("icon"));
                    weatherHourly.setPrecip(jsonObject.getString("precip"));
                    weatherHourly.setPressure(jsonObject.getString("pressure"));
                    weatherHourly.setTemp(jsonObject.getString("temp"));
                    weatherHourly.setText(jsonObject.getString("text"));
                    weatherHourly.setTime(jsonObject.getString("time"));
                    weatherHourly.setWind360(jsonObject.getString("wind360"));
                    weatherHourly.setWindDir(jsonObject.getString("windDir"));
                    weatherHourly.setWindScale(jsonObject.getString("windScale"));
                    weatherHourly.setWindSpeed(jsonObject.getString("windSpeed"));
                    weatherHourlyList.add(weatherHourly);
                }
                weatherHistory.setWeatherHourly(weatherHourlyList);
                heWeatherResponse.setWeatherHistory(weatherHistory);
            }else if(response.containsKey("airHourly")){
                WeatherHistory weatherHistory = new WeatherHistory();
                JSONArray airHourlies = response.getJSONArray("airHourly");
                List<AirHourly> airHourlyList= new ArrayList<AirHourly>();
                List<JSONObject> list = JSONObject.parseArray(airHourlies.toJSONString(), JSONObject.class);

                for(JSONObject jsonObject : list){
                    AirHourly airHourly = new AirHourly();
                    airHourly.setAqi(jsonObject.getString("aqi"));
                    airHourly.setCategory(jsonObject.getString("category"));
                    airHourly.setCo(jsonObject.getString("co"));
                    airHourly.setLevel(jsonObject.getString("level"));
                    airHourly.setNo2(jsonObject.getString("no2"));
                    airHourly.setO3(jsonObject.getString("o3"));
                    airHourly.setPm2p5(jsonObject.getString("pm2p5"));
                    airHourly.setPm10(jsonObject.getString("pm10"));
                    airHourly.setPrimary(jsonObject.getString("primary"));
                    airHourly.setPubTime(jsonObject.getString("pubTime"));
                    airHourly.setSo2(jsonObject.getString("so2"));
                    airHourlyList.add(airHourly);
                }
                Refer refer = new Refer();
                JSONObject refer1 = response.getJSONObject("refer");
                JSONArray sources = refer1.getJSONArray("sources");
                List<String> sourcesList = JSONObject.parseArray(sources.toJSONString(), String.class);
                JSONArray license = refer1.getJSONArray("license");
                List<String> licenseList = JSONObject.parseArray(license.toJSONString(), String.class);
                refer.setLicense(sourcesList);
                refer.setSources(licenseList);
                weatherHistory.setAirHourly(airHourlyList);
                weatherHistory.setRefer(refer);
                heWeatherResponse.setWeatherHistory(weatherHistory);
            }
        } catch (Exception e) {
            e.printStackTrace();
            heWeatherResponse.setStatus("400");
        }
        return heWeatherResponse;
    }
}
