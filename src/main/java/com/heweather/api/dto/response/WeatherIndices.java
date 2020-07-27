package com.heweather.api.dto.response;

import com.heweather.api.dto.response.indices.Daily;
import com.heweather.api.dto.response.weatherInfo.Refer;

import java.util.List;

public class WeatherIndices {
    //
    private List<Daily> daily;

    private Refer refer;

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
