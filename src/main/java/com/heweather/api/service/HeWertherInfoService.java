package com.heweather.api.service;

import com.heweather.api.dto.ApiEnum;
import com.heweather.api.dto.response.HeWeatherResponse;

public interface HeWertherInfoService {

    //天气预报和实况 实时
    HeWeatherResponse getWeatherInfo(String location, String key, ApiEnum apiEnum);

    //天气预报和实况 实时
    HeWeatherResponse getWeatherInfo(String location, String key, String lang, String unit, ApiEnum apiEnum);



}
