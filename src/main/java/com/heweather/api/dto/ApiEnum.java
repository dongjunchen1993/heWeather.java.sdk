package com.heweather.api.dto;

/**
 * @author Djc
 * 天气标识
 */
public enum ApiEnum {
    /**
     * 实况天气
     */
    NOW_DAY_WEATHER("now?", "实况天气"),
    /**
     * 1天预报
     */
    ONE_DAY_WEATHER("1d?", "1天预报"),
    /**
     * 3天预报
     */
    THREE_DAY_WEATHER("3d?", "3天预报"),
    /**
     * 7天预报
     */
    SEVEN_DAY_WEATHER("7d?", "7天预报"),
    /**
     * 10天预报
     */
    TEN_DAY_WEATHER("10d?", "15天预报"),
    /**
     * 15天预报
     */
    FIFTEEN_DAY_WEATHER("15d?", "查勘"),
    /**
     * 逐小时预报（未来24小时）
     */
    TWENTYFOUR_HOURS_WEATHER("24h?", "逐小时预报（未来24小时）"),
    /**
     * 逐小时预报（未来72小时）
     */
    SEVENTYTWO_HOURS_WEATHER("72h?", "逐小时预报（未来72小时）"),
    /**
     * 逐小时预报（未来168小时）
     */
    ONESIXEIGHT_HOURS_WEATHER("168h?", "逐小时预报（未来168小时）");


    /**
     * 编号
     */
    private final String value;
    /**
     * 编号对应的值
     */
    private final String name;

    ApiEnum(String value, String name) {
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
