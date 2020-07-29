package com.heweather.api.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.heweather.api.InitializeSign;
import com.heweather.api.dto.response.HeWeatherResponse;
import com.heweather.api.dto.response.LocationInfo;
import com.heweather.api.dto.response.PoiInfo;
import com.heweather.api.service.HeWeatherLocationService;
import com.heweather.utils.SignUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 城市信息搜索请求处理
 * add by djc
 */

public class HeWeatherLocationServiceImpl implements HeWeatherLocationService {

    @Override
    public HeWeatherResponse getLocation(String location) {

        HeWeatherResponse heWeatherResponse = new HeWeatherResponse();
        String URL = "https://geoapi.heweather.net/v2/city/lookup?";
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
            JSONArray locationList = response.getJSONArray("location");
            List<JSONObject> list = JSONObject.parseArray(locationList.toJSONString(), JSONObject.class);
            if (response.get("code").equals("200")) {
                heWeatherResponse.setStatus("200");
                List<LocationInfo> locationInfoList = new ArrayList<LocationInfo>();
                for (JSONObject jsonObject : list) {
                    LocationInfo locationInfo = new LocationInfo();
                    locationInfo.setName(jsonObject.getString("name"));
                    locationInfo.setId(jsonObject.getString("id"));
                    locationInfo.setLat(jsonObject.getString("lat"));
                    locationInfo.setLon(jsonObject.getString("lon"));
                    locationInfo.setAdm1(jsonObject.getString("adm1"));
                    locationInfo.setAdm2(jsonObject.getString("adm2"));
                    locationInfo.setCounty(jsonObject.getString("country"));
                    locationInfo.setUtcOffset(jsonObject.getString("utcOffset"));
                    locationInfo.setTz(jsonObject.getString("tz"));
                    locationInfo.setType(jsonObject.getString("type"));
                    locationInfo.setIsDst(jsonObject.getString("isDst"));
                    locationInfo.setRank(jsonObject.getString("rank"));
                    locationInfo.setFxLink(jsonObject.getString("fxLink"));
                    locationInfoList.add(locationInfo);
                }
                heWeatherResponse.setTopCityList(locationInfoList);
            }

        } catch (Exception e) {
            e.printStackTrace();
            heWeatherResponse.setStatus("400");
        }
        return heWeatherResponse;
    }

    @Override
    public HeWeatherResponse getLocation(String location, String adm, String range, Integer number, String lang) {

        HeWeatherResponse heWeatherResponse = new HeWeatherResponse();
        String URL = "https://geoapi.heweather.net/v2/city/lookup?";
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
        if (adm != null && !adm.equals("")) {
            URL = URL + "&adm" + adm;
            params.put("adm", adm);
        } else {
            heWeatherResponse.setStatus("400");
            return heWeatherResponse;
        }
        if (range != null && !range.equals("")) {
            URL = URL + "&range" + range;
            params.put("range", range);
        } else {
            heWeatherResponse.setStatus("400");
            return heWeatherResponse;
        }
        if (number != null && !number.equals("")) {
            URL = URL + "&number" + number;
            params.put("number", String.valueOf(number));
        } else {
            heWeatherResponse.setStatus("400");
            return heWeatherResponse;
        }
        if (lang != null && !lang.equals("")) {
            URL = URL + "&lang" + lang;
            params.put("location", location);
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
            JSONArray locationList = response.getJSONArray("location");
            List<JSONObject> list = JSONObject.parseArray(locationList.toJSONString(), JSONObject.class);
            if (response.get("code").equals("200")) {
                heWeatherResponse.setStatus("200");
                List<LocationInfo> locationInfoList = new ArrayList<LocationInfo>();
                for (JSONObject jsonObject : list) {
                    LocationInfo locationInfo = new LocationInfo();
                    locationInfo.setName(jsonObject.getString("name"));
                    locationInfo.setId(jsonObject.getString("id"));
                    locationInfo.setLat(jsonObject.getString("lat"));
                    locationInfo.setLon(jsonObject.getString("lon"));
                    locationInfo.setAdm1(jsonObject.getString("adm1"));
                    locationInfo.setAdm2(jsonObject.getString("adm2"));
                    locationInfo.setCounty(jsonObject.getString("country"));
                    locationInfo.setUtcOffset(jsonObject.getString("utcOffset"));
                    locationInfo.setTz(jsonObject.getString("tz"));
                    locationInfo.setType(jsonObject.getString("type"));
                    locationInfo.setIsDst(jsonObject.getString("isDst"));
                    locationInfo.setRank(jsonObject.getString("rank"));
                    locationInfo.setFxLink(jsonObject.getString("fxLink"));
                    locationInfoList.add(locationInfo);
                }
                heWeatherResponse.setTopCityList(locationInfoList);
            }

        } catch (Exception e) {
            e.printStackTrace();
            heWeatherResponse.setStatus("400");
        }
        return heWeatherResponse;
    }

    @Override
    public HeWeatherResponse getLocation(String location,String adm, String range) {

        HeWeatherResponse heWeatherResponse = new HeWeatherResponse();
        String URL = "https://geoapi.heweather.net/v2/city/lookup?";
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
        if (adm != null && !adm.equals("")) {
            URL = URL + "&adm" + adm;
            params.put("adm", adm);
        } else {
            heWeatherResponse.setStatus("400");
            return heWeatherResponse;
        }
        if (range != null && !range.equals("")) {
            URL = URL + "&range" + range;
            params.put("range", range);
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
            JSONArray locationList = response.getJSONArray("location");
            List<JSONObject> list = JSONObject.parseArray(locationList.toJSONString(), JSONObject.class);
            if (response.get("code").equals("200")) {
                heWeatherResponse.setStatus("200");
                List<LocationInfo> locationInfoList = new ArrayList<LocationInfo>();
                for (JSONObject jsonObject : list) {
                    LocationInfo locationInfo = new LocationInfo();
                    locationInfo.setName(jsonObject.getString("name"));
                    locationInfo.setId(jsonObject.getString("id"));
                    locationInfo.setLat(jsonObject.getString("lat"));
                    locationInfo.setLon(jsonObject.getString("lon"));
                    locationInfo.setAdm1(jsonObject.getString("adm1"));
                    locationInfo.setAdm2(jsonObject.getString("adm2"));
                    locationInfo.setCounty(jsonObject.getString("country"));
                    locationInfo.setUtcOffset(jsonObject.getString("utcOffset"));
                    locationInfo.setTz(jsonObject.getString("tz"));
                    locationInfo.setType(jsonObject.getString("type"));
                    locationInfo.setIsDst(jsonObject.getString("isDst"));
                    locationInfo.setRank(jsonObject.getString("rank"));
                    locationInfo.setFxLink(jsonObject.getString("fxLink"));
                    locationInfoList.add(locationInfo);
                }
                heWeatherResponse.setTopCityList(locationInfoList);
            }

        } catch (Exception e) {
            e.printStackTrace();
            heWeatherResponse.setStatus("400");
        }
        return heWeatherResponse;
    }

    @Override
    public HeWeatherResponse getTopLocation() {

        HeWeatherResponse heWeatherResponse = new HeWeatherResponse();
        String URL = "https://geoapi.heweather.net/v2/city/top?";
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
        HashMap<String, String> params = new HashMap<>();
        if (key != null && !key.equals("")) {
            URL = URL + "username" + key;
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
            String json = "";
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(URL);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            json = httpResponse.getEntity().toString();
            JSONObject response = (JSONObject) JSONObject.parse(json);
            JSONArray locationList = response.getJSONArray("topCityList");
            List<JSONObject> list = JSONObject.parseArray(locationList.toJSONString(), JSONObject.class);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                heWeatherResponse.setStatus("200");
                List<LocationInfo> locationInfoList = new ArrayList<LocationInfo>();
                for (JSONObject jsonObject : list) {
                    LocationInfo locationInfo = new LocationInfo();
                    locationInfo.setName(jsonObject.getString("name"));
                    locationInfo.setId(jsonObject.getString("id"));
                    locationInfo.setLat(jsonObject.getString("lat"));
                    locationInfo.setLon(jsonObject.getString("lon"));
                    locationInfo.setAdm1(jsonObject.getString("adm1"));
                    locationInfo.setAdm2(jsonObject.getString("adm2"));
                    locationInfo.setCounty(jsonObject.getString("country"));
                    locationInfo.setUtcOffset(jsonObject.getString("utcOffset"));
                    locationInfo.setTz(jsonObject.getString("tz"));
                    locationInfo.setType(jsonObject.getString("type"));
                    locationInfo.setIsDst(jsonObject.getString("isDst"));
                    locationInfo.setRank(jsonObject.getString("rank"));
                    locationInfo.setFxLink(jsonObject.getString("fxLink"));
                    locationInfoList.add(locationInfo);
                }
                heWeatherResponse.setLocation(locationInfoList);
            }

        } catch (Exception e) {
            e.printStackTrace();
            heWeatherResponse.setStatus("400");
        }
        return heWeatherResponse;
    }

    @Override
    public HeWeatherResponse getTopLocation(String range, Integer number, String lang) {

        HeWeatherResponse heWeatherResponse = new HeWeatherResponse();
        String URL = "https://geoapi.heweather.net/v2/city/top?";
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
        if (key != null && !key.equals("")) {
            URL = URL + "username" + key;
            params.put("username", key);
        } else {
            heWeatherResponse.setStatus("400");
            return heWeatherResponse;
        }
        if (range != null && !range.equals("")) {
            URL = URL + "&range" + range;
            params.put("range", range);
        } else {
            heWeatherResponse.setStatus("400");
            return heWeatherResponse;
        }
        if (number != null && !number.equals("")) {
            URL = URL + "&number" + number;
            params.put("number", String.valueOf(number));
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
            String json = "";
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(URL);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            json = httpResponse.getEntity().toString();
            JSONObject response = (JSONObject) JSONObject.parse(json);
            JSONArray locationList = response.getJSONArray("topCityList");
            List<JSONObject> list = JSONObject.parseArray(locationList.toJSONString(), JSONObject.class);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                heWeatherResponse.setStatus("200");
                List<LocationInfo> locationInfoList = new ArrayList<LocationInfo>();
                for (JSONObject jsonObject : list) {
                    LocationInfo locationInfo = new LocationInfo();
                    locationInfo.setName(jsonObject.getString("name"));
                    locationInfo.setId(jsonObject.getString("id"));
                    locationInfo.setLat(jsonObject.getString("lat"));
                    locationInfo.setLon(jsonObject.getString("lon"));
                    locationInfo.setAdm1(jsonObject.getString("adm1"));
                    locationInfo.setAdm2(jsonObject.getString("adm2"));
                    locationInfo.setCounty(jsonObject.getString("country"));
                    locationInfo.setUtcOffset(jsonObject.getString("utcOffset"));
                    locationInfo.setTz(jsonObject.getString("tz"));
                    locationInfo.setType(jsonObject.getString("type"));
                    locationInfo.setIsDst(jsonObject.getString("isDst"));
                    locationInfo.setRank(jsonObject.getString("rank"));
                    locationInfo.setFxLink(jsonObject.getString("fxLink"));
                    locationInfoList.add(locationInfo);
                }
                heWeatherResponse.setLocation(locationInfoList);
            }

        } catch (Exception e) {
            e.printStackTrace();
            heWeatherResponse.setStatus("400");
        }
        return heWeatherResponse;
    }

    @Override
    public HeWeatherResponse getTopLocation(String adm, String range, String lang) {

        HeWeatherResponse heWeatherResponse = new HeWeatherResponse();
        String URL = "https://geoapi.heweather.net/v2/city/top?";
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
        if (key != null && !key.equals("")) {
            URL = URL + "username" + key;
            params.put("username", key);
        } else {
            heWeatherResponse.setStatus("400");
            return heWeatherResponse;
        }

        if (adm != null && !adm.equals("")) {
            URL = URL + "&adm" + adm;
            params.put("adm", adm);
        } else {
            heWeatherResponse.setStatus("400");
            return heWeatherResponse;
        }

        if (range != null && !range.equals("")) {
            URL = URL + "&range" + range;
            params.put("range", range);
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
            String json = "";
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(URL);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            json = httpResponse.getEntity().toString();
            JSONObject response = (JSONObject) JSONObject.parse(json);
            JSONArray locationList = response.getJSONArray("topCityList");
            List<JSONObject> list = JSONObject.parseArray(locationList.toJSONString(), JSONObject.class);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                heWeatherResponse.setStatus("200");
                List<LocationInfo> locationInfoList = new ArrayList<LocationInfo>();
                for (JSONObject jsonObject : list) {
                    LocationInfo locationInfo = new LocationInfo();
                    locationInfo.setName(jsonObject.getString("name"));
                    locationInfo.setId(jsonObject.getString("id"));
                    locationInfo.setLat(jsonObject.getString("lat"));
                    locationInfo.setLon(jsonObject.getString("lon"));
                    locationInfo.setAdm1(jsonObject.getString("adm1"));
                    locationInfo.setAdm2(jsonObject.getString("adm2"));
                    locationInfo.setCounty(jsonObject.getString("country"));
                    locationInfo.setUtcOffset(jsonObject.getString("utcOffset"));
                    locationInfo.setTz(jsonObject.getString("tz"));
                    locationInfo.setType(jsonObject.getString("type"));
                    locationInfo.setIsDst(jsonObject.getString("isDst"));
                    locationInfo.setRank(jsonObject.getString("rank"));
                    locationInfo.setFxLink(jsonObject.getString("fxLink"));
                    locationInfoList.add(locationInfo);
                }
                heWeatherResponse.setLocation(locationInfoList);
            }

        } catch (Exception e) {
            e.printStackTrace();
            heWeatherResponse.setStatus("400");
        }
        return heWeatherResponse;
    }

    @Override
    public HeWeatherResponse getLookupPoiLocation(String location, String type) {

        HeWeatherResponse heWeatherResponse = new HeWeatherResponse();
        String URL = "https://geoapi.heweather.net/v2/poi/lookup?";
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
        if (location != null && !location.equals("")) {
            URL = URL + "location" + location;
            params.put("location", location);
        } else {
            heWeatherResponse.setStatus("400");
            return heWeatherResponse;
        }
        if (key != null && !key.equals("")) {
            URL = URL + "&key" + key;
            params.put("username", key);
        } else {
            heWeatherResponse.setStatus("400");
            return heWeatherResponse;
        }
        if (type != null && !type.equals("")) {
            URL = URL + "&type" + type;
            params.put("type", type);
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
            JSONArray locationList = response.getJSONArray("location");
            List<JSONObject> list = JSONObject.parseArray(locationList.toJSONString(), JSONObject.class);
            if (response.get("code").equals("200")) {
                heWeatherResponse.setStatus("200");
                List<PoiInfo> poiInfoList = new ArrayList<PoiInfo>();
                for (JSONObject jsonObject : list) {
                    PoiInfo poiInfo = new PoiInfo();
                    poiInfo.setName(jsonObject.getString("name"));
                    poiInfo.setId(jsonObject.getString("id"));
                    poiInfo.setLat(jsonObject.getString("lat"));
                    poiInfo.setLon(jsonObject.getString("lon"));
                    poiInfo.setAdm1(jsonObject.getString("adm1"));
                    poiInfo.setAdm2(jsonObject.getString("adm2"));
                    poiInfo.setCounty(jsonObject.getString("country"));
                    poiInfo.setUtcOffset(jsonObject.getString("utcOffset"));
                    poiInfo.setTz(jsonObject.getString("tz"));
                    poiInfo.setType(jsonObject.getString("type"));
                    poiInfo.setIsDst(jsonObject.getString("isDst"));
                    poiInfo.setRank(jsonObject.getString("rank"));
                    poiInfoList.add(poiInfo);
                }
                heWeatherResponse.setPoi(poiInfoList);
            }

        } catch (Exception e) {
            e.printStackTrace();
            heWeatherResponse.setStatus("400");
        }
        return heWeatherResponse;
    }

    @Override
    public HeWeatherResponse getLookupPoiLocation(String location, String type, String city, Integer number, String lang) {

        HeWeatherResponse heWeatherResponse = new HeWeatherResponse();
        String URL = "https://geoapi.heweather.net/v2/poi/lookup?";
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
        if (location != null && !location.equals("")) {
            URL = URL + "location" + location;
            params.put("location", location);
        } else {
            heWeatherResponse.setStatus("400");
            return heWeatherResponse;
        }
        if (key != null && !key.equals("")) {
            URL = URL + "&key" + key;
            params.put("username", key);
        } else {
            heWeatherResponse.setStatus("400");
            return heWeatherResponse;
        }
        if (type != null && !type.equals("")) {
            URL = URL + "&type" + type;
            params.put("type", type);
        } else {
            heWeatherResponse.setStatus("400");
            return heWeatherResponse;
        }
        if (city != null && !city.equals("")) {
            URL = URL + "&city" + city;
            params.put("city", city);
        } else {
            heWeatherResponse.setStatus("400");
            return heWeatherResponse;
        }
        if (number != null && !number.equals("")) {
            URL = URL + "&number" + number;
            params.put("location", String.valueOf(number));
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
            JSONArray locationList = response.getJSONArray("location");
            List<JSONObject> list = JSONObject.parseArray(locationList.toJSONString(), JSONObject.class);
            if (response.get("code").equals("200")) {
                heWeatherResponse.setStatus("200");
                List<PoiInfo> poiInfoList = new ArrayList<PoiInfo>();
                for (JSONObject jsonObject : list) {
                    PoiInfo poiInfo = new PoiInfo();
                    poiInfo.setName(jsonObject.getString("name"));
                    poiInfo.setId(jsonObject.getString("id"));
                    poiInfo.setLat(jsonObject.getString("lat"));
                    poiInfo.setLon(jsonObject.getString("lon"));
                    poiInfo.setAdm1(jsonObject.getString("adm1"));
                    poiInfo.setAdm2(jsonObject.getString("adm2"));
                    poiInfo.setCounty(jsonObject.getString("country"));
                    poiInfo.setUtcOffset(jsonObject.getString("utcOffset"));
                    poiInfo.setTz(jsonObject.getString("tz"));
                    poiInfo.setType(jsonObject.getString("type"));
                    poiInfo.setIsDst(jsonObject.getString("isDst"));
                    poiInfo.setRank(jsonObject.getString("rank"));
                    poiInfoList.add(poiInfo);
                }
                heWeatherResponse.setPoi(poiInfoList);
            }

        } catch (Exception e) {
            e.printStackTrace();
            heWeatherResponse.setStatus("400");
        }
        return heWeatherResponse;
    }

    @Override
    public HeWeatherResponse getRangePoiLocation(String location, String type) {

        HeWeatherResponse heWeatherResponse = new HeWeatherResponse();
        String URL = "https://geoapi.heweather.net/v2/poi/range?";
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
        if (type != null && !type.equals("")) {
            URL = URL + "&type" + type;
            params.put("type", type);
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
            JSONArray locationList = response.getJSONArray("location");
            List<JSONObject> list = JSONObject.parseArray(locationList.toJSONString(), JSONObject.class);
            if (response.get("code").equals("200")) {
                heWeatherResponse.setStatus("200");
                List<PoiInfo> poiInfoList = new ArrayList<PoiInfo>();
                for (JSONObject jsonObject : list) {
                    PoiInfo poiInfo = new PoiInfo();
                    poiInfo.setName(jsonObject.getString("name"));
                    poiInfo.setId(jsonObject.getString("id"));
                    poiInfo.setLat(jsonObject.getString("lat"));
                    poiInfo.setLon(jsonObject.getString("lon"));
                    poiInfo.setAdm1(jsonObject.getString("adm1"));
                    poiInfo.setAdm2(jsonObject.getString("adm2"));
                    poiInfo.setCounty(jsonObject.getString("country"));
                    poiInfo.setUtcOffset(jsonObject.getString("utcOffset"));
                    poiInfo.setTz(jsonObject.getString("tz"));
                    poiInfo.setType(jsonObject.getString("type"));
                    poiInfo.setIsDst(jsonObject.getString("isDst"));
                    poiInfo.setRank(jsonObject.getString("rank"));
                    poiInfoList.add(poiInfo);
                }
                heWeatherResponse.setPoi(poiInfoList);
            }

        } catch (Exception e) {
            e.printStackTrace();
            heWeatherResponse.setStatus("400");
        }
        return heWeatherResponse;

    }

    @Override
    public HeWeatherResponse getRangePoiLocation(String location, String type, Integer radius, Integer number, String lang) {

        HeWeatherResponse heWeatherResponse = new HeWeatherResponse();
        String URL = "https://geoapi.heweather.net/v2/poi/range?";
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
        if (type != null && !type.equals("")) {
            URL = URL + "&type" + type;
            params.put("type", type);
        } else {
            heWeatherResponse.setStatus("400");
            return heWeatherResponse;
        }
        if (number != null && !number.equals("")) {
            URL = URL + "&number" + number;
            params.put("number", String.valueOf(number));
        } else {
            heWeatherResponse.setStatus("400");
            return heWeatherResponse;
        }
        if (radius != null && !radius.equals("")) {
            URL = URL + "&radius" + radius;
            params.put("radius", String.valueOf(radius));
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
            JSONArray locationList = response.getJSONArray("location");
            List<JSONObject> list = JSONObject.parseArray(locationList.toJSONString(), JSONObject.class);
            if (response.get("code").equals("200")) {
                heWeatherResponse.setStatus("200");
                List<PoiInfo> poiInfoList = new ArrayList<PoiInfo>();
                for (JSONObject jsonObject : list) {
                    PoiInfo poiInfo = new PoiInfo();
                    poiInfo.setName(jsonObject.getString("name"));
                    poiInfo.setId(jsonObject.getString("id"));
                    poiInfo.setLat(jsonObject.getString("lat"));
                    poiInfo.setLon(jsonObject.getString("lon"));
                    poiInfo.setAdm1(jsonObject.getString("adm1"));
                    poiInfo.setAdm2(jsonObject.getString("adm2"));
                    poiInfo.setCounty(jsonObject.getString("country"));
                    poiInfo.setUtcOffset(jsonObject.getString("utcOffset"));
                    poiInfo.setTz(jsonObject.getString("tz"));
                    poiInfo.setType(jsonObject.getString("type"));
                    poiInfo.setIsDst(jsonObject.getString("isDst"));
                    poiInfo.setRank(jsonObject.getString("rank"));
                    poiInfoList.add(poiInfo);
                }
                heWeatherResponse.setPoi(poiInfoList);
            }

        } catch (Exception e) {
            e.printStackTrace();
            heWeatherResponse.setStatus("400");
        }
        return heWeatherResponse;
    }
}
