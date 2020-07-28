package com.heweather.api.service.impl;

import com.heweather.api.dto.ApiEnum;
import com.heweather.api.dto.response.HeWeatherResponse;
import com.heweather.api.service.HeWertherInfoService;

public class HeWeatherServiceImpl implements HeWertherInfoService {

    public HeWeatherResponse getWeatherInfo(String location, String key, String lang, String unit, String time) {
        HeWeatherResponse heWeatherResponse = new HeWeatherResponse();
        String url = "https://api.heweather.net/v7/weather";
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
        if (unit != null && !unit.equals("")) {
            url = url + "&unit" + unit;
        } else {
            heWeatherResponse.setStatus("400");
            return heWeatherResponse;
        }
        return null;
    }

    public HeWeatherResponse getWeatherInfo(String location, String key, ApiEnum apiEnum) {
        return null;
    }

    public HeWeatherResponse getWeatherInfo(String location, String key, String lang, String unit, ApiEnum apiEnum) {
        return null;
    }
}
