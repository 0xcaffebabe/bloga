package wang.ismy.bloga.util;

import java.util.HashMap;
import java.util.Map;

public class UaUtils {

    public static Map<String,String> BROWSER_NAMES=new HashMap<>();

    public static Map<String,String> SPIDER_NAMES=new HashMap<>();
    static {
        BROWSER_NAMES.put("firefox","FireFox");
        BROWSER_NAMES.put("chrome","Chrome");
        BROWSER_NAMES.put("safari","Safari");
        BROWSER_NAMES.put("edge","Edge");
        BROWSER_NAMES.put("trident","IE");
        BROWSER_NAMES.put("spider","爬虫");
        BROWSER_NAMES.put("googlebot","爬虫");
        BROWSER_NAMES.put("bingbot","爬虫");
        BROWSER_NAMES.put("dotbot","爬虫");
        BROWSER_NAMES.put("mj12bot","爬虫");
        BROWSER_NAMES.put("micromessenger","微信");
        BROWSER_NAMES.put("nmap","扫描");

        //华丽的分割线-----------------------------------------
        SPIDER_NAMES.put("baidu","百度");
        SPIDER_NAMES.put("sogou","搜狗");
        SPIDER_NAMES.put("yisou","宜搜");
        SPIDER_NAMES.put("360","360");
        SPIDER_NAMES.put("googlebot","谷歌");
        SPIDER_NAMES.put("bingbot","必应");

    }
    public static String browserIdentify(String ua){
        ua=ua.toLowerCase();
        for(var i:BROWSER_NAMES.keySet()){
            if(ua.contains(i)){
                return BROWSER_NAMES.get(i);
            }
        }

        return "未知";
    }

    public static String getSpider(String UA) {
        UA=UA.toLowerCase();
        if(UA==null) {
            return "未知";
        }
        for(var i:SPIDER_NAMES.keySet()){
            if(UA.contains(i)){
                return SPIDER_NAMES.get(i);
            }
        }
        return "未知";
    }
}
