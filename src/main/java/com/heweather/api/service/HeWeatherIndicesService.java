package com.heweather.api.service;

import com.heweather.api.dto.ApiEnum;
import com.heweather.api.dto.response.HeWeatherResponse;

/**
 * 天气生活指数
 * add by djc
 */
public interface HeWeatherIndicesService {

    //天气生活指数
    HeWeatherResponse getWeatherIndices(String location, String type, String lang, ApiEnum apiEnum);

    //天气生活指数
    HeWeatherResponse getWeatherIndices(String location, String type, ApiEnum apiEnum);
}
