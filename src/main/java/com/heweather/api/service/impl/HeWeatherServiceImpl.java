package com.heweather.api.service.impl;

import com.heweather.api.dto.request.HeWeatherRequest;
import com.heweather.api.dto.response.HeWeatherResponse;
import com.heweather.api.service.HeWertherInfoService;

public class HeWeatherServiceImpl implements HeWertherInfoService {

    public HeWeatherResponse getNowWeatherInfo(HeWeatherRequest heWeatherRequest) {
        return null;
    }

    public HeWeatherResponse getWeatherInfo(String location, String key, String lang, String unit, String time) {
        HeWeatherResponse heWeatherResponse = new HeWeatherResponse();
        String url = "https://api.heweather.net/v7/weather";
        return null;
    }

    public HeWeatherResponse getWeatherInfo(HeWeatherRequest heWeatherRequest) {
        return null;
    }

    public HeWeatherResponse getThreeDayWeatherInfo(HeWeatherRequest heWeatherRequest) {
        return null;
    }

    public HeWeatherResponse getSevenDayWeatherInfo(HeWeatherRequest heWeatherRequest) {
        return null;
    }

    public HeWeatherResponse getTenDayWeatherInfo(HeWeatherRequest heWeatherRequest) {
        return null;
    }

    public HeWeatherResponse getFifteenDayWeatherInfo(HeWeatherRequest heWeatherRequest) {
        return null;
    }

    public HeWeatherResponse getTwentyFourHoursWeatherInfo(HeWeatherRequest heWeatherRequest) {
        return null;
    }

    public HeWeatherResponse getSeventyTwoHoursWeatherInfo(HeWeatherRequest heWeatherRequest) {
        return null;
    }

    public HeWeatherResponse getOneSixtyEightWeatherInfo(HeWeatherRequest heWeatherRequest) {
        return null;
    }
}
