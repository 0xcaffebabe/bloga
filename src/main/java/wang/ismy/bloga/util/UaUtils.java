package wang.ismy.bloga.util;

public class UaUtils {

    public static String[] BROWSER_NAMES={"firefox","chrome","safari","edge"};
    public static String browserIdentify(String ua){
        ua=ua.toLowerCase();
        for(var i:BROWSER_NAMES){
            if(ua.contains(i)){
                return i;
            }
        }
        return "未知";
    }
}
