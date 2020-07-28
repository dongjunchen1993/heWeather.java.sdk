package com.heweather.api.service;

import com.heweather.api.dto.UnitEnum;
import com.heweather.api.dto.ApiEnum;
import com.heweather.api.dto.response.HeWeatherResponse;

/**
 * 中国景点天气预报
 * add by djc
 */
public interface HeWeatherPoiService {

    HeWeatherResponse getWeatherPoi(ApiEnum apiEnum, UnitEnum enum_unit_code, String location, String key, String lang, String sign);

    HeWeatherResponse getWeatherPoi(ApiEnum apiEnum, String location, String key, String sign);
}
