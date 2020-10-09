
# 本SDK存在一些问题，已编写新的SDK供大家参考，[飞机票](https://github.com/dongjunchen1993/HeWeather_SDK_V7)

# JAVA SDK 使用文档
## 本文为您介绍和风天气Java SDK的相关信息。
### **SDK下载**
#### 和风天气：

##### 此SDK分别提供了以下接口为大家使用：

######需要先配置用户认证ID和key
**简要描述：** 
**请求方法：** 
- getWeatherInfo()

**参数说明：**

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|publicid |是  |String | 用户认证ID    |
|privatekey |是  |String | 用户认证密钥    | 

``` 
  public class InitializeSign {
  
      private static String sign;
      private static String key;
  
      private static  final void initializeSign(String publicid,String privatekey) {
          sign = privatekey;
          key =  publicid;
      }
  
  }
```


##### 天气预报和实况
**简要描述：** 
- 城市级天气预报API，包括全球15万个城市或地区的1-15天天气预报、实况天气、逐小时天气预报以及日出日落、月升月落等数据。

**请求方式：**
- GET
**请求方法：** 
- getWeatherInfo()

**参数说明：**

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|location |是  |String | 需要查询地区    |
|apiEnum |是  |Enum | 请求类型    |  
|lang |否  |string | 多语言设置    | 

``` 
  public interface HeWertherInfoService {
  
      //天气预报和实况 实时
      HeWeatherResponse getWeatherInfo(String location, ApiEnum apiEnum);
  
      //天气预报和实况 实时
      HeWeatherResponse getWeatherInfo(String location,String lang, ApiEnum apiEnum);
  }
```
#### 城市信息搜索
**简要描述：** 
- 天气数据是基于地理位置的数据，因此获取天气之前需要先知道具体的位置信息。

#####城市信息搜索
**请求方式：**
- GET
**请求方法：** 
- getLocation()

**参数说明：**

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|location |是  |String | 需要查询地区    |
|apiEnum |是  |Enum | 请求类型    |  
|lang |否  |string | 多语言设置    | 
|adm |否  |string | 城市所属行政区    | 
|range |否  |string | 搜索范围    | 
|number |否  |string | 返回城市数量    | 

##### 热门城市查询
**请求方式：**
- GET
**请求方法：** 
- getTopLocation()

**参数:**

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|number |是  |String | 请求类型    |  
|lang |是  |string | 多语言设置    | 
|range |是  |string | 多语言设置    | 

##### poi信息搜索
**请求方式：**
- GET
**请求方法：** 
- getLookupPoiLocation()

**参数说明：**

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|location |是  |String | 需要查询地区    |
|number |是  |String | 请求类型    |  
|lang |是  |string | 多语言设置    | 
|type |是  |string | poi类型    | 
|city |是  |string | 所在城市    | 
|radius |是  |string | 搜索范围    | 
|number |是  |string | 返回城市数量    | 

##### poi范围搜索
**请求方式：**
- GET
**请求方法：** 
- getRangePoiLocation()

**参数说明：**

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|location |是  |String | 需要查询地区    |
|number |是  |String | 请求类型    |  
|lang |是  |string | 多语言设置    | 
|type |是  |string | poi类型    | 
|radius |是  |string | 搜索范围    | 
|number |是  |string | 返回城市数量    | 


``` 
  public interface HeWeatherLocationService {
  
    //城市信息搜索(location = 城市名称， adm = 城市所属行政区;range = 搜索范围 ;number = 返回城市数量; lang = 语言 )
    HeWeatherResponse getLocation(String location, String adm, String range, Integer number, String lang);
    
    //热门城市搜索（key = 用户认证ID; range = 搜索范围 ;number = 返回城市数量; lang = 语言）
    HeWeatherResponse getTopLocation( String range, Integer number, String lang);
     
    //poi信息搜索(location = 城市名称， ；type = poi类型 ; radius = 搜索范围 ；city = 所在城市； number = 返回城市数量 ； lang = 语言; ）
    HeWeatherResponse getLookupPoiLocation(String location, String type, String city, Integer number, String lang);
    
    //poi范围搜索 (location = 城市名称；type = poi类型 ; radius = 搜索范围 ； number = 返回城市数量 ； lang = 语言;）
    HeWeatherResponse getRangePoiLocation(String location, String type, Integer radius, Integer number, String lang);

  }
```
#### 分钟级降水
**简要描述：** 
- 和风天气分钟级降水API接口提供中国地区未来2小时内每5分钟降水数据、降水类型以及未来2小时的降水概况信息。
- 可实现精确到1公里格点的全国分钟级降雨/降雪预报，为每一分钟的降雨进行预测。
##### 分钟级降水
**请求方式：**
- GET
**请求方法：** 
- getMinutely()

