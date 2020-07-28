package com.heweather.api.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.heweather.api.dto.response.DisasterWarning;
import com.heweather.api.dto.response.DisasterWarningCityList;
import com.heweather.api.dto.response.HeWeatherResponse;
import com.heweather.api.dto.response.airQualit.Station;
import com.heweather.api.dto.response.warning.Warning;
import com.heweather.api.dto.response.warning.WarningLoc;
import com.heweather.api.dto.response.weatherInfo.Refer;
import com.heweather.api.service.HeWeatherWarningSrevice;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.util.ArrayList;
import java.util.List;

public class HeWeatherWarningSreviceImpl implements HeWeatherWarningSrevice {

    public HeWeatherResponse getWeatherWarning(String location, String key, String lang) {

        HeWeatherResponse heWeatherResponse = new HeWeatherResponse();
        String url = "https://api.heweather.net/v7/warning/now?";
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
                DisasterWarning disasterWarning = new DisasterWarning();
                JSONArray warnings = response.getJSONArray("warning");
                List<Warning> warningList = new ArrayList<Warning>();
                List<JSONObject> list = JSONObject.parseArray(warnings.toJSONString(), JSONObject.class);
                for (JSONObject jsonObject : list) {
                    Warning warning = new Warning();
                    warning.setEndTime(jsonObject.getString("endTime"));
                    warning.setId(jsonObject.getString("id"));
                    warning.setLevel(jsonObject.getString("level"));
                    warning.setPubTime(jsonObject.getString("pubTime"));
                    warning.setRelated(jsonObject.getString("related"));
                    warning.setSender(jsonObject.getString("sender"));
                    warning.setStartTime(jsonObject.getString("startTime"));
                    warning.setStatus(jsonObject.getString("status"));
                    warning.setText(jsonObject.getString("text"));
                    warning.setTitle(jsonObject.getString("title"));
                    warning.setType(jsonObject.getString("type"));
                    warning.setTypeName(jsonObject.getString("typeName"));
                    warningList.add(warning);
                }
                Refer refer = new Refer();
                JSONObject refer1 = response.getJSONObject("refer");
                JSONArray sources = refer1.getJSONArray("sources");
                List<String> sourcesList = JSONObject.parseArray(sources.toJSONString(), String.class);
                JSONArray license = refer1.getJSONArray("license");
                List<String> licenseList = JSONObject.parseArray(license.toJSONString(), String.class);
                refer.setLicense(sourcesList);
                refer.setSources(licenseList);
                disasterWarning.setWarning(warningList);
                disasterWarning.setRefer(refer);
                heWeatherResponse.setDisasterWarning(disasterWarning);
            }
        } catch (Exception e) {
            e.printStackTrace();
            heWeatherResponse.setStatus("400");
        }
        return heWeatherResponse;
    }

    public HeWeatherResponse getWeatherWarning(String location, String key) {

        HeWeatherResponse heWeatherResponse = new HeWeatherResponse();
        String url = "https://api.heweather.net/v7/warning/now?";
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
                heWeatherResponse.setUpdateTime(response.getString("updateTime"));
                heWeatherResponse.setFxLink(response.getString("fxLink"));
                DisasterWarning disasterWarning = new DisasterWarning();
                JSONArray warnings = response.getJSONArray("warning");
                List<Warning> warningList = new ArrayList<Warning>();
                List<JSONObject> list = JSONObject.parseArray(warnings.toJSONString(), JSONObject.class);
                for (JSONObject jsonObject : list) {
                    Warning warning = new Warning();
                    warning.setEndTime(jsonObject.getString("endTime"));
                    warning.setId(jsonObject.getString("id"));
                    warning.setLevel(jsonObject.getString("level"));
                    warning.setPubTime(jsonObject.getString("pubTime"));
                    warning.setRelated(jsonObject.getString("related"));
                    warning.setSender(jsonObject.getString("sender"));
                    warning.setStartTime(jsonObject.getString("startTime"));
                    warning.setStatus(jsonObject.getString("status"));
                    warning.setText(jsonObject.getString("text"));
                    warning.setTitle(jsonObject.getString("title"));
                    warning.setType(jsonObject.getString("type"));
                    warning.setTypeName(jsonObject.getString("typeName"));
                    warningList.add(warning);
                }
                Refer refer = new Refer();
                JSONObject refer1 = response.getJSONObject("refer");
                JSONArray sources = refer1.getJSONArray("sources");
                List<String> sourcesList = JSONObject.parseArray(sources.toJSONString(), String.class);
                JSONArray license = refer1.getJSONArray("license");
                List<String> licenseList = JSONObject.parseArray(license.toJSONString(), String.class);
                refer.setLicense(sourcesList);
                refer.setSources(licenseList);
                disasterWarning.setWarning(warningList);
                disasterWarning.setRefer(refer);
                heWeatherResponse.setDisasterWarning(disasterWarning);
            }
        } catch (Exception e) {
            e.printStackTrace();
            heWeatherResponse.setStatus("400");
        }
        return heWeatherResponse;
    }

    public HeWeatherResponse getWarningLocList(String range, String key) {

        HeWeatherResponse heWeatherResponse = new HeWeatherResponse();
        String url = "https://api.heweather.net/v7/warning/list?";
        if (range != null && !range.equals("")) {
            url = url + "range" + range;
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
                DisasterWarningCityList disasterWarningCityList = new DisasterWarningCityList();
                List<WarningLoc> warningLocList = new ArrayList<WarningLoc>();
                JSONArray warningLoces = response.getJSONArray("warningLocList");
                List<JSONObject> list = JSONObject.parseArray(warningLoces.toJSONString(), JSONObject.class);
                for (JSONObject jsonObject : list) {
                    WarningLoc warningLoc = new WarningLoc();
                    warningLoc.setLocationId(jsonObject.getString("locationId"));
                    warningLocList.add(warningLoc);
                }
                Refer refer = new Refer();
                JSONObject refer1 = response.getJSONObject("refer");
                JSONArray sources = refer1.getJSONArray("sources");
                List<String> sourcesList = JSONObject.parseArray(sources.toJSONString(), String.class);
                JSONArray license = refer1.getJSONArray("license");
                List<String> licenseList = JSONObject.parseArray(license.toJSONString(), String.class);
                refer.setLicense(sourcesList);
                refer.setSources(licenseList);
                disasterWarningCityList.setRefer(refer);
                disasterWarningCityList.setWarningLocList(warningLocList);
                heWeatherResponse.setDisasterWarningCityList(disasterWarningCityList);
            }
        } catch (Exception e) {
            e.printStackTrace();
            heWeatherResponse.setStatus("400");
        }
        return heWeatherResponse;
    }
}
