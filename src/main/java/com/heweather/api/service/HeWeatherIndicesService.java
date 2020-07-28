package com.heweather.api.service;

import com.heweather.api.dto.ApiEnum;
import com.heweather.api.dto.response.HeWeatherResponse;

public interface HeWeatherIndicesService {
    //天气生活指数
    HeWeatherResponse getWeatherIndices(String location, String key, String type, String lang, ApiEnum apiEnum);

    //天气生活指数
    HeWeatherResponse getWeatherIndices(String location, String key, String type, ApiEnum apiEnum);
}
