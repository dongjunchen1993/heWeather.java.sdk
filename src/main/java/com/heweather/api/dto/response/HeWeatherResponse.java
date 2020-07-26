package com.heweather.api.dto.response;

import java.util.List;

public class HeWeatherResponse {
    private String status;
    //
    private List<LocationInfo> location;
    //
    private List<LocationInfo> topCityList;
    //
    private PoiInfo poi;
    //
    private WeatherInfoNow weatherInfoNow;
    //
    private Minutely minutely;
    //
    private AirQualit airQualit;
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

    public PoiInfo getPoi() {
        return poi;
    }

    public void setPoi(PoiInfo poi) {
        this.poi = poi;
    }

    public WeatherInfoNow getWeatherInfoNow() {
        return weatherInfoNow;
    }

    public void setWeatherInfoNow(WeatherInfoNow weatherInfoNow) {
        this.weatherInfoNow = weatherInfoNow;
    }

    public Minutely getMinutely() {
        return minutely;
    }

    public void setMinutely(Minutely minutely) {
        this.minutely = minutely;
    }

    public AirQualit getAirQualit() {
        return airQualit;
    }

    public void setAirQualit(AirQualit airQualit) {
        this.airQualit = airQualit;
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
