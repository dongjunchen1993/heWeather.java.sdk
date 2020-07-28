package com.heweather.api.service;

import com.heweather.api.dto.response.HeWeatherResponse;

/**
 * 太阳和月亮
 * add by djc
 */
public interface HeWeatherAstronomyService {

    HeWeatherResponse geitSunmoon(String location, String key, String date, String sign);

    HeWeatherResponse geitSunmoon(String location, String key, String date, String lang, String sign);
}
