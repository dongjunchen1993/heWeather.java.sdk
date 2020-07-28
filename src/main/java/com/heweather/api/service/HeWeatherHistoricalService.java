package com.heweather.api.service;

import com.heweather.api.dto.TypeEnum;
import com.heweather.api.dto.UnitEnum;
import com.heweather.api.dto.response.HeWeatherResponse;

/**
 * 历史天气和空气质量
 * add by djc
 */
public interface HeWeatherHistoricalService {

    HeWeatherResponse getWeatherPoi(TypeEnum enum_type_code, String location, String key, String date);

    HeWeatherResponse getWeatherPoi(TypeEnum enum_type_code, String location, String key, String date, String lang, UnitEnum enum_unit_code);
}
