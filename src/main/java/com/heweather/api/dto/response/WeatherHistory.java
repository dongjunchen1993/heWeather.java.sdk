package com.heweather.api.dto.response;

import com.heweather.api.dto.response.history.AirHourly;
import com.heweather.api.dto.response.history.WeatherDaily;
import com.heweather.api.dto.response.history.WeatherHourly;
import com.heweather.api.dto.response.weatherinfo.Refer;

import java.util.List;

/**
 * 历史天气空气实体类
 */
public class WeatherHistory {

    //历史天气
    private List<AirHourly> airHourly;

    //
    private WeatherDaily weatherDaily;

    //
    private List<WeatherHourly> weatherHourly;

    private Refer refer;

    public Refer getRefer() {
        return refer;
    }

    public void setRefer(Refer refer) {
        this.refer = refer;
    }

    public List<AirHourly> getAirHourly() {
        return airHourly;
    }

    public void setAirHourly(List<AirHourly> airHourly) {
        this.airHourly = airHourly;
    }

    public WeatherDaily getWeatherDaily() {
        return weatherDaily;
    }

    public void setWeatherDaily(WeatherDaily weatherDaily) {
        this.weatherDaily = weatherDaily;
    }

    public List<WeatherHourly> getWeatherHourly() {
        return weatherHourly;
    }

    public void setWeatherHourly(List<WeatherHourly> weatherHourly) {
        this.weatherHourly = weatherHourly;
    }
}
