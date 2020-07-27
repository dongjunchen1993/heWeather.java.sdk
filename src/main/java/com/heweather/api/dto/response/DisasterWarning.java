package com.heweather.api.dto.response;

import com.heweather.api.dto.response.warning.Warning;
import com.heweather.api.dto.response.weatherInfo.Refer;

import java.util.List;

public class DisasterWarning {

    private List<Warning> warning;

    private Refer refer;

    public List<Warning> getWarning() {
        return warning;
    }

    public void setWarning(List<Warning> warning) {
        this.warning = warning;
    }

    public Refer getRefer() {
        return refer;
    }

    public void setRefer(Refer refer) {
        this.refer = refer;
    }
}
