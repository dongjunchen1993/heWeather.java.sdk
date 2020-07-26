package com.heweather.api.service;

import com.heweather.api.dto.request.HeWeatherRequest;
import com.heweather.api.dto.response.HeWeatherResponse;

public interface HeWertherService {
    //城市信息搜索
    HeWeatherResponse getLocationInfo(HeWeatherRequest heWeatherRequest);
    //热门城市搜索
    HeWeatherResponse getTopLocationInfo(HeWeatherRequest heWeatherRequest);
    //poi信息搜索
    HeWeatherResponse getLookupPoiLocationInfo(HeWeatherRequest heWeatherRequest);
    //poi范围搜索
    HeWeatherResponse getRangePoiLocationInfo(HeWeatherRequest heWeatherRequest);
    //天气预报和实况 实时
    HeWeatherResponse getNowWeatherInfo(HeWeatherRequest heWeatherRequest);
    //天气预报和实况 三天
    HeWeatherResponse getThreeDayWeatherInfo(HeWeatherRequest heWeatherRequest);
    //天气预报和实况 七天
    HeWeatherResponse getSevenDayWeatherInfo(HeWeatherRequest heWeatherRequest);
    //天气预报和实况 十天
    HeWeatherResponse getTenDayWeatherInfo(HeWeatherRequest heWeatherRequest);
    //天气预报和实况 十五天
    HeWeatherResponse getFifteenDayWeatherInfo(HeWeatherRequest heWeatherRequest);
    //天气预报和实况 二十四小时
    HeWeatherResponse getTwentyFourHoursWeatherInfo(HeWeatherRequest heWeatherRequest);
    //天气预报和实况 七十二小时
    HeWeatherResponse getSeventyTwoHoursWeatherInfo(HeWeatherRequest heWeatherRequest);
    //天气预报和实况 一百六十八小时
    HeWeatherResponse getOneSixtyEightWeatherInfo(HeWeatherRequest heWeatherRequest);


}
