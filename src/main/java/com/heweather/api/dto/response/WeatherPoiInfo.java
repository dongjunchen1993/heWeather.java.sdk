package com.heweather.api.dto.response;

import com.heweather.api.dto.response.weatherInfo.Refer;
import com.heweather.api.dto.response.weatherPoi.Daily;
import com.heweather.api.dto.response.weatherPoi.Now;

import java.util.List;

/**
 * POI天气实体类
 */
public class WeatherPoiInfo {

    private Now now;

    private List<Daily> dailyList;

    private Refer refer;

    public Now getNow() {
        return now;
    }

    public void setNow(Now now) {
        this.now = now;
    }

    public List<Daily> getDailyList() {
        return dailyList;
    }

    public void setDailyList(List<Daily> dailyList) {
        this.dailyList = dailyList;
    }

    public Refer getRefer() {
        return refer;
    }

    public void setRefer(Refer refer) {
        this.refer = refer;
    }
}
