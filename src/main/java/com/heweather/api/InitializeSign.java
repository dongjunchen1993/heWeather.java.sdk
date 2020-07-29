package com.heweather.api;

/**
 * 用户秘钥
 * @author  djc
 */
public class InitializeSign {

    private static String sign;
    private static String key;

    private static  final void initializeSign(String publicid,String privatekey) {
        sign = privatekey;
        key =  publicid;
    }

    public static String getSign() {
        return sign;
    }

    public static String getKey() {
        return key;
    }

    public static void main(String[] args) {
        InitializeSign.initializeSign("AAA11111","BBB22222");
        String sign = InitializeSign.getSign();
        String key = InitializeSign.getKey();
        System.out.println(sign+"==="+key);
    }
}
