package com.heweather.api.dto.response;

import com.heweather.api.dto.response.sumMoon.MoonPhase;
import com.heweather.api.dto.response.weatherInfo.Refer;

/**
 * 太阳和月亮
 */
public class SunMoonData {

    private String sunrise;//	日出时间	2013-12-30T05:44+08:00
    private String sunset;//	日落时间	2013-12-30T17:02+08:00
    private String moonrise;//	月升时间	2013-12-30T13:19+08:00
    private String moonset;//	月落时间	2013-12-31T23:31+08:00
    private MoonPhase moonPhase;//月相
    private Refer refer;//原始数据来源

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getMoonrise() {
        return moonrise;
    }

    public void setMoonrise(String moonrise) {
        this.moonrise = moonrise;
    }

    public String getMoonset() {
        return moonset;
    }

    public void setMoonset(String moonset) {
        this.moonset = moonset;
    }

    public MoonPhase getMoonPhase() {
        return moonPhase;
    }

    public void setMoonPhase(MoonPhase moonPhase) {
        this.moonPhase = moonPhase;
    }

    public Refer getRefer() {
        return refer;
    }

    public void setRefer(Refer refer) {
        this.refer = refer;
    }
}
