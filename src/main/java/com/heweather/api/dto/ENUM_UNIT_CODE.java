package com.heweather.api.dto;

/**
 * @author Djc
 * 天气标识
 */
public enum ENUM_UNIT_CODE {
    /**
     * 实况天气
     */
    UNIT_CODE_M("m","公制单位"),
    /**
     * 实况天气
     */
    UNIT_CODE_I("i","英制单位");

    /**
     * 编号
     */
    private final String value;
    /**
     * 编号对应的值
     */
    private final String name;
    ENUM_UNIT_CODE(String value, String name){
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
