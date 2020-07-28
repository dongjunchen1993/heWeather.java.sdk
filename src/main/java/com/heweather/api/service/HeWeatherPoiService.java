package com.heweather.api.service;

import com.heweather.api.dto.UnitEnum;
import com.heweather.api.dto.ApiEnum;
import com.heweather.api.dto.response.HeWeatherResponse;

public interface HeWeatherPoiService {

    HeWeatherResponse getWeatherPoi(ApiEnum apiEnum, UnitEnum enum_unit_code, String location, String key, String lang);

    HeWeatherResponse getWeatherPoi(ApiEnum apiEnum, String location, String key);
}
