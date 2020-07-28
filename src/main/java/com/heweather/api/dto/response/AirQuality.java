package com.heweather.api.dto.response;

import com.heweather.api.dto.response.airQualit.Daily;
import com.heweather.api.dto.response.airQualit.Now;
import com.heweather.api.dto.response.airQualit.Station;
import com.heweather.api.dto.response.weatherInfo.Refer;

import java.util.List;

/**
 * @author djc
 */
public class AirQuality {

    private Now now;

    private List<Station> station;

    private List<Daily> daily;

    private Refer refer;

    public Now getNow() {
        return now;
    }

    public void setNow(Now now) {
        this.now = now;
    }

    public List<Station> getStation() {
        return station;
    }

    public void setStation(List<Station> station) {
        this.station = station;
    }

    public List<Daily> getDaily() {
        return daily;
    }

    public void setDaily(List<Daily> daily) {
        this.daily = daily;
    }

    public Refer getRefer() {
        return refer;
    }

    public void setRefer(Refer refer) {
        this.refer = refer;
    }
}
