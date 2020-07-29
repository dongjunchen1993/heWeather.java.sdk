package com.heweather.api.service;

import com.heweather.api.dto.ApiEnum;
import com.heweather.api.dto.response.HeWeatherResponse;

/**
 * 天气预报和实况
 * add by djc
 */
public interface HeWeatherInfoService {

    //天气预报和实况 实时
    HeWeatherResponse getWeatherInfo(String location,ApiEnum apiEnum);

    //天气预报和实况 实时
    HeWeatherResponse getWeatherInfo(String location,String lang, ApiEnum apiEnum);


}