**参数说明：**

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|location |是  |String | 需要查询地区    | 
|number |是  |String | 请求类型    |  
|lang |是  |string | 多语言设置    | 

``` 
  public interface HeWeatherMunutelyService {
  
      //分钟级降水
      HeWeatherResponse getMinutely(String location, String lang);
  
  }
```

#### 空气质量
**简要描述：** 
- 全国3240市县区及1500个监测站点的空气质量AQI接口，支持空气质量AQI数据，空气质量实况数据、空气质量未来7天预报。
- 通过灵活的接口请求参数，你可以一次获取以上数据，也可以分别获取其中你需要的数据。
##### 空气质量实况
**请求方式：**
- GET
**请求方法：** 
- getWeatherAir()

**参数说明：**

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|location |是  |String | 需要查询地区    | 
|apiEnum |是  |ENUM | 请求类型    |  
|lang |是  |string | 多语言设置    | 

``` 
 public interface HeWeatherAirService {
     //空气质量实况
     HeWeatherResponse getWeatherAir(String location, String lang, ApiEnum apiEnum);
 }
```

#### 天气灾害预警
**简要描述：** 
- 和风天气灾害预警API接口支持全国3240个市县区天气灾害预警，
##### 灾害预警
**请求方式：**
- GET
**请求方法：** 
- getWeatherWarning()
**参数：** 
|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|location |是  |String | 需要查询地区    | 
|lang |是  |string | 多语言设置    | 

##### 灾害预警城市列表
**请求方式：**
- GET
**请求方法：** 
- getWarningLocList()

**参数说明：**

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|range |是  |String | 选择指定的国，目前仅支持中国    | 

``` 
 public interface HeWeatherWarningSrevice {
     //灾害预警
     HeWeatherResponse getWeatherWarning(String location,String lang);
  
     //灾害预警城市列表
     HeWeatherResponse getWarningLocList(String range);
 }
```

#### 天气生活指数
**简要描述：** 
- 和风天气生活指数API接口为中国和海外城市提供详细的生活指数实况和预报数据
##### 天气生活指数
**请求方式：**
- GET
**请求方法：** 
- getWeatherIndices()

**参数说明：**

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|location |是  |String | 需要查询地区    | 
|type |是  |String | 生活指数数据类型ID    |  
|apiEnum |是  |ENUM | 请求类型    |  
|lang |是  |string | 多语言设置    | 

``` 
 public interface HeWeatherIndicesService {
 
     //天气生活指数
     HeWeatherResponse getWeatherIndices(String location, String type, String lang, ApiEnum apiEnum);
 
}
```

#### 中国景点天气预报
**简要描述：** 
- 中国4A和5A级景点共2000＋的7天天气预报，包括：日出日落时间、最高最低温度、白天和晚间天气状况、风力、风向等。
##### 中国景点天气预报
**请求方式：**
- GET
**请求方法：** 
- getWeatherPoi()

**参数说明：**

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|location |是  |String | 需要查询地区    | 
|apiEnum |是  |ENUM | 请求类型    |  
|enum_unit_code |是  |ENUM | 单位名称    |  
|lang |是  |string | 多语言设置    | 

``` 
 public interface HeWeatherPoiService {
     //中国景点天气预报
     HeWeatherResponse getWeatherPoi(ApiEnum apiEnum, UnitEnum enum_unit_code, String location, String lang);
 
 }
```

#### 历史天气和空气质量
**简要描述：** 
- 中国4A和5A级景点共2000＋的7天天气预报，包括：日出日落时间、最高最低温度、白天和晚间天气状况、风力、风向等。
##### 历史天气和空气质量
**请求方式：**
- GET
**请求方法：** 
- getWeatherPoi()


**参数说明：**

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|location |是  |String | 需要查询地区    | 
|enum_unit_code |是  |ENUM | 请求类型    |  
|enum_unit_code |是  |ENUM | 单位名称    |  
|lang |是  |string | 多语言设置    | 
|date |是  |string | 选择日期，最多可选择最近60天的数据    | 

``` 
 public interface HeWeatherHistoricalService {
 
     //历史天气和空气质量
     HeWeatherResponse getWeatherPoi(TypeEnum enum_type_code, String location, String date, String lang, UnitEnum enum_unit_code);
 }
```


#### 太阳和月亮
**简要描述：** 
- 获取最近60天全球城市日出日落、月升月落和逐小时的月相数据。
##### 日出日落、月升月落和月相
**请求方式：**
- GET
**请求方法：** 
- getSunmoon()

**参数说明：**

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|location |是  |String | 需要查询地区    | 
|lang |是  |string | 多语言设置    | 
|date |是  |string | 选择日期，最多可选择最近60天的数据    | 

``` 
 public interface HeWeatherAstronomyService {
     
     //日出日落、月升月落和月相
     HeWeatherResponse getSunmoon(String location, String date, String lang);
 }
```






