package com.heweather.api.dto;

/**
 * @author Djc
 * 天气标识
 */
public enum TypeEnum {
    /**
     * 天气历史数据
     */
    TYPE_CODE_WEATHER("weather?","天气历史数据"),
    /**
     * 空气质量历史数据
     */
    UNIT_CODE_AIR("air?","空气质量历史数据");

    /**
     * 编号
     */
    private final String value;
    /**
     * 编号对应的值
     */
    private final String name;
    TypeEnum(String value, String name){
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
