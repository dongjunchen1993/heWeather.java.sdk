package com.heweather.api.dto.response;

import com.heweather.api.dto.response.air.Daily;
import com.heweather.api.dto.response.air.Now;
import com.heweather.api.dto.response.air.Station;
import com.heweather.api.dto.response.weatherinfo.Refer;

import java.util.List;

/**
 * 空气质量实体类
 *
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
