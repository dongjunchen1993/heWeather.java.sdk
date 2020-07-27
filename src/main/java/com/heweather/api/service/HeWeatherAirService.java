package com.heweather.api.service;

import com.heweather.api.dto.ENUM_WHEATHER_TIME;
import com.heweather.api.dto.response.HeWeatherResponse;

public interface HeWeatherAirService {

    HeWeatherResponse getWeatherAir(String location, String key, String lang, ENUM_WHEATHER_TIME enum_wheather_time);


    HeWeatherResponse getWeatherAir(String location, String key,ENUM_WHEATHER_TIME enum_wheather_time);
}
