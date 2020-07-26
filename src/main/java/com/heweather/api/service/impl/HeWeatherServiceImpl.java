package com.heweather.api.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.heweather.api.dto.request.HeWeatherRequest;
import com.heweather.api.dto.response.HeWeatherResponse;
import com.heweather.api.dto.response.LocationInfo;
import com.heweather.api.service.HeWertherService;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.util.ArrayList;
import java.util.List;

public class HeWeatherServiceImpl implements HeWertherService {

    public HeWeatherResponse getLocationInfo(HeWeatherRequest heWeatherRequest) {
        HeWeatherResponse heWeatherResponse =  new HeWeatherResponse();
        String location="";
        String key = "";
        String adm = "";
        String range="";
        Integer number = 0;
        String gzip = "";
        String lang = "";
        String url = "https://geoapi.heweather.net/v2/city/lookup?"+"location"+location+"&key"+key;
        //必传参数校验
        if(heWeatherRequest.getLocation()==null && !heWeatherRequest.getLocation().equals("")){
            location =  heWeatherRequest.getLocation();
            url = url+"location"+location;
        }else{
            heWeatherResponse.setStatus("1001");
            return heWeatherResponse;
        }
        if(heWeatherRequest.getKey() == null && heWeatherRequest.getKey().equals("")){
            key = heWeatherRequest.getKey();
            url = url+"&key"+key;
        }else{
            heWeatherResponse.setStatus("1001");
            return heWeatherResponse;
        }
        //非必传参数拼接
        if(heWeatherRequest.getAdm() == null && heWeatherRequest.getAdm().equals("")){
            adm = heWeatherRequest.getKey();
            url = url+"&adm"+adm;
        }
        if(heWeatherRequest.getRange() == null && heWeatherRequest.getRange().equals("")){
            range = heWeatherRequest.getRange();
            url = url+"&range"+range;
        }
        if(heWeatherRequest.getNumber() == null){
            number = heWeatherRequest.getNumber();
            url = url+"&number"+number;
        }
        if(heWeatherRequest.getGzip() == null && heWeatherRequest.getGzip().equals("")){
            gzip = heWeatherRequest.getGzip();
            url = url+"&gzip"+gzip;
        }
        if(heWeatherRequest.getLang() == null && heWeatherRequest.getLang().equals("")){
            lang = heWeatherRequest.getGzip();
            url = url+"&lang"+lang;
        }
        try{
            String json = "";
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            json = httpResponse.getEntity().toString();
            JSONObject response = (JSONObject) JSONObject.parse(json);
            JSONArray locationList = response.getJSONArray("location");
            List<JSONObject> list = JSONObject.parseArray(locationList.toJSONString(), JSONObject.class);
            if(response.get("code").equals("200")){
                heWeatherResponse.setStatus("200");
                List<LocationInfo> locationInfoList = new ArrayList<LocationInfo>();
                for (JSONObject jsonObject : list){
                    LocationInfo locationInfo =  new LocationInfo();
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

        }catch (Exception e){
            e.printStackTrace();
            heWeatherResponse.setStatus("400");
        }
        return heWeatherResponse;
    }

    public HeWeatherResponse getTopLocationInfo(HeWeatherRequest heWeatherRequest) {
        HeWeatherResponse heWeatherResponse =  new HeWeatherResponse();
        String key = "";
       // String adm = "";
        String range="";
        Integer number = 0;
        String gzip = "";
        String lang = "";
        //String url = "https://geoapi.heweather.net/v2/city/ltop?"+"location"+location+"&key"+key;
        String url = "https://geoapi.heweather.net/v2/city/top?"+"key"+key;
        //必传参数校验
//        if(heWeatherRequest.getLocation()==null && !heWeatherRequest.getLocation().equals("")){
//            location =  heWeatherRequest.getLocation();
//            url = url+"location"+location;
//        }else{
//            heWeatherResponse.setStatus("1001");
//            return heWeatherResponse;
//        }
        if(heWeatherRequest.getKey() == null && heWeatherRequest.getKey().equals("")){
            key = heWeatherRequest.getKey();
            url = url+"&key"+key;
        }else{
            heWeatherResponse.setStatus("1001");
            return heWeatherResponse;
        }
//        //非必传参数拼接
//        if(heWeatherRequest.getAdm() == null && heWeatherRequest.getAdm().equals("")){
//            adm = heWeatherRequest.getKey();
//            url = url+"&adm"+adm;
//        }
        if(heWeatherRequest.getRange() == null && heWeatherRequest.getRange().equals("")){
            range = heWeatherRequest.getRange();
            url = url+"&range"+range;
        }
        if(heWeatherRequest.getNumber() == null){
            number = heWeatherRequest.getNumber();
            url = url+"&number"+number;
        }
        if(heWeatherRequest.getGzip() == null && heWeatherRequest.getGzip().equals("")){
            gzip = heWeatherRequest.getGzip();
            url = url+"&gzip"+gzip;
        }
        if(heWeatherRequest.getLang() == null && heWeatherRequest.getLang().equals("")){
            lang = heWeatherRequest.getGzip();
            url = url+"&lang"+lang;
        }
        try{
            String json = "";
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            json = httpResponse.getEntity().toString();
            JSONObject response = (JSONObject) JSONObject.parse(json);
            JSONArray locationList = response.getJSONArray("location");
            List<JSONObject> list = JSONObject.parseArray(locationList.toJSONString(), JSONObject.class);
            if(httpResponse.getStatusLine().getStatusCode()==200){
                heWeatherResponse.setStatus("200");
                List<LocationInfo> locationInfoList = new ArrayList<LocationInfo>();
                for (JSONObject jsonObject : list){
                    LocationInfo locationInfo =  new LocationInfo();
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

        }catch (Exception e){
            e.printStackTrace();
            heWeatherResponse.setStatus("400");
        }
        return heWeatherResponse;
    }

    public HeWeatherResponse getLookupPoiLocationInfo(HeWeatherRequest heWeatherRequest) {
        return null;
    }

    public HeWeatherResponse getRangePoiLocationInfo(HeWeatherRequest heWeatherRequest) {
        return null;
    }

    public HeWeatherResponse getNowWeatherInfo(HeWeatherRequest heWeatherRequest) {
        return null;
    }

    public HeWeatherResponse getThreeDayWeatherInfo(HeWeatherRequest heWeatherRequest) {
        return null;
    }

    public HeWeatherResponse getSevenDayWeatherInfo(HeWeatherRequest heWeatherRequest) {
        return null;
    }

    public HeWeatherResponse getTenDayWeatherInfo(HeWeatherRequest heWeatherRequest) {
        return null;
    }

    public HeWeatherResponse getFifteenDayWeatherInfo(HeWeatherRequest heWeatherRequest) {
        return null;
    }

    public HeWeatherResponse getTwentyFourHoursWeatherInfo(HeWeatherRequest heWeatherRequest) {
        return null;
    }

    public HeWeatherResponse getSeventyTwoHoursWeatherInfo(HeWeatherRequest heWeatherRequest) {
        return null;
    }

    public HeWeatherResponse getOneSixtyEightWeatherInfo(HeWeatherRequest heWeatherRequest) {
        return null;
    }
}
