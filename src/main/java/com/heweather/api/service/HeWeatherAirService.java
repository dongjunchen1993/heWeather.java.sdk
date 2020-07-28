package com.heweather.api.service;

import com.heweather.api.dto.ApiEnum;
import com.heweather.api.dto.response.HeWeatherResponse;

/**
 * 空气质量请求
 * add by djc
 */
public interface HeWeatherAirService {

    HeWeatherResponse getWeatherAir(String location, String key, String lang, ApiEnum apiEnum, String sign);


    HeWeatherResponse getWeatherAir(String location, String key, ApiEnum apiEnum, String sign);
}
