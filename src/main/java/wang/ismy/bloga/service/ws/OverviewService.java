package wang.ismy.bloga.service.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.ismy.bloga.dao.OverviewDao;
import wang.ismy.bloga.entity.Region;
import wang.ismy.bloga.util.UaUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OverviewService {

    @Autowired
    private OverviewDao overviewDao;

    //获取今日数据概览
    public Map<Object,Object> getTodayOverview(){
        var map=overviewDao.getTodayOverview();
        return map;
    }

    //获取N日前数据概览
    public Map<Object,Object> getOlderOverview(Integer older){
        if(older==null || older<1){
            older=1;
        }
        var map=overviewDao.getOlderOverview(older);
        var ret=new HashMap<Object,Object>();
        for(var i:map){
            ret.put(i.get("name"),i.get("COUNT(*)"));
        }
        return ret;
    }
    //获取访客地区数据
    public List<Region> getRegion(){
        return overviewDao.getRegionSort();
    }
    //获取访客浏览器数据
    public Map<String,Integer> getBrowser(){
        var ret=new HashMap<String,Integer>();
        var list=overviewDao.getBrowsers();
        for(var i:list){
            try{
                String browserName=UaUtils.browserIdentify(i.get("ua").toString());
                Integer count= Integer.parseInt(i.get("COUNT(ua)").toString());
                if(ret.containsKey(browserName)){
                    ret.put(browserName,count+ret.get(browserName));
                }else{
                    ret.put(browserName,count);
                }
            }catch (Exception e){

            }

        }
        return ret;
    }
    //获取今日各时段访问量数据
    public Map<String,Object> getTimeInterval(){
        var list=overviewDao.getTimeInterval();
        var ret=new HashMap<String,Object>();
        for (int i = 0; i < 24; i++) {
            ret.put(String.valueOf(i),0);
        }
        for(var i:list){
            ret.put(i.get("HOUR(time)").toString(),i.get("COUNT(id)"));
        }
        return ret;
    }

    //获取今日蜘蛛数据
    public Map<String,Long> getTodaySpider() {
        var list=overviewDao.getTodaySpider();
        var ret=new HashMap<String,Long>();
        for(var m:list){
            var spider=UaUtils.getSpider(m.get("ua").toString());
            if(ret.containsKey(spider)){
                ret.put(spider, (Long) m.get("COUNT(id)")+ret.get(spider));
            }else{
                ret.put(spider, (Long) m.get("COUNT(id)"));
            }

        }
        return ret;
    }

//    历史蜘蛛数据
    public Map<String,Long> getWholeSpider() {
        var list=overviewDao.getWholeSpider();
        var ret=new HashMap<String,Long>();
        for(var m:list){
            var spider=UaUtils.getSpider(m.get("ua").toString());
            if(ret.containsKey(spider)){
                ret.put(spider, (Long) m.get("COUNT(id)")+ret.get(spider));
            }else{
                ret.put(spider, (Long) m.get("COUNT(id)"));
            }

        }
        return ret;
    }

    //蜘蛛最爱的页面
    public Object getTop10() {
        var list=overviewDao.getTop10();
        var ret=new ArrayList<HashMap<String,Long>>();
        for(var m:list){
            var t=new HashMap<String,Long>();

            t.put(m.get("url").toString(),(Long) m.get("COUNT(id)"));

            ret.add(t);

        }
        return ret;
    }

    //最近7日蜘蛛请求数
    public Object getTend() {
        return overviewDao.getTend();

    }

    //各时间段蜘蛛请求数
    public Object getInterval() {
        return overviewDao.getInterval();
    }

//    当日性能数据
    public Map<String,BigDecimal> performanceToday() {
        var list=overviewDao.performanceToday();
        var ret=new HashMap<String,BigDecimal>();
        for(var i:list){
            ret.put(i.get("name").toString(), (BigDecimal) i.get("number"));
        }
        return ret;
    }

//    当日SQL各时段执行数
    public List<Long> performanceInterval() {
        var list= overviewDao.performanceInterval();
        var ret=new ArrayList<Long>();
        for(int i=0;i<24;i++){
            ret.add(0L);
        }
        for(var i:list){
            ret.set((Integer) i.get("hour"),(Long)i.get("number"));
        }
        return ret;
    }


//    当日访客数据
    public Map<String,BigDecimal> getVisitorOver() {
        var list=overviewDao.getVisitorOver();
        var ret=new HashMap<String,BigDecimal>();
        for(var i:list){
            ret.put(i.get("name").toString(),(BigDecimal)i.get("number"));
        }
        return ret;
    }

//    访客排行榜
    public List<Map<String,Long>> getVisitorTop() {
        var list=overviewDao.getVisitorTop();
        var ret=new ArrayList<Map<String,Long>>();
        for(var m:list){
            var t=new HashMap<String,Long>();
            t.put(m.get("ip").toString(),(Long)m.get("number"));
            ret.add(t);
        }
        return ret;
    }

//    访客最爱的页面
    public Map<String,Long> getVisitorPage() {
        var list= overviewDao.getVisitorPage();
        var ret=new HashMap<String,Long>();
        for(var i:list){
            ret.put(i.get("url").toString(),(Long)i.get("number"));
        }
        return ret;
    }
}
