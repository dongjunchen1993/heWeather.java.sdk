package com.heweather.api.dto.response;

import com.heweather.api.dto.response.warning.WarningLoc;
import com.heweather.api.dto.response.weatherInfo.Refer;

import java.util.List;

public class DisasterWarningCityList {
    private List<WarningLoc> warningLocList;
    private Refer refer;

    public List<WarningLoc> getWarningLocList() {
        return warningLocList;
    }

    public void setWarningLocList(List<WarningLoc> warningLocList) {
        this.warningLocList = warningLocList;
    }

    public Refer getRefer() {
        return refer;
    }

    public void setRefer(Refer refer) {
        this.refer = refer;
    }
}
