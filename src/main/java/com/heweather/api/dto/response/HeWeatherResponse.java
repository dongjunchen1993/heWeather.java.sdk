package com.heweather.api.dto.response;

import java.util.List;

/**
 * 返回实体类
 */
public class HeWeatherResponse {

    private String status;
    //当前API的最近更新时间
    private String updateTime;
    //该城市的天气预报和实况自适应网页，可嵌入网站或应用
    private String fxLink;
    //
    private List<LocationInfo> location;
    //
    private List<LocationInfo> topCityList;
    //
    private List<PoiInfo> poi;
    //
    private WeatherInfo weatherInfo;
    //
    private Minutely minutely;
    //
    private AirQuality airQuality;
    //
    private DisasterWarning disasterWarning;
    //
    private DisasterWarningCityList disasterWarningCityList;
    //
    private WeatherIndices weatherIndices;
    //
    private WeatherPoiInfo weatherPoiInfo;
    //
    private WeatherAirHistory weatherHistory;
    //
    private WeatherAirHistory airHistory;
    //
    private SunMoonData sunMoonData;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<LocationInfo> getLocation() {
        return location;
    }

    public void setLocation(List<LocationInfo> location) {
        this.location = location;
    }

    public List<LocationInfo> getTopCityList() {
        return topCityList;
    }

    public void setTopCityList(List<LocationInfo> topCityList) {
        this.topCityList = topCityList;
    }

    public List<PoiInfo> getPoi() {
        return poi;
    }

    public void setPoi(List<PoiInfo> poi) {
        this.poi = poi;
    }

    public WeatherInfo getWeatherInfo() {
        return weatherInfo;
    }

    public void setWeatherInfo(WeatherInfo weatherInfo) {
        this.weatherInfo = weatherInfo;
    }

    public Minutely getMinutely() {
        return minutely;
    }

    public void setMinutely(Minutely minutely) {
        this.minutely = minutely;
    }

    public AirQuality getAirQuality() {
        return airQuality;
    }

    public void setAirQuality(AirQuality airQuality) {
        this.airQuality = airQuality;
    }

    public DisasterWarning getDisasterWarning() {
        return disasterWarning;
    }

    public void setDisasterWarning(DisasterWarning disasterWarning) {
        this.disasterWarning = disasterWarning;
    }

    public DisasterWarningCityList getDisasterWarningCityList() {
        return disasterWarningCityList;
    }

    public void setDisasterWarningCityList(DisasterWarningCityList disasterWarningCityList) {
        this.disasterWarningCityList = disasterWarningCityList;
    }

    public WeatherIndices getWeatherIndices() {
        return weatherIndices;
    }

    public void setWeatherIndices(WeatherIndices weatherIndices) {
        this.weatherIndices = weatherIndices;
    }

    public WeatherPoiInfo getWeatherPoiInfo() {
        return weatherPoiInfo;
    }

    public void setWeatherPoiInfo(WeatherPoiInfo weatherPoiInfo) {
        this.weatherPoiInfo = weatherPoiInfo;
    }

    public WeatherAirHistory getWeatherHistory() {
        return weatherHistory;
    }

    public void setWeatherHistory(WeatherAirHistory weatherHistory) {
        this.weatherHistory = weatherHistory;
    }

    public WeatherAirHistory getAirHistory() {
        return airHistory;
    }

    public void setAirHistory(WeatherAirHistory airHistory) {
        this.airHistory = airHistory;
    }

    public SunMoonData getSunMoonData() {
        return sunMoonData;
    }

    public void setSunMoonData(SunMoonData sunMoonData) {
        this.sunMoonData = sunMoonData;
    }
}
