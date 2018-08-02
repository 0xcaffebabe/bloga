package wang.ismy.bloga.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import wang.ismy.bloga.dao.inter.IOverview;
import wang.ismy.bloga.entity.Region;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OverviewDao {

    @Autowired
    private IOverview iOverview;

    public Map<Object, Object> getTodayOverview(){
        var map=iOverview.getTodayOverview();
        var ret=new HashMap<Object,Object>();
        for(var i:map){
            ret.put(i.get("name"),i.get("COUNT(*)"));
        }
        return ret;
    }

    public List<Region> getRegionSort(){
        return iOverview.getRegionSort();
    }

    public List<Map<String,Object>> getBrowsers() {
        return iOverview.getBrowsers();
    }

    public List<Map<String,Object>> getTimeInterval() {
        return iOverview.getTimeInterval();
    }

    public List<Map<Object,Object>> getOlderOverview(Integer older) {
        return iOverview.getOlderOverview(older);
    }
}
