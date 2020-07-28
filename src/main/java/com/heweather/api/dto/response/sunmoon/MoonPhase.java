package com.heweather.api.dto.response.sunmoon;

public class MoonPhase {

    private String fxTime;//	月相逐小时预报时间	2013-12-31T23:31+08:00
    private String value;//	月相数值	0.25
    private String name;//	月相名字	上弦月
    private String illumination;//月亮照明度，百分比数值	30

    public String getFxTime() {
        return fxTime;
    }

    public void setFxTime(String fxTime) {
        this.fxTime = fxTime;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIllumination() {
        return illumination;
    }

    public void setIllumination(String illumination) {
        this.illumination = illumination;
    }
}
