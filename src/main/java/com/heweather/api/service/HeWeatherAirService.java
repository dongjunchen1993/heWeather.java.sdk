package com.heweather.api.service;

import com.heweather.api.dto.ApiEnum;
import com.heweather.api.dto.response.HeWeatherResponse;

public interface HeWeatherAirService {

    HeWeatherResponse getWeatherAir(String location, String key, String lang, ApiEnum apiEnum);


    HeWeatherResponse getWeatherAir(String location, String key, ApiEnum apiEnum);
}
