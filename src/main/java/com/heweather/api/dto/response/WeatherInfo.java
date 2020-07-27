package com.heweather.api.dto.response;

import com.heweather.api.dto.response.weatherInfo.Daily;
import com.heweather.api.dto.response.weatherInfo.Hourly;
import com.heweather.api.dto.response.weatherInfo.Now;
import com.heweather.api.dto.response.weatherInfo.Refer;

import java.util.List;

public class WeatherInfo {
    //当前API的最近更新时间
    private String updateTime;
    //该城市的天气预报和实况自适应网页，可嵌入网站或应用
    private String fxLink;
    //实况天气
    private Now now;
    //日期天气
    private List<Daily> daily;
    //小时天气
    private List<Hourly> hourly;
    //数据来源
    private Refer refer;

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getFxLink() {
        return fxLink;
    }

    public void setFxLink(String fxLink) {
        this.fxLink = fxLink;
    }

    public Now getNow() {
        return now;
    }

    public void setNow(Now now) {
        this.now = now;
    }

    public List<Daily> getDaily() {
        return daily;
    }

    public void setDaily(List<Daily> daily) {
        this.daily = daily;
    }

    public List<Hourly> getHourly() {
        return hourly;
    }

    public void setHourly(List<Hourly> hourly) {
        this.hourly = hourly;
    }

    public Refer getRefer() {
        return refer;
    }

    public void setRefer(Refer refer) {
        this.refer = refer;
    }
}
