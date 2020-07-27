package com.heweather.api.service;

import com.heweather.api.dto.ENUM_UNIT_CODE;
import com.heweather.api.dto.ENUM_WHEATHER_TIME;
import com.heweather.api.dto.response.HeWeatherResponse;

public interface HeWeatherPoiService {

    HeWeatherResponse getWeatherPoi(ENUM_WHEATHER_TIME enum_wheather_time,ENUM_UNIT_CODE enum_unit_code, String location, String key, String lang);

    HeWeatherResponse getWeatherPoi(ENUM_WHEATHER_TIME enum_wheather_time,String location,String key);
}
