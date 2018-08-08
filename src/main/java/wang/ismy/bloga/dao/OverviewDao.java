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

    public List<Map<String,Object>> getTodaySpider() {
        return iOverview.getTodaySpider();
    }

    public List<Map<String,Object>> getWholeSpider() {
        return iOverview.getWholeSpider();
    }

    public List<Map<String,Object>> getTop10() {
        return iOverview.getTop10();
    }

    public Object getTend() {
        return iOverview.getTend();
    }

    public Object getInterval() {
        return iOverview.getInterval();
    }

    public List<Map<String,Object>> performanceToday() {
        return iOverview.performanceToday();
    }

    public List<Map<String,Object>> performanceInterval() {
        return iOverview.performanceInterval();
    }

    public List<Map<String,Object>> getVisitorOver() {
        return iOverview.getVisitorOver();
    }

    public List<Map<String,Object>> getVisitorTop() {
        return iOverview.getVisitorTop();
    }

    public List<Map<String,Object>> getVisitorPage() {
        return iOverview.getVisitorPage();
    }
}
