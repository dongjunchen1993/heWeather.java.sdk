package com.heweather.api.dto.response;

import com.heweather.api.dto.response.warning.WarningLoc;
import com.heweather.api.dto.response.weatherinfo.Refer;

import java.util.List;

/**
 * 灾害预警城市列表
 *
 * @author djc
 */
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
