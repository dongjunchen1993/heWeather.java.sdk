package com.heweather.api.dto.response.weatherInfo;

import java.util.List;

public class Refer {

    //原始数据来源，可能为空
    private List<String> sources;

    //数据许可证
    private List<String> license;

    public List<String> getSources() {
        return sources;
    }

    public void setSources(List<String> sources) {
        this.sources = sources;
    }

    public List<String> getLicense() {
        return license;
    }

    public void setLicense(List<String> license) {
        this.license = license;
    }
}
