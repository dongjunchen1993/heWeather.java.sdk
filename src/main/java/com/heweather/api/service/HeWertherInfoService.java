package com.heweather.api.service;

import com.heweather.api.dto.request.HeWeatherRequest;
import com.heweather.api.dto.response.HeWeatherResponse;

public interface HeWertherInfoService {

    //天气预报和实况 实时
    HeWeatherResponse getNowWeatherInfo(HeWeatherRequest heWeatherRequest);

    //天气预报和实况 实时
    HeWeatherResponse getWeatherInfo(String location,String key,String lang,String unit,String time);



    //天气预报和实况 实时
    HeWeatherResponse getWeatherInfo(HeWeatherRequest heWeatherRequest);


}
