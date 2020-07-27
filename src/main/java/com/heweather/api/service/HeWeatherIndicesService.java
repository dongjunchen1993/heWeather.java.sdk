package com.heweather.api.service;

import com.heweather.api.dto.ENUM_WHEATHER_TIME;
import com.heweather.api.dto.response.HeWeatherResponse;

public interface HeWeatherIndicesService {
    //天气生活指数
    HeWeatherResponse getWeatherIndices(String location, String key, String type, String lang, ENUM_WHEATHER_TIME enum_wheather_time);

    //天气生活指数
    HeWeatherResponse getWeatherIndices(String location,String key,String type,ENUM_WHEATHER_TIME enum_wheather_time);
}
