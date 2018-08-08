package wang.ismy.bloga.dao.inter;


import org.apache.ibatis.annotations.Mapper;
import wang.ismy.bloga.entity.Region;

import java.util.List;
import java.util.Map;

@Mapper
public interface IOverview {

    List<Map<String,Object>> getTodayOverview();

    List<Region> getRegionSort();

    List<Map<String,Object>> getBrowsers();

    List<Map<String,Object>> getTimeInterval();

    List<Map<Object, Object>> getOlderOverview(Integer older);

    List<Map<String,Object>> getTodaySpider();

    List<Map<String,Object>> getWholeSpider();

    List<Map<String,Object>> getTop10();

    List<Integer> getTend();

    List<Integer> getInterval();

    List<Map<String,Object>> performanceToday();

    List<Map<String,Object>> performanceInterval();

    List<Map<String,Object>> getVisitorOver();

    List<Map<String,Object>> getVisitorTop();

    List<Map<String,Object>> getVisitorPage();
}
