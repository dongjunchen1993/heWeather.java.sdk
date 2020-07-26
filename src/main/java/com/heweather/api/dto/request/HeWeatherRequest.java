package com.heweather.api.dto.request;

/**
 *  请求实体类
 *  Create BY DJC ON 2020-07-19
 */
public class HeWeatherRequest {

    //需要查询的城市名称：可使用Location ID、中文、英文、以逗号分隔的经度/纬度坐标、ADCode（仅限中国城市）（必传）
    private String location;
    //用户认证key（必传）
    private String key;
    //城市所属行政区划，只支持多语言文字，默认不限定行政区划。
    private String adm;
    //搜索范围:默认搜索全球城市。 可设定只在某个国家范围内进行搜索，国家名称需使用ISO 3166 所定义的国家代码。world 全球城市范围，默认;cn 中国城市范围，可替换为其他国家的ISO 3166 国家代码，例如range=us(非必传)
    private String range;
    //搜索查询的方式。在使用名称搜索的时候，可选择模糊搜索或精准搜索，精准搜索最多返回1个结果，模糊搜索最多返回10个结果。默认精准搜索。exact:精准搜索，默认;fuzzy:模糊搜索.(非必传)
    private String mode;
    //返回城市的数量，取值范围1-20，默认返回10个结果。(非必传)
    private Integer number;
    //对API接口进行压缩，可以极大的减少API接口访问延迟，减少缓存空间，提高接口连接成功率。默认开启gzip y:使用gzip方式压缩，默认；n：不实用压缩.(非必传)
    private String gzip;
    //多语言，默认中文，例如lang=en。具体的语言参数值请参考多语言参数。当一些城市不存在对应的语言时，将返回英文或其本地语言结果。
    private String lang;
    //选择POI所在城市，可设定只搜索在特定城市内的POI信息。城市名称可以是中文、英文或城市的LocationID。默认全世界范围
    private String city;
    //POI类型，可选择搜索某一类型的POI，目前仅限景点。例如type=scenic
    private String type;
    //搜索范围，可设置搜索半径，取值范围1-50，单位：公里。默认5公里。
    private int radius;
    //度量衡单位参数选择，例如温度选摄氏度或华氏度、公里或英里。默认公制单位。m：公制单位，默认；i：英制单位
    private String unit;
    //选择获取历史的日期限度，最多可选择最近10天的数据，例如今天是7月5日，最多可获取6月25日至7月4日的历史数据。日期格式为yyyyMMdd，例如 date=20200531
    private String date;

    public String getAdm() {
        return adm;
    }

    public void setAdm(String adm) {
        this.adm = adm;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getGzip() {
        return gzip;
    }

    public void setGzip(String gzip) {
        this.gzip = gzip;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
