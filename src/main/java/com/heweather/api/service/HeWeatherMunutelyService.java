package com.heweather.api.service;

import com.heweather.api.dto.response.HeWeatherResponse;

/**
 * 分钟级降水
 * add by djc
 */
public interface HeWeatherMunutelyService {

    //分钟及降水
    HeWeatherResponse getMinutely(String location, String key, String sign);

    //分钟级降水
    HeWeatherResponse getMinutely(String location, String key, String lang, String sing);

}
