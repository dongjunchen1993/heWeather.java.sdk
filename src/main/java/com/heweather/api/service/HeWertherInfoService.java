package com.heweather.api.service;

import com.heweather.api.dto.ENUM_WHEATHER_TIME;
import com.heweather.api.dto.request.HeWeatherRequest;
import com.heweather.api.dto.response.HeWeatherResponse;

public interface HeWertherInfoService {

    //天气预报和实况 实时
    HeWeatherResponse getWeatherInfo(String location, String key,ENUM_WHEATHER_TIME enum_wheather_time);

    //天气预报和实况 实时
    HeWeatherResponse getWeatherInfo(String location, String key, String lang, String unit, ENUM_WHEATHER_TIME enum_wheather_time);



}
