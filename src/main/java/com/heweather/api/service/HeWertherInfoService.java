package com.heweather.api.service;

import com.heweather.api.dto.ApiEnum;
import com.heweather.api.dto.response.HeWeatherResponse;

/**
 * 天气预报和实况
 * add by djc
 */
public interface HeWertherInfoService {

    //天气预报和实况 实时
    HeWeatherResponse getWeatherInfo(String location, String key, ApiEnum apiEnum, String sign);

    //天气预报和实况 实时
    HeWeatherResponse getWeatherInfo(String location, String key, String lang, ApiEnum apiEnum, String sign);


}
