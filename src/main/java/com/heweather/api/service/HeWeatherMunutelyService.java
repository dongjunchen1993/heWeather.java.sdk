package com.heweather.api.service;

import com.heweather.api.dto.response.HeWeatherResponse;

public interface HeWeatherMunutelyService {

    //分钟及降水
    HeWeatherResponse getMinutely(String laction ,String key);
    //分钟级降水
    HeWeatherResponse getMinutely(String laction ,String key,String lang);

}
