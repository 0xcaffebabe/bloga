package wang.ismy.bloga.service.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.ismy.bloga.dao.OverviewDao;
import wang.ismy.bloga.entity.Region;
import wang.ismy.bloga.util.UaUtils;

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
}
