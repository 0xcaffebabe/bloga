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
}
