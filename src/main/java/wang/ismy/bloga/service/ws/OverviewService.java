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

    public Map<Object,Object> getTodayOverview(){

        var map=overviewDao.getTodayOverview();
        return map;
    }

    public List<Region> getRegion(){
        return overviewDao.getRegionSort();
    }

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
