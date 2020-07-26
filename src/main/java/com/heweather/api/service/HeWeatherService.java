package com.heweather.api.service;

import com.heweather.api.dto.response.HeWeatherResponse;

public interface HeWeatherService {

    //空气质量实况
    HeWeatherResponse getAir(String Location,String key);
    //空气质量实况
    HeWeatherResponse getAir(String Location,String key,String lang);
}
