package com.heweather.api.dto.response;

import com.heweather.api.dto.response.weatherinfo.Refer;
/**
 * 分钟级降水实体类
 */
public class Minutely {
    //当前API的最近更新时间
    private String updateTime;
    //该城市的天气预报和实况自适应网页，可嵌入网站或应用
    private String fxLink;
    //分钟降水描述
    private String summary;
    //预报时间
    private String fxTime;
    //降水量
    private String precip;
    //降水类型
    private String type;
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getFxTime() {
        return fxTime;
    }

    public void setFxTime(String fxTime) {
        this.fxTime = fxTime;
    }

    public String getPrecip() {
        return precip;
    }

    public void setPrecip(String precip) {
        this.precip = precip;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Refer getRefer() {
        return refer;
    }

    public void setRefer(Refer refer) {
        this.refer = refer;
    }
}
